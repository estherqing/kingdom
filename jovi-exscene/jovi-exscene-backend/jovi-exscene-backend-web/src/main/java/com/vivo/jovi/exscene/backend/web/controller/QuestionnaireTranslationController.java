package com.vivo.jovi.exscene.backend.web.controller;

import com.vivo.framework.spring.webmvc.CommonVORetcodeEnum;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.exscene.backend.service.IPublishService;
import com.vivo.jovi.exscene.backend.service.IQuestionnaireTranslationService;
import com.vivo.jovi.exscene.backend.web.filter.ThreadLocalSSOUser;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import com.vivo.jovi.scene.common.dal.dao.IQuestionnaireDao;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireEntity;
import com.vivo.jovi.scene.common.domain.basic.QuestionnaireTranslationBO;
import com.vivo.jovi.scene.common.util.DateUtil;
import com.vivo.jovi.scene.common.util.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * @author huhan
 * @description 问卷翻译
 * @date 2019-05-06 15:18
 */
@Controller
@RequestMapping("exscene")
public class QuestionnaireTranslationController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireTranslationController.class);

    @Autowired
    private IQuestionnaireTranslationService questionnaireTranslationService;

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private IPublishService publishService;

    @RequestMapping(value = "downloadTextToExcel")
    @ResponseBody
    public CommonVO downloadTextToExcel(HttpServletResponse response, QuestionnaireTranslationBO questionnaireTranslationBo) {
        if (StringUtils.isBlank(questionnaireTranslationBo.getQuestionnaireId())) {
            return CommonVO.badParams("QuestionnaireId must not be null");
        }

        XSSFWorkbook workbook;
        BufferedOutputStream bos = null;
        try {
            workbook = questionnaireTranslationService.createQuestionnaireToExcel(response, questionnaireTranslationBo);
            bos = new BufferedOutputStream(response.getOutputStream());
            bos.flush();
            workbook.write(bos);
            //修改问卷的状态为 -翻译待导入
            QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
            questionnaireEntity.setStatus(QuestionnaireStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus());
            questionnaireEntity.setQuestionnaireId(questionnaireTranslationBo.getQuestionnaireId());
            questionnaireDao.updateByPrimaryKeySelective(questionnaireEntity);
            return CommonVO.success();
        } catch (Exception e) {
            return handleException(e, "exscene/downloadTextToExcel");
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("importTextTranslationData")
    @ResponseBody
    public CommonVO importTextTranslationData(@RequestParam(value = "importFile") MultipartFile importFile,
                                              QuestionnaireTranslationBO questionnaireTranslationBo) {
        try {
            if (importFile.isEmpty()) {
                return CommonVO.badParams("文件不存在！");
            }
            String filename = importFile.getOriginalFilename();
            String docSuffix = filename.substring(filename.lastIndexOf(".") + 1);
            if (!"xlsx".equals(docSuffix)) {
                return CommonVO.badParams("上传的文件以'.xlsx'结尾！");
            }

            String questionnaireId = filename.substring(filename.indexOf("-") + 1, filename.lastIndexOf("-"));
            if (!questionnaireId.equals(questionnaireTranslationBo.getQuestionnaireId())) {
                return CommonVO.badParams("excel文件和该调查问卷不对应！");
            }

            InputStream in = importFile.getInputStream();
            CommonVO commonVO = questionnaireTranslationService.importTextTranslationData(questionnaireId, in);

            //修改问卷的状态为 -翻译已导入
            QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();
            questionnaireEntity.setStatus(QuestionnaireStatusEnum.TRANSLATION_TO_BE_IMPORTED.getStatus());
            questionnaireEntity.setQuestionnaireId(questionnaireId);
            // 上传翻译文件到
            Map<String, Object> map = publishService.uploadTranslateFile(importFile);
            String translateFileName = (String) map.get("fileName");
            String translateFileUrl = (String) map.get("fileUrl");
            questionnaireEntity.setTranslateFileName(translateFileName);
            questionnaireEntity.setTranslateFileUrl(translateFileUrl);
            questionnaireDao.updateByPrimaryKeySelective(questionnaireEntity);
            return commonVO;
        } catch (Exception e) {
            LOGGER.error("importTextTranslationData error, e : {}", e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "翻译导入失败！");
        }
    }

}
