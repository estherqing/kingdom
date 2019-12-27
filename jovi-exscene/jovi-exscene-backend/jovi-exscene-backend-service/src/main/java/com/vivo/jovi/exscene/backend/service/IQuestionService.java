package com.vivo.jovi.exscene.backend.service;

import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author huhan
 * @description
 * @date 2019-05-16 15:39
 */
public interface IQuestionService {
    /**
     * 获取问卷数据
     * @param questionnaireBO
     */
    CommonVO getQuestionInfo(QuestionnaireBO questionnaireBO);

    /**
     * 问答题回答情况导出
     * @param questionnaireBO
     */
    XSSFWorkbook createTextQuestionToExcel(QuestionnaireBO questionnaireBO) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException;

    /**
     * 文件详情导出
     * @param questionnaireBO
     */
    XSSFWorkbook createQuestionDetailToExcel(QuestionnaireBO questionnaireBO) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException;
}
