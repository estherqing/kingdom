package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class QuestionnaireEntity {
    private Long id;

    private String questionnaireId;

    private Integer versionCode;

    private Integer status;

    private String createUserId;

    private String createUserName;

    private Date createTime;

    private String modifyUserId;

    private String modifyUserName;

    private Date modifyTime;

    private String pulloffReason;

    private String disableReason;

    private String rejectReason;

    private Date startTime;

    private Date endTime;

    private String approvalTestUserId;

    private String approvalTestUserName;

    private String approvalTestReason;

    private Integer approvalTestStatus;

    private String approvalOperationUserId;

    private String approvalOperationUserName;

    private String approvalOperationReason;

    private Integer approvalOperationStatus;

    private Integer preApprovalStatus;

    private String icon;

    private Integer isReward;

    private String questionIdList;

    private String title;

    private String translateFileName;

    private String translateFileUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPulloffReason() {
        return pulloffReason;
    }

    public void setPulloffReason(String pulloffReason) {
        this.pulloffReason = pulloffReason;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
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

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public Integer getPreApprovalStatus() {
        return preApprovalStatus;
    }

    public void setPreApprovalStatus(Integer preApprovalStatus) {
        this.preApprovalStatus = preApprovalStatus;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getQuestionIdList() {
        return questionIdList;
    }

    public void setQuestionIdList(String questionIdList) {
        this.questionIdList = questionIdList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTranslateFileName() {
        return translateFileName;
    }

    public void setTranslateFileName(String translateFileName) {
        this.translateFileName = translateFileName;
    }

    public String getTranslateFileUrl() {
        return translateFileUrl;
    }

    public void setTranslateFileUrl(String translateFileUrl) {
        this.translateFileUrl = translateFileUrl;
    }
}