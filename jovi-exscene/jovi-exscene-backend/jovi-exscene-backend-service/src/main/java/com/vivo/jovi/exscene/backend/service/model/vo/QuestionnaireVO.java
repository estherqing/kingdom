package com.vivo.jovi.exscene.backend.service.model.vo;

import java.util.List;

/**
 * @Classname QuestionnaireVO
 * @Description TODO
 * @Date 2019-05-06 17:53
 * @Created by Administrator
 * @Version 1.0
 */
public class QuestionnaireVO {

    private Long id;

    private String questionnaireId;

    private String questionId;

    private String title;

    private Integer versionCode;

    private Integer status;

    private String modifyTime;

    private String modifyUserName;

    private List<String> questionIdList;

    private String startTime;

    private String createTime;

    private String endTime;

    private Integer isReward;

    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
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

    public List<String> getQuestionIdList() {
        return questionIdList;
    }

    public void setQuestionIdList(List<String> questionIdList) {
        this.questionIdList = questionIdList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
