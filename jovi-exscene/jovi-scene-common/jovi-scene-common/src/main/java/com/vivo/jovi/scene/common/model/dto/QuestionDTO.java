package com.vivo.jovi.scene.common.model.dto;

/**
 * @Classname QuestionQTO
 * @Description TODO
 * @Date 2019-05-15 15:24
 * @Created by Administrator
 * @Version 1.0
 */
public class QuestionDTO  {

    private Long id;

    private String questionnaireId;

    private String questionId;

    private String content;

    private Integer type;

    private String language;

    private Integer isRequired;

    private String answer;

    private String remark;

    private Integer position;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "QuestionQTO{" +
                "id=" + id +
                ", questionnaireId='" + questionnaireId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", language=" + language +
                ", isRequired=" + isRequired +
                ", answer='" + answer + '\'' +
                ", remark='" + remark + '\'' +
                ", position=" + position +
                '}';
    }
}
