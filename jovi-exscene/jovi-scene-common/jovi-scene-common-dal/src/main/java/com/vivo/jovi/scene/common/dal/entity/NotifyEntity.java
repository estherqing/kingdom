package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @author lijun
 */
public class NotifyEntity {
    private Long id;

    private Long activityId;

    private String notiTitle;

    private String notiContent;

    private Date notiStartTime;

    private Integer notiDisplayTime;

    private Date createTime;

    private Date updateTime;

    private Integer startType;

    private Integer displayType;

    private Integer timeSwitch;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getNotiTitle() {
        return notiTitle;
    }

    public void setNotiTitle(String notiTitle) {
        this.notiTitle = notiTitle;
    }

    public String getNotiContent() {
        return notiContent;
    }

    public void setNotiContent(String notiContent) {
        this.notiContent = notiContent;
    }

    public Date getNotiStartTime() {
        return notiStartTime;
    }

    public void setNotiStartTime(Date notiStartTime) {
        this.notiStartTime = notiStartTime;
    }

    public Integer getNotiDisplayTime() {
        return notiDisplayTime;
    }

    public void setNotiDisplayTime(Integer notiDisplayTime) {
        this.notiDisplayTime = notiDisplayTime;
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

    public Integer getStartType() {
        return startType;
    }

    public void setStartType(Integer startType) {
        this.startType = startType;
    }

    public Integer getDisplayType() {
        return displayType;
    }

    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    public Integer getTimeSwitch() {
        return timeSwitch;
    }

    public void setTimeSwitch(Integer timeSwitch) {
        this.timeSwitch = timeSwitch;
    }
}