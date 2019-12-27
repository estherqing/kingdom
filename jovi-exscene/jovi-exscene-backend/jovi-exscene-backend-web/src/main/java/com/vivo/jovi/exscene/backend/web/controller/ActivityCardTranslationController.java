package com.vivo.jovi.exscene.backend.web.controller;

import com.vivo.framework.spring.webmvc.CommonVORetcodeEnum;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.exscene.backend.service.IActivityCardTranslationService;
import com.vivo.jovi.exscene.backend.service.IPublishService;
import com.vivo.jovi.exscene.backend.web.filter.ThreadLocalSSOUser;
import com.vivo.jovi.scene.common.ActivityCardBizErrorCode;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.constant.activitycard.ActivityCardConstant;
import com.vivo.jovi.scene.common.constant.activitycard.ActivityCardStatusEnum;
import com.vivo.jovi.scene.common.dal.dao.IExActivityCardDao;
import com.vivo.jovi.scene.common.dal.entity.ExActivityCardEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author zhongjiajun
 * @date 2019/12/3 16:25
 * @describe 活动卡片通知消息翻译
 */
@Controller
@RequestMapping("exscene/activity/card")
@Slf4j
public class ActivityCardTranslationController extends BaseController {
    @Autowired
    private IActivityCardTranslationService iActivityCardTranslationService;
    @Autowired
    private IPublishService publishService;
    @Autowired
    private IExActivityCardDao exActivityCardDao;

    /**
     * 下载活动卡片通知消息
     */
    @RequestMapping(value = "downloadNotice", method = GET)
    @ResponseBody
    public CommonVO downloadTextToExcel(HttpServletResponse response, @RequestParam Long id) {
        if (id == null) {
            return CommonVO.badParams("id不可为空");
        }
        ExActivityCardEntity entity = exActivityCardDao.selectByPrimaryKey(id);
        if (entity == null) {
            return CommonVO.error(ActivityCardBizErrorCode.ACTIVIYT_CARD_NOT_EXIST, "活动卡片不存在");
        }
        if (entity.getStatus() != ActivityCardStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus()) {
            return CommonVO.error(ActivityCardBizErrorCode.OPERATE_AUTHORITY_LIMIT, "当前状态不可导出文件");
        }
        XSSFWorkbook workbook;
        BufferedOutputStream bos = null;
        try {
            workbook = iActivityCardTranslationService.exportNoticeToExcel(response, id);
            bos = new BufferedOutputStream(response.getOutputStream());
            bos.flush();
            workbook.write(bos);
            return CommonVO.success();
        } catch (Exception e) {
            log.info("download exception:" + e);
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

    /**
     * 上传活动卡片通知消息翻译以后的信息
     */
    @RequestMapping("uploadTranslateNotice")
    @ResponseBody
    public CommonVO importTextTranslationData(@RequestParam(value = "importFile") MultipartFile importFile, @RequestParam Long id) {
        try {
            if (importFile.isEmpty()) {
                return CommonVO.badParams("文件不存在！");
            }
            if (id == null) {
                return CommonVO.badParams("id不可为空");
            }
            ExActivityCardEntity entity = exActivityCardDao.selectByPrimaryKey(id);
            if (entity == null) {
                return CommonVO.error(ActivityCardBizErrorCode.ACTIVIYT_CARD_NOT_EXIST, "活动卡片不存在");
            }
            if (entity.getStatus() != ActivityCardStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus()) {
                return CommonVO.error(ActivityCardBizErrorCode.OPERATE_AUTHORITY_LIMIT, "当前状态不可导入文件");
            }
            String filename = importFile.getOriginalFilename();
            String docSuffix = filename.substring(filename.lastIndexOf(".") + 1);
            if (!StringUtils.equals(docSuffix, ActivityCardConstant.TO_BE_IMPORTED_FORMAT)) {
                return CommonVO.badParams("上传的文件以'.xlsx'结尾！");
            }
            InputStream in = importFile.getInputStream();

            CommonVO commonVO = iActivityCardTranslationService.importNoticeTranslationData(id, in);

            // 上传翻译文件到OSS
            Map<String, Object> map = publishService.uploadTranslateFile(importFile);
            String translateFileName = (String) map.get("fileName");
            String translateFileUrl = (String) map.get("fileUrl");
            ExActivityCardEntity exActivityCardEntity = new ExActivityCardEntity();
            exActivityCardEntity.setTranslateFileName(translateFileName);
            exActivityCardEntity.setTranslateFileUrl(translateFileUrl);
            //修改问卷的状态为 -翻译已导入
            exActivityCardEntity.setStatus(ActivityCardStatusEnum.AWAIT_AUDIT.getStatus());
            exActivityCardEntity.setId(id);
            SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
            exActivityCardEntity.setModifyUserId(ssoUser.getUserId());
            exActivityCardEntity.setModifyUserName(ssoUser.getUserName());
            exActivityCardDao.updateSelectiveByPrimaryKey(exActivityCardEntity);
            return commonVO;
        } catch (Exception e) {
            log.error("importTextTranslationData error, e : {}", e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "翻译导入失败！");
        }
    }
}
