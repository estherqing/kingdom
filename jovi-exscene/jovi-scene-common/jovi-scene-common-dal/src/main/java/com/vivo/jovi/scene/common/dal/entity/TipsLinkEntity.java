package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-02-15 9:48
 */
public class TipsLinkEntity {
    private Long id;

    /**业务id*/
    private String linkId;

    /**名称*/
    private String linkName;

    /**链接类型（fos、cp）*/
    private Integer linkType;

    /**action*/
    private String action;

    /**应用名称*/
    private String appPackageName;

    /**最低版本号*/
    private Integer appMinVersion;

    /**应用界面类名*/
    private String appInterfaceClassName;

    /**url*/
    private String url;

    /**快应用链接*/
    private String cpFastLink;

    /**H5链接*/
    private String cpH5Link;

    private Date createTime;

    private Date updateTime;

    public TipsLinkEntity(Long id, String linkId, String linkName, Integer linkType, String action, String appPackageName, Integer appMinVersion, String appInterfaceClassName, String url, String cpFastLink, String cpH5Link, Date createTime, Date updateTime) {
        this.id = id;
        this.linkId = linkId;
        this.linkName = linkName;
        this.linkType = linkType;
        this.action = action;
        this.appPackageName = appPackageName;
        this.appMinVersion = appMinVersion;
        this.appInterfaceClassName = appInterfaceClassName;
        this.url = url;
        this.cpFastLink = cpFastLink;
        this.cpH5Link = cpH5Link;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TipsLinkEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    public Integer getAppMinVersion() {
        return appMinVersion;
    }

    public void setAppMinVersion(Integer appMinVersion) {
        this.appMinVersion = appMinVersion;
    }

    public String getAppInterfaceClassName() {
        return appInterfaceClassName;
    }

    public void setAppInterfaceClassName(String appInterfaceClassName) {
        this.appInterfaceClassName = appInterfaceClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCpFastLink() {
        return cpFastLink;
    }

    public void setCpFastLink(String cpFastLink) {
        this.cpFastLink = cpFastLink;
    }

    public String getCpH5Link() {
        return cpH5Link;
    }

    public void setCpH5Link(String cpH5Link) {
        this.cpH5Link = cpH5Link;
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

    @Override
    public String toString() {
        return "TipsLinkEntity{" +
                "id=" + id +
                ", linkId='" + linkId + '\'' +
                ", linkName='" + linkName + '\'' +
                ", linkType=" + linkType +
                ", action='" + action + '\'' +
                ", appPackageName='" + appPackageName + '\'' +
                ", appMinVersion='" + appMinVersion + '\'' +
                ", appInterfaceClassName='" + appInterfaceClassName + '\'' +
                ", url='" + url + '\'' +
                ", cpFastLink='" + cpFastLink + '\'' +
                ", cpH5Link='" + cpH5Link + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
