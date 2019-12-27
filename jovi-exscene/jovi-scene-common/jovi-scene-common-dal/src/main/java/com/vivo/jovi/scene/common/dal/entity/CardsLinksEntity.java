package com.vivo.jovi.scene.common.dal.entity;

/**
 * @Description
 * @Author: Lu Guodong
 * @Date: 2019-03-12 21:24
 */
import java.util.Date;

public class CardsLinksEntity {
    private Long id;

    /**接入服务对应的卡片id*/
    private String cardId;

    /**接入服务id*/
    private String targetId;

    /**接入服务名称*/
    private String targetName;

    /**服务类型*/
    private String linkCategory;

    /** 数据传输方式.0-拉取，1-推送*/
    private Integer syncMethod;

    /** 接口地址*/
    private String skipLink;

    /** 合法跳转URL，格式：["url1", "url2"]*/
    private String skipUrl;

    /** 快应用优先级*/
    private Integer fastLinkPriority;

    /** App链接优先级*/
    private Integer appLinkPriority;

    /** H5链接优先级*/
    private Integer h5LinkPriority;

    /** 快应用链接*/
    private String fastLink;

    /** app链接*/
    private String appLink;

    /**H5链接 */
    private String h5Link;

    /**落地页 */
    private String squeezePage;

    /** 服务简介*/
    private String linkDesc;

    /** 更新说明*/
    private String modifyDesc;

    /** 修改时间*/
    private Date modifyTime;

    /** 提供商*/
    private String provider;

    /** 提供商简介*/
    private String providerDesc;

    /** 是否支持数据回传*/
    private Integer dataPushBack;

    /** 数据回传方式*/
    private String pushBackMethod;

    /**回传数据*/
    private String pushBackData;

    /**账号是否打通 */
    private Integer accoutGetThrough;

    private Integer cardVersionCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getLinkCategory() {
        return linkCategory;
    }

    public void setLinkCategory(String linkCategory) {
        this.linkCategory = linkCategory;
    }

    public Integer getSyncMethod() {
        return syncMethod;
    }

    public void setSyncMethod(Integer syncMethod) {
        this.syncMethod = syncMethod;
    }

    public String getSkipLink() {
        return skipLink;
    }

    public void setSkipLink(String skipLink) {
        this.skipLink = skipLink;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    public Integer getFastLinkPriority() {
        return fastLinkPriority;
    }

    public void setFastLinkPriority(Integer fastLinkPriority) {
        this.fastLinkPriority = fastLinkPriority;
    }

    public Integer getAppLinkPriority() {
        return appLinkPriority;
    }

    public void setAppLinkPriority(Integer appLinkPriority) {
        this.appLinkPriority = appLinkPriority;
    }

    public Integer getH5LinkPriority() {
        return h5LinkPriority;
    }

    public void setH5LinkPriority(Integer h5LinkPriority) {
        this.h5LinkPriority = h5LinkPriority;
    }

    public String getFastLink() {
        return fastLink;
    }

    public void setFastLink(String fastLink) {
        this.fastLink = fastLink;
    }

    public String getAppLink() {
        return appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }

    public String getH5Link() {
        return h5Link;
    }

    public void setH5Link(String h5Link) {
        this.h5Link = h5Link;
    }

    public String getSqueezePage() {
        return squeezePage;
    }

    public void setSqueezePage(String squeezePage) {
        this.squeezePage = squeezePage;
    }

    public String getLinkDesc() {
        return linkDesc;
    }

    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    public String getModifyDesc() {
        return modifyDesc;
    }

    public void setModifyDesc(String modifyDesc) {
        this.modifyDesc = modifyDesc;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderDesc() {
        return providerDesc;
    }

    public void setProviderDesc(String providerDesc) {
        this.providerDesc = providerDesc;
    }

    public Integer getDataPushBack() {
        return dataPushBack;
    }

    public void setDataPushBack(Integer dataPushBack) {
        this.dataPushBack = dataPushBack;
    }

    public String getPushBackMethod() {
        return pushBackMethod;
    }

    public void setPushBackMethod(String pushBackMethod) {
        this.pushBackMethod = pushBackMethod;
    }

    public Integer getAccoutGetThrough() {
        return accoutGetThrough;
    }

    public void setAccoutGetThrough(Integer accoutGetThrough) {
        this.accoutGetThrough = accoutGetThrough;
    }

    public String getPushBackData() {
        return pushBackData;
    }

    public void setPushBackData(String pushBackData) {
        this.pushBackData = pushBackData;
    }

    public Integer getCardVersionCode() {
        return cardVersionCode;
    }

    public void setCardVersionCode(Integer cardVersionCode) {
        this.cardVersionCode = cardVersionCode;
    }
}
