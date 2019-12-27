package com.vivo.jovi.exscene.backend.service;

import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.domain.basic.QuestionnaireTranslationBO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public interface IQuestionnaireTranslationService {

    XSSFWorkbook createQuestionnaireToExcel(HttpServletResponse response, QuestionnaireTranslationBO questionnaireTranslationBo) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException;

    CommonVO importTextTranslationData(String questionnaireId, InputStream in) throws Exception;
}
