package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;
import java.util.List;

public class QuestionnaireUserEntity {
    private Long id;

    private String questionnaireId;

    private String model;

    private String androidVersion;

    private Date answerTime;

    private Integer sex;

    private String age;

    private String profession;

    private String name;

    private String phoneNum;

    private String email;

    private String userId;

    private List<AnswerEntity> answers;

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

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuestionnaireUserEntity{" +
                "id=" + id +
                ", questionnaireId='" + questionnaireId + '\'' +
                ", model='" + model + '\'' +
                ", androidVersion='" + androidVersion + '\'' +
                ", answerTime=" + answerTime +
                ", sex=" + sex +
                ", age='" + age + '\'' +
                ", profession='" + profession + '\'' +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}