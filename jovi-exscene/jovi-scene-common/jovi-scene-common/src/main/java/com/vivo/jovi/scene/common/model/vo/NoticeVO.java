package com.vivo.jovi.scene.common.model.vo;

import java.util.Date;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-01
 */
public class NoticeVO {

    private String   id;
    private String   noticeId;
    private String   title;
    private String   content;
    private Integer  startType;
    private Date     startTime;
    private Integer  isAllowNotice;
    private Integer  dispearType;
    private Long  dispearTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getDispearType() {
        return dispearType;
    }

    public void setDispearType(Integer dispearType) {
        this.dispearType = dispearType;
    }

    public Long getDispearTime() {
        return dispearTime;
    }

    public void setDispearTime(Long dispearTime) {
        this.dispearTime = dispearTime;
    }

    @Override
    public String toString() {
        return "NoticeVO{" +
                "id='" + id + '\'' +
                ", noticeId='" + noticeId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startType=" + startType +
                ", startTime=" + startTime +
                ", isAllowNotice=" + isAllowNotice +
                ", dispearType=" + dispearType +
                ", dispearTime=" + dispearTime +
                '}';
    }
}
