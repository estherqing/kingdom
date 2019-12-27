package com.vivo.jovi.exscene.api.service.model.vo;

/**
 * @description: H5界面获取的调研卡片说明
 * @author: Lu Guodong
 * @CreateDate: 2019-05-21
 */
public class QuestionnaireDescVO {
    private String language;

    private String title;

    private String description;

    /**提示语*/
    private String cueWord;

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
}
