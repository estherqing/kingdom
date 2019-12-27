package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class ActivityHistoryEntity {
    private Long id;

    private Long activityId;

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

    private String rule;

    private String notify;

    private String action;

    private Date createTime;

    private Date updateTime;

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

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}