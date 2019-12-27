package com.vivo.jovi.scene.common.model.dto;

import java.util.Date;

/**
 * @author yaoze
 * @date 2019-05-22.
 */

public class BackgroundPageDTO {
    private String bgId;
    private String name;
    private String imgUrl;
    private Integer status;
    private Integer versionCode;
    private String modifyBy;
    private Date startTime;
    private Date endTime;
    private LinkDTO link;
    private Integer priority;
    private String imeis;
    private String pullOffReason;
    private String disableReason;
    private Integer pageNum;
    private Integer pageSize;
    private String orderField;
    private String orderBy;
    private String startBgColor;
    private String endBgColor;

    // 审核方面的属性
    private String approvalReason;
    private Integer approvalStatus; // 0 未审批；1审批通过；2 审批不通过
    private Boolean passCheckTest;
    private Boolean passCheckOperation;

    private String userId;
    private String userName;

    public String getBgId() {
        return bgId;
    }

    public void setBgId(String bgId) {
        this.bgId = bgId;
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

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LinkDTO getLink() {
        return link;
    }

    public void setLink(LinkDTO link) {
        this.link = link;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public int getOffset() {
        return pageNum*pageSize;
    }

    public String getPullOffReason() {
        return pullOffReason;
    }

    public void setPullOffReason(String pullOffReason) {
        this.pullOffReason = pullOffReason;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public String getApprovalReason() {
        return approvalReason;
    }

    public void setApprovalReason(String approvalReason) {
        this.approvalReason = approvalReason;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Boolean getPassCheckTest() {
        return passCheckTest;
    }

    public void setPassCheckTest(Boolean passCheckTest) {
        this.passCheckTest = passCheckTest;
    }

    public Boolean getPassCheckOperation() {
        return passCheckOperation;
    }

    public void setPassCheckOperation(Boolean passCheckOperation) {
        this.passCheckOperation = passCheckOperation;
    }

    public String getImeis() {
        return imeis;
    }

    public void setImeis(String imeis) {
        this.imeis = imeis;
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

    public String getStartBgColor() {
        return startBgColor;
    }

    public void setStartBgColor(String startBgColor) {
        this.startBgColor = startBgColor;
    }

    public String getEndBgColor() {
        return endBgColor;
    }

    public void setEndBgColor(String endBgColor) {
        this.endBgColor = endBgColor;
    }
}
