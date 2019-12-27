package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-03-12
 */
public abstract class BizEntity {
    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 业务对象名称
     */
    private String bizName;

    /**业务对象状态
     * 卡片状态,1-待上线，2-驳回，3-待审核，4-上线审核，5-下架审核，6-禁用审核，7-已上线，8-已下线，9-已禁用
     * tips状态
     * */
    private Integer status;

    /**
     * 版本号
     */
    private Integer versionCode;

    /**
     * 对应策略的ID
     */
    private String strategyId;

    /** 这个业务对象在发布中的状态，是业务对象自己的状态 （上架，下架，禁用）
     *
     */
    private Integer statusInPublish;

    /**
     * 类型
     */
    private String bizType;

    /** 发布的状态 （全量，灰度。失效，暂停）
     *
     */
    private Integer publishStatus;

    private Date publishCreateTime;

    private Date publishUpdateTime;

    public abstract BizEntity cloneAndCopyPublishInfo(PublishEntity publishEntity);

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Integer getStatusInPublish() {
        return statusInPublish;
    }

    public void setStatusInPublish(Integer statusInPublish) {
        this.statusInPublish = statusInPublish;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public Date getPublishUpdateTime() {
        return publishUpdateTime;
    }

    public void setPublishUpdateTime(Date publishUpdateTime) {
        this.publishUpdateTime = publishUpdateTime;
    }

    public Date getPublishCreateTime() {
        return publishCreateTime;
    }

    public void setPublishCreateTime(Date publishCreateTime) {
        this.publishCreateTime = publishCreateTime;
    }
}
