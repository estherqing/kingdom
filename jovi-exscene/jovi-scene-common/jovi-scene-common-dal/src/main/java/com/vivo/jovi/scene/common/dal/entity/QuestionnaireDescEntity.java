package com.vivo.jovi.scene.common.dal.entity;

public class QuestionnaireDescEntity {
    private Long id;

    private String questionnaireId;

    private String language;

    /**要翻译的语言 **/
    private String translateLanguage;

    private String title;

    private String description;

    /**
     * 提示语
     */
    private String cueWord;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCueWord() {
        return cueWord;
    }

    public void setCueWord(String cueWord) {
        this.cueWord = cueWord;
    }

    public String getTranslateLanguage() {
        return translateLanguage;
    }

    public void setTranslateLanguage(String translateLanguage) {
        this.translateLanguage = translateLanguage;
    }
}