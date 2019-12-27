package com.vivo.jovi.scene.common.dal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 继承BizEntity
 * @author David
 */
public class BackgroundEntity  extends BizEntity{
    private Long id;

    @JsonProperty("bgImgId")
    private String bgId;

    private String name;

    private String createUserId;

    private String createUserName;

    private Integer versionCode;

    private Date createTime;

    private String modifyUserId;

    private String modifyUserName;

    private Date modifyTime;

    private String pulloffReason;

    private String disableReason;

    private Date startTime;

    private Date endTime;

    private Integer priority;

    private String imgUrl;

    private String displayText;

    private String linkId;

    private String buttonName;

    private String buttonLinkId;

    private String noticeId;

    private String approvalTestUserId;

    private String approvalTestUserName;

    private String approvalTestReason;

    private Integer approvalTestStatus;

    private String approvalOperationUserId;

    private String approvalOperationUserName;

    private String approvalOperationReason;

    private Integer approvalOperationStatus;

    private String previewImeis;

    private Boolean isDelete;

    private String processId;

    private String startBgColor;
    private String endBgColor;

    public BackgroundEntity(){
    }

    public BackgroundEntity(String bgId, Integer versionCode){
        this.bgId = bgId;
        this.versionCode = versionCode;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String iconUrl) {
        this.imgUrl = iconUrl;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonLinkId() {
        return buttonLinkId;
    }

    public void setButtonLinkId(String buttonLinkId) {
        this.buttonLinkId = buttonLinkId;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
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

    public String getPreviewImeis() {
        return previewImeis;
    }

    public void setPreviewImeis(String previewImeis) {
        this.previewImeis = previewImeis;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    /**
     * 复制新实体，并将发布信息携带上
     * @param publishEntity 发布策略
     * @return 新实体
     */
    @Override
    public BackgroundEntity cloneAndCopyPublishInfo(PublishEntity publishEntity) {
        BackgroundEntity newEntity = new BackgroundEntity();
        BeanUtils.copyProperties(this,newEntity);
        newEntity.setStrategyId(publishEntity.getStrategyId());
        newEntity.setStatusInPublish(publishEntity.getBizStatus());
        newEntity.setPublishStatus(publishEntity.getStatus());
        newEntity.setBizId(newEntity.getBgId());
        newEntity.setPublishCreateTime(publishEntity.getCreateTime());
        newEntity.setPublishUpdateTime(publishEntity.getUpdateTime());
        return newEntity;
    }

    @Override
    public Integer getVersionCode() {
        return versionCode;
    }

    @Override
    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
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