package com.vivo.jovi.exscene.backend.web.controller;

import com.vivo.framework.spring.webmvc.CommonVORetcodeEnum;
import com.vivo.jovi.exscene.backend.service.IQuestionService;
import com.vivo.jovi.exscene.backend.service.IQuestionnaireUserService;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.util.DateUtil;
import com.vivo.jovi.scene.common.util.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author huhan
 * @description
 * @date 2019-05-14 16:09
 */
@Controller
@RequestMapping("exscene")
public class DataViewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataViewController.class);

    @Autowired
    private IQuestionnaireUserService questionnaireUserService;

    @Autowired
    private IQuestionService questionService;

    @RequestMapping(value = "getStatisticalInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonVO getStatisticalInfo(QuestionnaireBO questionnaireBO) {
        try {
            if (StringUtils.isBlank(questionnaireBO.getQuestionnaireId())) {
                return CommonVO.badParams("questionnaireId must not be null");
            }
            CommonVO result = questionnaireUserService.getStatisticalInfo(questionnaireBO);

            return result;
        } catch (Exception e) {
            LOGGER.error("getStatisticalInfo error, questionnaireId is {}", questionnaireBO.getQuestionnaireId(), e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
        }
    }

    @RequestMapping(value = "getQuestionInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonVO getQuestionInfo(QuestionnaireBO questionnaireBO) {
        try {
            if (StringUtils.isBlank(questionnaireBO.getQuestionnaireId())) {
                return CommonVO.badParams("questionnaireId must not be null");
            }
            questionnaireBO.setTask(false);
            CommonVO commonVO = questionService.getQuestionInfo(questionnaireBO);

            return commonVO;
        } catch (Exception e) {
            LOGGER.error("getQuestionInfo error, questionnaireId is {}", questionnaireBO.getQuestionnaireId(), e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
        }
    }

    @RequestMapping(value = "downloadTextQuestion", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO downloadTextQuestion(QuestionnaireBO questionnaireBO, HttpServletResponse response) {
        if (StringUtils.isBlank(questionnaireBO.getQuestionnaireId())) {
            return CommonVO.badParams("questionnaireId must not be null");
        }

        if (StringUtils.isBlank(questionnaireBO.getQuestionId())) {
            return CommonVO.badParams("questionId must not be null");
        }

        if (validDownloadNumber(questionnaireBO.getStart(), questionnaireBO.getEnd())) {
            return CommonVO.badParams("The number of downloads should not exceed 500");
        }

        try {
            // 标题： 文本类型题回答详情_问卷id_ 问题id_当前时间(yyyy-MM-dd).xlsx
            ExcelUtils.setHeader(response, "文本类型题回答详情_" + questionnaireBO.getQuestionnaireId()
                    + "_" + questionnaireBO.getQuestionId() + "_" + DateUtil.formatDate(new Date()) + ".xlsx");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("downloadTextQuestion error, questionnaireId is {} and questionId is {}", questionnaireBO.getQuestionnaireId(),
                    questionnaireBO.getQuestionId(), e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
        }

        XSSFWorkbook workbook;
        try {
            workbook = questionService.createTextQuestionToExcel(questionnaireBO);
        } catch (IllegalArgumentException | IllegalAccessException
                | InvocationTargetException | IntrospectionException e) {
            LOGGER.error("获取文本类型回答详情失败： questionnaireId is {} and questionId is {}", questionnaireBO.getQuestionnaireId(),
                    questionnaireBO.getQuestionId(), e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
        }

        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(response.getOutputStream());
            bos.flush();
            workbook.write(bos);
            return CommonVO.success();
        } catch (IOException e) {
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
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

    @RequestMapping(value = "downloadQuestionDetail", method = RequestMethod.POST)
    @ResponseBody
    public CommonVO downloadQuestionDetail(QuestionnaireBO questionnaireBO, HttpServletResponse response) {
        if (StringUtils.isBlank(questionnaireBO.getQuestionnaireId())) {
            return CommonVO.badParams("questionnaireId must not be null");
        }

        if (validDownloadNumber(questionnaireBO.getStart(), questionnaireBO.getEnd())) {
            return CommonVO.badParams("The number of downloads should not exceed 500");
        }

        try {
            // 标题： 问卷详情_问卷id_当前时间(yyyy-MM-dd).xlsx
            ExcelUtils.setHeader(response, "问卷详情_" + questionnaireBO.getQuestionnaireId()
                    + "_" + DateUtil.formatDate(new Date()) + ".xlsx");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("downloadTextQuestion error, questionnaireId is {}", questionnaireBO.getQuestionnaireId(), e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
        }

        XSSFWorkbook workbook;
        try {
            workbook = questionService.createQuestionDetailToExcel(questionnaireBO);
        } catch (IllegalArgumentException | IllegalAccessException
                | InvocationTargetException | IntrospectionException e) {
            LOGGER.error("获取问卷详情失败： questionnaireId is {}", questionnaireBO.getQuestionnaireId(), e);
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
        }

        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(response.getOutputStream());
            bos.flush();
            workbook.write(bos);
            return CommonVO.success();
        } catch (IOException e) {
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "server error:" + e.getMessage());
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

    private boolean validDownloadNumber(Integer start, Integer end) {
        return end - start > 500 ? true : false;
    }
}