package com.vivo.jovi.scene.common.dal.entity;

import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-02-15 10:11
 */
public class TipsEntity extends BizEntity{

    private Long id;

    private String tipsId;

    /**tips名称*/
    private String name;

    /**创建者账户*/
    private String createUserId;

    /**创建者名字*/
    private String createUserName;

    /**创建时间*/
    private Date createTime;

    /**修改者账户*/
    private String modifyUserId;

    /**修改者名字*/
    private String modifyUserName;

    /**最近更新的时间*/
    private Date modifyTime;

    /**下架原因*/
    private String pulloffReason;

    /**禁用原因*/
    private String disableReason;

    /**开始时间*/
    private Date startTime;

    /**结束时间*/
    private Date endTime;

    /**优先级*/
    private Integer priority;

    /**图标地址*/
    private String iconUrl;

    /**显示内容*/
    private String displayText;

    /**显示内容关联的link id,无链接时为空*/
    private String textLinkId;

    /**按钮名称,无按钮时为空*/
    private String buttonName;

    /**按钮关联的link id,无链接时为空*/
    private String buttonLinkId;

    /**通知id*/
    private String noticeId;

    /**审核测试id*/
    private String approvalTestUserId;

    /**审核测试姓名*/
    private String approvalTestUserName;

    /**测试审核原因*/
    private String approvalTestReason;

    /**0 未审批；1审批通过；2 审批不通过*/
    private Integer approvalTestStatus;

    /**审核运营id*/
    private String approvalOperationUserId;

    /**审核运营姓名*/
    private String approvalOperationUserName;

    /**运营审核原因*/
    private String approvalOperationReason;

    /**0 未审批；1审批通过；2 审批不通过*/
    private Integer approvalOperationStatus;

    /**关联的发布策略*/
    private String publishStrategyId;

    /**是否删除*/
    private Integer isDelete;

    /**用于卡片的唯一标识*/
    private String bizType;

    /**发布管理状态*/
    private Integer publishStatus;

    public TipsEntity() {
    }

    public TipsEntity(Long id, String tipsId, String name, Integer versionCode, Integer status, String createUserId, String createUserName, Date createTime, String modifyUserId, String modifyUserName, Date modifyTime, String pulloffReason, String disableReason, Date startTime, Date endTime, Integer priority, String iconUrl, String displayText, String textLinkId, String buttonName, String buttonLinkId, String noticeId, String approvalTestUserId, String approvalTestUserName, String approvalTestReason, Integer approvalTestStatus, String approvalOperationUserId, String approvalOperationUserName, String approvalOperationReason, Integer approvalOperationStatus, String publishStrategyId, Integer isDelete) {
        this.id = id;
        this.tipsId = tipsId;
        this.name = name;
        super.setVersionCode(versionCode);
        super.setStatus(status);
        this.createUserId = createUserId;
        this.createUserName = createUserName;
        this.createTime = createTime;
        this.modifyUserId = modifyUserId;
        this.modifyUserName = modifyUserName;
        this.modifyTime = modifyTime;
        this.pulloffReason = pulloffReason;
        this.disableReason = disableReason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.iconUrl = iconUrl;
        this.displayText = displayText;
        this.textLinkId = textLinkId;
        this.buttonName = buttonName;
        this.buttonLinkId = buttonLinkId;
        this.noticeId = noticeId;
        this.approvalTestUserId = approvalTestUserId;
        this.approvalTestUserName = approvalTestUserName;
        this.approvalTestReason = approvalTestReason;
        this.approvalTestStatus = approvalTestStatus;
        this.approvalOperationUserId = approvalOperationUserId;
        this.approvalOperationUserName = approvalOperationUserName;
        this.approvalOperationReason = approvalOperationReason;
        this.approvalOperationStatus = approvalOperationStatus;
        this.publishStrategyId = publishStrategyId;
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipsId() {
        return tipsId;
    }

    public void setTipsId(String tipsId) {
        this.tipsId = tipsId;
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

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getTextLinkId() {
        return textLinkId;
    }

    public void setTextLinkId(String textLinkId) {
        this.textLinkId = textLinkId;
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

    public String getPublishStrategyId() {
        return publishStrategyId;
    }

    public void setPublishStrategyId(String publishStrategyId) {
        this.publishStrategyId = publishStrategyId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "TipsEntity{" +
                "id=" + id +
                ", tipsId='" + tipsId + '\'' +
                ", name='" + name + '\'' +
                ", versionCode=" + super.getVersionCode() +
                ", status=" + super.getStatus() +
                ", createUserId='" + createUserId + '\'' +
                ", createUserName='" + createUserName + '\'' +
                ", createTime=" + createTime +
                ", modifyUserId='" + modifyUserId + '\'' +
                ", modifyUserName='" + modifyUserName + '\'' +
                ", modifyTime=" + modifyTime +
                ", pulloffReason='" + pulloffReason + '\'' +
                ", disableReason='" + disableReason + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", priority=" + priority +
                ", iconUrl='" + iconUrl + '\'' +
                ", displayText='" + displayText + '\'' +
                ", textLinkId='" + textLinkId + '\'' +
                ", buttonName='" + buttonName + '\'' +
                ", buttonLinkId='" + buttonLinkId + '\'' +
                ", noticeId='" + noticeId + '\'' +
                ", approvalTestUserId='" + approvalTestUserId + '\'' +
                ", approvalTestUserName='" + approvalTestUserName + '\'' +
                ", approvalTestReason='" + approvalTestReason + '\'' +
                ", approvalTestStatus='" + approvalTestStatus + '\'' +
                ", approvalOperationUserId='" + approvalOperationUserId + '\'' +
                ", approvalOperationUserName='" + approvalOperationUserName + '\'' +
                ", approvalOperationReason='" + approvalOperationReason + '\'' +
                ", approvalOperationStatus='" + approvalOperationStatus + '\'' +
                ", publishStrategyId='" + publishStrategyId + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public TipsEntity cloneAndCopyPublishInfo(PublishEntity publishEntity) {
        TipsEntity newEntity = new TipsEntity();
        BeanUtils.copyProperties(this, newEntity);
        newEntity.setStrategyId(publishEntity.getStrategyId());
        newEntity.setStatusInPublish(publishEntity.getBizStatus());
        newEntity.setPublishStatus(publishEntity.getStatus());
        newEntity.setBizId(newEntity.getTipsId());
        newEntity.setVersionCode(newEntity.getVersionCode());
        newEntity.setPublishCreateTime(publishEntity.getCreateTime());
        newEntity.setPublishUpdateTime(publishEntity.getUpdateTime());
        return newEntity;
    }
}

