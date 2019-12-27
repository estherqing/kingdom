package com.vivo.jovi.exscene.backend.service.model.vo;

import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;

import java.util.Date;

public class PublishVO {

    private long id;

    private String strategyId;

    private String bizId;

    private Integer bizStatus;

    private String name;

    private Integer status;

    private String failureReason;

    private Integer type;

    private Date updateTime;

    private String modifyUserName;

    private long expectedRelease;

    private long actualRelease;

    private Integer bizVersionCode;

    private Integer isReward;

    private String fileUrl;

    private String fileName;

    public PublishVO() {
    }

    public PublishVO(ExPublishEntity ae) {
        this.id = ae.getId();
        this.strategyId = ae.getStrategyId();
        this.bizId = ae.getBizId();
        this.name = ae.getBizName();
        this.status = ae.getStatus();
        this.failureReason = ae.getFailureReason();
        this.type = ae.getType();
        this.updateTime = ae.getUpdateTime();
        this.modifyUserName = ae.getModifyUserName();
        this.bizStatus = ae.getBizStatus();
        this.expectedRelease = ae.getExpectedRelease();
        this.actualRelease = ae.getActualRelease();
        this.isReward = ae.getIsReward();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Integer getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(Integer bizStatus) {
        this.bizStatus = bizStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public long getExpectedRelease() {
        return expectedRelease;
    }

    public void setExpectedRelease(long expectedRelease) {
        this.expectedRelease = expectedRelease;
    }

    public long getActualRelease() {
        return actualRelease;
    }

    public void setActualRelease(long actualRelease) {
        this.actualRelease = actualRelease;
    }

    public Integer getBizVersionCode() {
        return bizVersionCode;
    }

    public void setBizVersionCode(Integer bizVersionCode) {
        this.bizVersionCode = bizVersionCode;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
