package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class PublishQuantityEntity {
    private Integer id;

    private String bizId;

    private Integer bizVersion;

    private String bizType;

    private Date createTime;

    private Date updateTime;

    private Long publishQuantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Integer getBizVersion() {
        return bizVersion;
    }

    public void setBizVersion(Integer bizVersion) {
        this.bizVersion = bizVersion;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
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

    public Long getPublishQuantity() {
        return publishQuantity;
    }

    public void setPublishQuantity(Long publishQuantity) {
        this.publishQuantity = publishQuantity;
    }
}