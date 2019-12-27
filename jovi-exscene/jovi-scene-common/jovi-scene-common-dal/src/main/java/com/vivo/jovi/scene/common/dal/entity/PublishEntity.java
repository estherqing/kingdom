package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class PublishEntity {

    private long id;

    private String strategyId;

    private String bizId;

    private String bizName;

    private Integer bizStatus;

    private Date bizEndTime;

    private Integer bizVersionCode;

    private String bizCategorieName;

    private String bizSubCategorieName;

    private Integer type;

    private String classification;

    private String greyType;

    private Integer imeiGreyType;

    private String imeiGefineType;

    private String imeiDefineType;

    private String imeiEndNums;

    private String imeiManual;

    private String groupName;

    private Integer phoneModelType;

    private String phoneModelList;

    private Integer androidVersionType;

    private String androidVersionList;

    private String tags;

    private Integer status;

    private String failureReason;

    private String modifyUserName;

    private String approvalTestUserId;

    private String approvalTestUserName;

    private String approvalTestReason;

    private Integer approvalTestStatus;

    private String approvalOperationUserId;

    private String approvalOperationUserName;

    private String approvalOperationReason;

    private Integer approvalOperationStatus;

    private Integer clientVersion;

    private long expectedRelease;

    private long actualRelease;

    private Date createTime;

    private Date updateTime;

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

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public Integer getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(Integer bizStatus) {
        this.bizStatus = bizStatus;
    }

    public Date getBizEndTime() {
        return bizEndTime;
    }

    public void setBizEndTime(Date bizEndTime) {
        this.bizEndTime = bizEndTime;
    }

    public Integer getBizVersionCode() {
        return bizVersionCode;
    }

    public void setBizVersionCode(Integer bizVersionCode) {
        this.bizVersionCode = bizVersionCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getGreyType() {
        return greyType;
    }

    public void setGreyType(String greyType) {
        this.greyType = greyType;
    }

    public Integer getImeiGreyType() {
        return imeiGreyType;
    }

    public void setImeiGreyType(Integer imeiGreyType) {
        this.imeiGreyType = imeiGreyType;
    }

    public String getImeiEndNums() {
        return imeiEndNums;
    }

    public void setImeiEndNums(String imeiEndNums) {
        this.imeiEndNums = imeiEndNums;
    }

    public String getImeiManual() {
        return imeiManual;
    }

    public void setImeiManual(String imeiManual) {
        this.imeiManual = imeiManual;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getPhoneModelType() {
        return phoneModelType;
    }

    public void setPhoneModelType(Integer phoneModelType) {
        this.phoneModelType = phoneModelType;
    }

    public String getPhoneModelList() {
        return phoneModelList;
    }

    public void setPhoneModelList(String phoneModelList) {
        this.phoneModelList = phoneModelList;
    }

    public Integer getAndroidVersionType() {
        return androidVersionType;
    }

    public void setAndroidVersionType(Integer androidVersionType) {
        this.androidVersionType = androidVersionType;
    }

    public String getAndroidVersionList() {
        return androidVersionList;
    }

    public void setAndroidVersionList(String androidVersionList) {
        this.androidVersionList = androidVersionList;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public String getApprovalTestUserId() {
        return approvalTestUserId;
    }

    public void setApprovalTestUserId(String approvalTestUserId) {
        this.approvalTestUserId = approvalTestUserId;
    }

    public String getApprovalTestUserName() {
        return approvalTestUserName;
    }

    public void setApprovalTestUserName(String approvalTestUserName) {
        this.approvalTestUserName = approvalTestUserName;
    }

    public String getApprovalTestReason() {
        return approvalTestReason;
    }

    public void setApprovalTestReason(String approvalTestReason) {
        this.approvalTestReason = approvalTestReason;
    }

    public Integer getApprovalTestStatus() {
        return approvalTestStatus;
    }

    public void setApprovalTestStatus(Integer approvalTestStatus) {
        this.approvalTestStatus = approvalTestStatus;
    }

    public String getApprovalOperationUserId() {
        return approvalOperationUserId;
    }

    public void setApprovalOperationUserId(String approvalOperationUserId) {
        this.approvalOperationUserId = approvalOperationUserId;
    }

    public String getApprovalOperationUserName() {
        return approvalOperationUserName;
    }

    public void setApprovalOperationUserName(String approvalOperationUserName) {
        this.approvalOperationUserName = approvalOperationUserName;
    }

    public String getApprovalOperationReason() {
        return approvalOperationReason;
    }

    public void setApprovalOperationReason(String approvalOperationReason) {
        this.approvalOperationReason = approvalOperationReason;
    }

    public Integer getApprovalOperationStatus() {
        return approvalOperationStatus;
    }

    public void setApprovalOperationStatus(Integer approvalOperationStatus) {
        this.approvalOperationStatus = approvalOperationStatus;
    }

    public Integer getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(Integer clientVersion) {
        this.clientVersion = clientVersion;
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

    public String getBizCategorieName() {
        return bizCategorieName;
    }

    public void setBizCategorieName(String bizCategorieName) {
        this.bizCategorieName = bizCategorieName;
    }

    public String getBizSubCategorieName() {
        return bizSubCategorieName;
    }

    public void setBizSubCategorieName(String bizSubCategorieName) {
        this.bizSubCategorieName = bizSubCategorieName;
    }

    public String getImeiGefineType() {
        return imeiGefineType;
    }

    public void setImeiGefineType(String imeiGefineType) {
        this.imeiGefineType = imeiGefineType;
    }

    public String getImeiDefineType() {
        return imeiDefineType;
    }

    public void setImeiDefineType(String imeiDefineType) {
        this.imeiDefineType = imeiDefineType;
    }
}
