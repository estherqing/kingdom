package com.vivo.jovi.scene.common.dal.entity;
/**
 * @author Lu Guodong
 * @describe
 * @date 2019-03-12
 */
public class ExsceneBizEntity {
    private String bizId;
    private String bizName;
    private Integer status;
    private Integer versionCode;
    private Integer statusInPublish;
    private String bizType;
    private Integer publishStatus;

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
}
