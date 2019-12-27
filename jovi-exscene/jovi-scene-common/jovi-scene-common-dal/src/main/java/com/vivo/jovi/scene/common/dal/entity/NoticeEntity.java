package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-02-15 9:57
 */
public class NoticeEntity {

    private Long id;

    /**业务id*/
    private String noticeId;

    /**通知标题*/
    private String title;

    /**通知内容*/
    private String content;

    /**跟随(tips、活动)出现*/
    private Integer startType;

    /**通知开始时间（预留）*/
    private Date startTime;

    /**是否允许21:00 – 次日7:00出现*/
    private Integer isAllowNotice;

    /**0跟随(tips、活动)结束，1通知出现多少分钟后*/
    private Integer disappearType;

    /**通知出现多少分钟后*/
    private Integer disappearTime;

    private Date createTime;

    private Date updateTime;

    public NoticeEntity() {
    }

    public NoticeEntity(Long id, String noticeId, String title, String content, Integer startType, Date startTime, Integer isAllowNotice, Integer disappearType, Integer disappearTime, Date createTime, Date updateTime) {
        this.id = id;
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.startType = startType;
        this.startTime = startTime;
        this.isAllowNotice = isAllowNotice;
        this.disappearType = disappearType;
        this.disappearTime = disappearTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStartType() {
        return startType;
    }

    public void setStartType(Integer startType) {
        this.startType = startType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getIsAllowNotice() {
        return isAllowNotice;
    }

    public void setIsAllowNotice(Integer isAllowNotice) {
        this.isAllowNotice = isAllowNotice;
    }

    public Integer getDisappearType() {
        return disappearType;
    }

    public void setDisappearType(Integer disappearType) {
        this.disappearType = disappearType;
    }

    public Integer getDisappearTime() {
        return disappearTime;
    }

    public void setDisappearTime(Integer disappearTime) {
        this.disappearTime = disappearTime;
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
        return "NoticeEntity{" +
                "id=" + id +
                ", noticeId='" + noticeId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startType=" + startType +
                ", startTime=" + startTime +
                ", isAllowNotice=" + isAllowNotice +
                ", disappearType=" + disappearType +
                ", disappearTime=" + disappearTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
