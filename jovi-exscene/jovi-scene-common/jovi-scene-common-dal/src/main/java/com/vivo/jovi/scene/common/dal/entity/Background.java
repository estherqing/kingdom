package com.vivo.jovi.scene.common.dal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *  用于输出，不继承BizEntity
 * @author david
 */
public class Background {
    @JsonIgnore
    private Long id;

    @JsonProperty("bgImgId")
    private String bgId;

    private String name;
    private Integer status;
    private Integer versionCode;
    @JsonProperty("modifyBy")
    private String modifyUserName;
    @JsonIgnore
    private Date modifyTime;
    @JsonIgnore
    private String pulloffReason;
    @JsonIgnore
    private String disableReason;

    private Date startTime;

    private Date endTime;
    @JsonIgnore
    private Integer priority;

    private String imgUrl;

    private TipsLinkEntity link;
    @JsonIgnore
    private String displayText;
    @JsonIgnore
    private String linkId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    /**
     * 复制新实体，并将发布信息携带上
     * @param publishEntity 发布策略
     * @return 新实体
     */
//    @Override
//    public Background cloneAndCopyPublishInfo(PublishEntity publishEntity) {
//        BackgroundVO newEntity = new BackgroundVO();
//        BeanUtils.copyProperties(this,newEntity);
//        newEntity.setStrategyId(publishEntity.getStrategyId());
//        newEntity.setStatusInPublish(publishEntity.getBizStatus());
//        newEntity.setPublishStatus(publishEntity.getStatus());
//        newEntity.setBizId(newEntity.getBgId());
//        newEntity.setPublishCreateTime(publishEntity.getCreateTime());
//        newEntity.setPublishUpdateTime(publishEntity.getUpdateTime());
//        return newEntity;
//    }

    public TipsLinkEntity getLink() {
        return link;
    }

    public void setLink(TipsLinkEntity link) {
        this.link = link;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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