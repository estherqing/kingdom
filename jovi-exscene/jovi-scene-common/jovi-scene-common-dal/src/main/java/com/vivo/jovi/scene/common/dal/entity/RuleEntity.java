package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @author lijun
 */
public class RuleEntity {
    private Long id;

    private Long activityId;

    private String targetPlatform;

    private String ruleType;

    private Integer ruleState;

    private Integer triggerAttr;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;

    private String ruleConfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getTargetPlatform() {
        return targetPlatform;
    }

    public void setTargetPlatform(String targetPlatform) {
        this.targetPlatform = targetPlatform;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getRuleState() {
        return ruleState;
    }

    public void setRuleState(Integer ruleState) {
        this.ruleState = ruleState;
    }

    public Integer getTriggerAttr() {
        return triggerAttr;
    }

    public void setTriggerAttr(Integer triggerAttr) {
        this.triggerAttr = triggerAttr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getRuleConfig() {
        return ruleConfig;
    }

    public void setRuleConfig(String ruleConfig) {
        this.ruleConfig = ruleConfig;
    }
}