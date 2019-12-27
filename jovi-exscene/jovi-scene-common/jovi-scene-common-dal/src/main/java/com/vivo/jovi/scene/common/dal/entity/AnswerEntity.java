package com.vivo.jovi.scene.common.dal.entity;

public class AnswerEntity {
    private Long id;

    private String questionnaireId;

    private String questionId;

    private Integer type;

    private String language;

    private String answer;

    private String userId;

    private QuestionnaireUserEntity questionnaireUserEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public QuestionnaireUserEntity getQuestionnaireUserEntity() {
        return questionnaireUserEntity;
    }

    public void setQuestionnaireUserEntity(QuestionnaireUserEntity questionnaireUserEntity) {
        this.questionnaireUserEntity = questionnaireUserEntity;
    }

    @Override
    public String toString() {
        return "AnswerEntity{" +
                "id=" + id +
                ", questionnaireId='" + questionnaireId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", type=" + type +
                ", language=" + language +
                ", answer='" + answer + '\'' +
                ", userId='" + userId + '\'' +
                ", questionnaireUserEntity='" + questionnaireUserEntity + '\'' +
                '}';
    }
}