package com.vivo.jovi.scene.common.vo.questionnaire;

import java.util.List;

/**
 * @author huhan
 * @description
 * @date 2019-05-16 11:19
 */
public class QuestionInfoVO {

    private String questionId;

    /**
     * 问题
     */
    private String question;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 问答题的答案数量
     */
    private Integer totalNum;

    /**
     * 答案统计信息
     */
    private List<AnswerVO> answerInfo;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<AnswerVO> getAnswerInfo() {
        return answerInfo;
    }

    public void setAnswerInfo(List<AnswerVO> answerInfo) {
        this.answerInfo = answerInfo;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}
