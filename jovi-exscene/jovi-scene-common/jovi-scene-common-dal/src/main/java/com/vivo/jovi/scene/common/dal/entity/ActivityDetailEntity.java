package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @program: ssdp-intellig-scene
 * @description: 活动卡片详情，包括运营规则，通知
 * @author: xuxitao
 * @create: 2018-11-20 11:44
 **/
public class ActivityDetailEntity {

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

//    private Byte upperOperateState;

    private Date createTime;

    private Date updateTime;

    private String notiTitle;

    private String notiContent;

    private Date notiStartTime;

    private Integer startType;

    private Integer notiDisplayTime;

    private Integer timeSwitch;

    private Integer displayType;

    private String ruleConfig;

    private String ruleType;

    private String actionConfig;

    private String actionType;

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

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }

    public Integer getNotiDisplayTime() {
        return notiDisplayTime;
    }

    public void setNotiDisplayTime(Integer notiDisplayTime) {
        this.notiDisplayTime = notiDisplayTime;
    }

    public Integer getTimeSwitch() {
        return timeSwitch;
    }

    public void setTimeSwitch(Integer timeSwitch) {
        this.timeSwitch = timeSwitch;
    }

    public String getRuleConfig() {
        return ruleConfig;
    }

    public void setRuleConfig(String ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getActionConfig() {
        return actionConfig;
    }

    public void setActionConfig(String actionConfig) {
        this.actionConfig = actionConfig;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Date getNotiStartTime() {
        return notiStartTime;
    }

    public void setNotiStartTime(Date notiStartTime) {
        this.notiStartTime = notiStartTime;
    }

    public Integer getStartType() {
        return startType;
    }

    public void setStartType(Integer startType) {
        this.startType = startType;
    }

    public Integer getDisplayType() {
        return displayType;
    }

    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }
}
