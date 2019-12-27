package com.vivo.jovi.exscene.api.service.model.form;

import java.util.List;

public class QuestionnaireForm {

    /**
     * 问卷id
     */
    private String questionnaireId;

    /**
     * 语言，zh_CN:中文,en_US:英语,hi_IN:印地语
     */
    private String language;

    /**
     * 用户性别,0:男,1:女
     */
    private Integer sex;

    /**
     * 用户年龄,0-18岁，18岁以上
     */
    private String age;

    /**
     * 用户职业
     */
    private String profession;

    /**
     * 机型
     */
    private String model;

    /**
     * 安卓版本
     */
    private String androidVersion;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 问题及答案列表
     */
    private List<Question> question;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }
}
