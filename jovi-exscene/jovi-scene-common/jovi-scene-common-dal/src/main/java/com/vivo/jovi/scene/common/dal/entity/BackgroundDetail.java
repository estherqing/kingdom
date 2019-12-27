package com.vivo.jovi.scene.common.dal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *  用于输出，不继承BizEntity
 * @author yaoze
 * @date 2019-05-23.
 */

//@Data
public class BackgroundDetail {
    private Long id;
    private String bgId;
    private String imgUrl;
    private Integer versionCode;
    private String name;
    private Integer status;
    private String pulloffReason;
    private String disableReason;
    private Date startTime;
    private Date endTime;
    private Integer priority;
    private TipsLinkEntity link;
    @JsonProperty(value = "modifyBy")
    private String modifier;
//    private Integer pageNum;
//    private Integer pageSize;
//    private String fieldBy;
//    private String orderBy;
    private String imeis;
    private String approvalTestUserId;
    private String approvalTestUserName;
    private String approvalTestReason;
    private Integer approvalTestStatus;
    private String approvalOperationUserId;
    private String approvalOperationUserName;
    private String approvalOperationReason;
    private Integer approvalOperationStatus;

    private String startBgColor;
    private String endBgColor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBgId() {
        return bgId;
    }

    public void setBgId(String bgId) {
        this.bgId = bgId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public TipsLinkEntity getLink() {
        return link;
    }

    public void setLink(TipsLinkEntity link) {
        this.link = link;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getImeis() {
        return imeis;
    }

    public void setImeis(String imeis) {
        this.imeis = imeis;
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

