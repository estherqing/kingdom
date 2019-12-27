package com.vivo.jovi.exscene.backend.service.impl;

import com.vivo.jovi.exscene.backend.service.IQuestionService;
import com.vivo.jovi.exscene.backend.service.IQuestionnaireUserService;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.dal.dao.IAnswerDao;
import com.vivo.jovi.scene.common.dal.dao.IQuestionDao;
import com.vivo.jovi.scene.common.dal.dao.IQuestionnaireUserDao;
import com.vivo.jovi.scene.common.dal.entity.AnswerEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireUserEntity;
import com.vivo.jovi.scene.common.domain.basic.ExcelBean;
import com.vivo.jovi.scene.common.domain.basic.TextQuestionBO;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.util.ExcelUtils;
import com.vivo.jovi.scene.common.vo.questionnaire.QuestionInfoVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author huhan
 * @description
 * @date 2019-05-16 15:39
 */
@Service
public class QuestionService implements IQuestionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    private IQuestionDao questionDao;

    @Autowired
    private IAnswerDao answerDao;

    @Autowired
    private IQuestionnaireUserDao questionnaireUserDao;

    @Autowired
    private IQuestionnaireUserService questionnaireUserService;

    @Override
    public CommonVO getQuestionInfo(QuestionnaireBO questionnaireBO) {
        Map<String, List<QuestionInfoVO>> questions = new HashMap<>();
        List<QuestionInfoVO> questionInfoVOS = new ArrayList<>();

        // 查询问题信息
        List<QuestionEntity> questionEntities = questionDao.selectByIdAndLanguage(questionnaireBO.getQuestionnaireId(), questionnaireBO.getLanguage());
        for (QuestionEntity questionEntity : questionEntities) {
            questionInfoVOS = questionnaireUserService.statisticalAnswer(questionnaireBO, questionEntity, questionnaireBO.isTask(), questionInfoVOS);
        }
        questions.put("questions", questionInfoVOS);
        return CommonVO.success(questions);
    }

    @Override
    public XSSFWorkbook createTextQuestionToExcel(QuestionnaireBO questionnaireBO) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException {

        List<TextQuestionBO> tarList = new ArrayList<>();
        List<AnswerEntity> answerEntities = answerDao.selectAnswerAndUserInfo(questionnaireBO);
        for (AnswerEntity answerEntity : answerEntities) {
            TextQuestionBO textQuestionBO = new TextQuestionBO();
            textQuestionBO.setModel(answerEntity.getQuestionnaireUserEntity().getModel());
            textQuestionBO.setAndroidVersion(answerEntity.getQuestionnaireUserEntity().getAndroidVersion());
            textQuestionBO.setAnswerTime(answerEntity.getQuestionnaireUserEntity().getAnswerTime());
            textQuestionBO.setAnswer(answerEntity.getAnswer());

            tarList.add(textQuestionBO);
        }

        List<ExcelBean> ebs = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        ebs.add(new ExcelBean("机型信息", "model", 0));
        ebs.add(new ExcelBean("安卓版本", "androidVersion", 0));
        ebs.add(new ExcelBean("答题时间", "answerTime", 0));
        ebs.add(new ExcelBean("该问题的回答情况", "answer", 0));

        map.put(0, ebs);

        return ExcelUtils.createExcelFile(TextQuestionBO.class, tarList, map, "文本类型问卷回答情况", false);
    }

    @Override
    public XSSFWorkbook createQuestionDetailToExcel(QuestionnaireBO questionnaireBO) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException {
        List<QuestionnaireUserEntity> questionnaireUserEntities = questionnaireUserDao.selectDetailByQuestionnaireId(questionnaireBO);

        List<ExcelBean> ebs = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        ebs.add(new ExcelBean("姓名", "name", 0));
        ebs.add(new ExcelBean("电话", "phoneNum", 0));
        ebs.add(new ExcelBean("邮箱", "email", 0));
        ebs.add(new ExcelBean("机型信息", "model", 0));
        ebs.add(new ExcelBean("安卓版本", "androidVersion", 0));
        ebs.add(new ExcelBean("答题时间", "answerTime", 0));

        map.put(0, ebs);

        return ExcelUtils.createExcelFile(QuestionnaireUserEntity.class, questionnaireUserEntities, map, "问卷详情", false);
    }

}
