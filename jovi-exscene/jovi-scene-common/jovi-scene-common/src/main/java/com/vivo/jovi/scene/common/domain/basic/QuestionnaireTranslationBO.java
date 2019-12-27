package com.vivo.jovi.scene.common.domain.basic;

/**
 * @author huhan
 * @description
 * @date 2019-05-06 16:07
 */
public class QuestionnaireTranslationBO {

    /**
     * 问卷id
     */
    private String questionnaireId;

    /**
     * 语言类型
     */
    private String language;

    /**
     * 中文
     */
    private String chinese = "";

    /**
     * 英语
     */
    private String english = "";

    /**
     * 印地语
     */
    private String hindi = "";

    /**
     * 提示语
     */
    private String cue;

    /**
     * 问题备注
     */
    private String questionRemark;

    /**
     * excel的备注信息
     */
    private String remark = "";

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCue() {
        return cue;
    }

    public void setCue(String cue) {
        this.cue = cue;
    }

    public String getQuestionRemark() {
        return questionRemark;
    }

    public void setQuestionRemark(String questionRemark) {
        this.questionRemark = questionRemark;
    }
}
