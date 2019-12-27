package com.vivo.jovi.scene.common.model.dto;

import java.util.List;

/**
 * @Classname QuestionnaireDTO
 * @Description TODO
 * @Date 2019-05-06 16:07
 * @Created by Administrator
 * @Version 1.0
 */
public class QuestionnaireDTO extends BasePageQueryDTO {

    private Integer id;

    private Integer isReward;

    private String questionnaireId;

    private Integer versionCode;

    private String title;

    private String language;

    private Integer status;

    private List<Integer> statusList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    @Override
    public String toString() {
        return "QuestionnaireDTO{" +
                "id=" + id +
                ", isReward=" + isReward +
                ", questionnaireId='" + questionnaireId + '\'' +
                ", versionCode=" + versionCode +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", status=" + status +
                ", statusList=" + statusList +
                '}';
    }
}
