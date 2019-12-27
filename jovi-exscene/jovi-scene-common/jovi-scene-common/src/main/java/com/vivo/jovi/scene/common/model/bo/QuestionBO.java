package com.vivo.jovi.scene.common.model.bo;

/**
 * @Classname QuestionBO
 * @Description TODO
 * @Date 2019-05-09 17:29
 * @Created by Administrator
 * @Version 1.0
 */
public class QuestionBO {

    private String content;

    private String questionnaireId;

    private String questionId;

    private Integer type;

    private String language;

    private String translateLanguage;

    private Integer isRequired;

    private String answer;

    private String remark;

    private Integer position;

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

    public String getTranslateLanguage() {
        return translateLanguage;
    }

    public void setTranslateLanguage(String translateLanguage) {
        this.translateLanguage = translateLanguage;
    }
}
