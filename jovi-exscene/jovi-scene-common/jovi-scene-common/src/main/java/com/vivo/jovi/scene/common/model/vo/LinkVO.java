package com.vivo.jovi.scene.common.model.vo;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-01
 */
public class LinkVO {

    private String linkId;
    private String linkName;
    private Integer linkType;

    private String fosAction;
    private String packageName;
    private Integer appMinVersion;

    private String cpFastLink;
    private String cpAppLink;
    private String cpH5Link;

    private String activityName;
    private String uri;

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

    public String getFosAction() {
        return fosAction;
    }

    public void setFosAction(String fosAction) {
        this.fosAction = fosAction;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getAppMinVersion() {
        return appMinVersion;
    }

    public void setAppMinVersion(Integer appMinVersion) {
        this.appMinVersion = appMinVersion;
    }

    public String getCpFastLink() {
        return cpFastLink;
    }

    public void setCpFastLink(String cpFastLink) {
        this.cpFastLink = cpFastLink;
    }

    public String getCpAppLink() {
        return cpAppLink;
    }

    public void setCpAppLink(String cpAppLink) {
        this.cpAppLink = cpAppLink;
    }

    public String getCpH5Link() {
        return cpH5Link;
    }

    public void setCpH5Link(String cpH5Link) {
        this.cpH5Link = cpH5Link;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
