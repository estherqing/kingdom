package com.vivo.jovi.exscene.api.service.model.vo;

import java.util.List;

/**
 *@description: 传给客户端的调研卡片
 *@author: Lu Guodong
 *@CreateDate: 2019-05-17
 */
public class QuestionnaireDetailVO {

    private String questionnaireId;

    /**是否需要进行抽奖，0:没有抽奖环节;1:有抽奖环节;*/
    private Integer isReward;

    private QuestionnaireDescVO questionnaireDesc;

    private List<QuestionVO> questionList;

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public List<QuestionVO> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionVO> questionList) {
        this.questionList = questionList;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public QuestionnaireDescVO getQuestionnaireDesc() {
        return questionnaireDesc;
    }

    public void setQuestionnaireDesc(QuestionnaireDescVO questionnaireDesc) {
        this.questionnaireDesc = questionnaireDesc;
    }
}
