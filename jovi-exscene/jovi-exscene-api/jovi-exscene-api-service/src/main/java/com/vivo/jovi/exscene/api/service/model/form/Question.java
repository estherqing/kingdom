package com.vivo.jovi.exscene.api.service.model.form;

public class Question {

    /**
     * 问题id
     */
    private String questionId;

    /**
     * 问题类型0：单选，1：多选，2：填空
     */
    private Integer type;

    /**
     * 答案
     */
    private String answer;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
