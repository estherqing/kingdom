package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @author lijun
 */
public class ActivityEntity {
    private Long id;

    private Integer activityVersionCode;

    private String activityName;

    private Integer activityType;

    private Integer activityState;

    private Date activityStartTime;

    private Date activityEndTime;

    private String operationComment;

    private String userId;

    private String userName;

    private Integer upperOperateState;

    private Date createTime;

    private Date updateTime;

    private String cardId;

    private String rpkPackage;

    private String cardPath;

    private Integer versionCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getActivityVersionCode() {
        return activityVersionCode;
    }

    public void setActivityVersionCode(Integer activityVersionCode) {
        this.activityVersionCode = activityVersionCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getOperationComment() {
        return operationComment;
    }

    public void setOperationComment(String operationComment) {
        this.operationComment = operationComment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUpperOperateState() {
        return upperOperateState;
    }

    public void setUpperOperateState(Integer upperOperateState) {
        this.upperOperateState = upperOperateState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getRpkPackage() {
        return rpkPackage;
    }

    public void setRpkPackage(String rpkPackage) {
        this.rpkPackage = rpkPackage;
    }

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ActivityEntity{");
        sb.append("id='").append(id).append('\'');
        sb.append("activityVersionCode='").append(activityVersionCode).append('\'');
        sb.append("activityName='").append(activityName).append('\'');
        sb.append("activityType='").append(activityType).append('\'');
        sb.append("activityState='").append(activityState).append('\'');
        sb.append("activityStartTime='").append(activityStartTime).append('\'');
        sb.append("activityEndTime='").append(activityEndTime).append('\'');
        sb.append("operationComment='").append(operationComment).append('\'');
        sb.append("userId='").append(userId).append('\'');
        sb.append("userName='").append(userName).append('\'');
        sb.append("upperOperateState='").append(upperOperateState).append('\'');
        sb.append("createTime='").append(createTime).append('\'');
        sb.append("updateTime='").append(updateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}