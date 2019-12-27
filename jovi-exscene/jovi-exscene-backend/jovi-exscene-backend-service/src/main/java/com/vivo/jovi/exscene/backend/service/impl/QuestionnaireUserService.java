package com.vivo.jovi.exscene.backend.service.impl;

import com.vivo.framework.spring.webmvc.CommonVORetcodeEnum;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IQuestionnaireUserService;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.dal.dao.*;
import com.vivo.jovi.scene.common.dal.entity.*;
import com.vivo.jovi.scene.common.model.bo.QuestionnaireBO;
import com.vivo.jovi.scene.common.vo.questionnaire.AnswerVO;
import com.vivo.jovi.scene.common.vo.questionnaire.QuestionInfoVO;
import com.vivo.jovi.scene.common.vo.questionnaire.QuestionnaireInfoVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;

/**
 * @author huhan
 * @description
 * @date 2019-05-14 16:18
 */
@Service
public class QuestionnaireUserService implements IQuestionnaireUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireUserService.class);

    @Autowired
    private IQuestionnaireUserDao questionnaireUserDao;

    @Autowired
    private IExPublishDao publishDao;

    @Autowired
    private IAnswerDao answerDao;

    @Autowired
    private IQuestionDao questionDao;

    @Autowired
    private IQuestionnaireDescDao questionnaireDescDao;

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private IAnswerCountDao answerCountDao;

    @Override
    public CommonVO getStatisticalInfo(QuestionnaireBO questionnaireBO) {
        QuestionnaireInfoVO questionnaireInfoVO = new QuestionnaireInfoVO();
        Set<Integer> sex = new HashSet<>();
        List<String> age = new LinkedList<>();
        Set<String> model = new HashSet<>();
        Set<String> profession = new HashSet<>();

        // 获取问卷信息
        QuestionnaireDescEntity questionnaireDescEntity = questionnaireDescDao.selectByIdAndLanguage(questionnaireBO.getQuestionnaireId(), questionnaireBO.getLanguage(), null);
        if (questionnaireDescEntity == null) {
            LOGGER.error("没有找到该问卷信息, questionnaireId is {}, language is {}", questionnaireBO.getQuestionnaireId(), questionnaireBO.getLanguage());
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "没有找到该问卷信息");
        }
        questionnaireInfoVO.setTitle(questionnaireDescEntity.getTitle());
        questionnaireInfoVO.setQuestionnaireId(questionnaireBO.getQuestionnaireId());

        // 获取回收答案总数
        long answerCount = questionnaireUserDao.count(questionnaireBO.getQuestionnaireId());
        questionnaireInfoVO.setAnswerCount(answerCount);

        // 实际下发量
        List<ExPublishEntity> publishEntityList = publishDao.selectByBizId(questionnaireBO.getQuestionnaireId());
        if (CollectionUtils.isNotEmpty(publishEntityList)) {
            questionnaireInfoVO.setActualRelease(publishEntityList.get(0).getActualRelease());
        }

        // 获取该问卷用户信息
        List<QuestionnaireUserEntity> questionnaireUserEntities = questionnaireUserDao.selectByQuestionnaireId(questionnaireBO.getQuestionnaireId());
        for (QuestionnaireUserEntity entity : questionnaireUserEntities) {
            // 设置机型
            model.add(entity.getModel());
            profession.add(entity.getProfession());
        }

        // 设置性别和年龄
        sex.add(0);
        sex.add(1);
        String ages = VivoConfigManager.getString("exscene.questionnaire.age", "小于16岁|17-20岁|21-25岁|26-30岁|31-35岁|36-40岁|41-45岁|大于46岁");
        String[] ageArray = ages.split("\\|");
        for (String ageStr : ageArray) {
            age.add(ageStr.trim());
        }

        // 查询该问卷是否看抽奖
        Integer isReward = questionnaireDao.selectIsReward(questionnaireBO.getQuestionnaireId());

        // 查询该问卷用户数量
        Long totalUserNum = questionnaireUserDao.count(questionnaireBO.getQuestionnaireId());

        questionnaireInfoVO.setSex(sex);
        questionnaireInfoVO.setAge(age);
        questionnaireInfoVO.setModel(model);
        questionnaireInfoVO.setIsReward(isReward);
        questionnaireInfoVO.setTotalUserNum(totalUserNum);

        return CommonVO.success(questionnaireInfoVO);
    }

    /**
     * 统计用户回答的答案
     *
     */
    @Override
    public List<QuestionInfoVO> statisticalAnswer(QuestionnaireBO questionnaireBO, QuestionEntity questionEntity, boolean isTask, List<QuestionInfoVO> questionInfoVOS) {
        QuestionInfoVO questionInfoVO = new QuestionInfoVO();
        questionInfoVO.setQuestionId(questionEntity.getQuestionId());
        questionInfoVO.setQuestion(questionEntity.getContent());
        questionInfoVO.setType(questionEntity.getType());
        // 统计答案占比及人数
        List<AnswerVO> answerVOS = new ArrayList<>();
        // 单选类型和多选类型
        if (questionEntity.getType().equals(0) || questionEntity.getType().equals(1)) {
            // 获取答案的总数
            Integer totalAnswerNum = answerDao.findNumByQuestionId(questionnaireBO.getQuestionnaireId(), questionEntity.getQuestionId());

            List<QuestionEntity> questionEntitiesList = questionDao.selectByQuestionnaireIdAndQuestionId(questionEntity);
            for (QuestionEntity entity : questionEntitiesList) {
                String[] answers = entity.getAnswer().split("\\|");
                for (int i = 0; i < answers.length; i++) {
                    AnswerCountEntity answerCountEntity = new AnswerCountEntity();
                    answerCountEntity.setQuestionnaireId(questionnaireBO.getQuestionnaireId());
                    answerCountEntity.setQuestionId(questionEntity.getQuestionId());
                    answerCountEntity.setQuestionPosition(i);
                    answerCountEntity.setSex(questionnaireBO.getSex());
                    answerCountEntity.setAge(questionnaireBO.getAge());
                    answerCountEntity.setModel(questionnaireBO.getModel());
                    List<AnswerCountEntity> selective = answerCountDao.getSelective(answerCountEntity);
                    if (entity.getLanguage().equals(questionnaireBO.getLanguage())) {
                        AnswerVO answerVO = new AnswerVO();
                        answerVO.setAnswer(answers[i]);
                        Integer number = selective == null ? 0 : countAnswerNum(selective);
                        answerVO.setNumbers(number);
                        answerVO.setPercentage(Integer.valueOf(getPercentage(number, totalAnswerNum)));
                        answerVOS.add(answerVO);
                    }
                }
            }

            questionInfoVO.setAnswerInfo(answerVOS);
            questionInfoVOS.add(questionInfoVO);
        } else {
            //文本题
            int totalNum = answerDao.findNumByQuestionId(questionnaireBO.getQuestionnaireId(), questionEntity.getQuestionId());
            questionInfoVO.setTotalNum(totalNum);
            questionInfoVOS.add(questionInfoVO);
        }

        return questionInfoVOS;
    }

    private Integer countAnswerNum(List<AnswerCountEntity> selective) {
        Integer num = 0;
        for (AnswerCountEntity answerCountEntity : selective) {
            num += answerCountEntity.getAnswerCount();
        }
        return num;
    }

    private String getPercentage(Integer div1, Integer div2) {
        if (div1 == 0) {
            return "0";
        }

        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format((float) div1 / (float) div2 * 100);
        return result;
    }
}
