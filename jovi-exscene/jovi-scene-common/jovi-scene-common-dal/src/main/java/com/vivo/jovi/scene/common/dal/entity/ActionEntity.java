package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @author lijun
 */
public class ActionEntity {
    private Long id;

    private Long ruleId;

    private String actionType;

    private Date createTime;

    private Date updateTime;

    private String actionConfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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

    public String getActionConfig() {
        return actionConfig;
    }

    public void setActionConfig(String actionConfig) {
        this.actionConfig = actionConfig;
    }
}