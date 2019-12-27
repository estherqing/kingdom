package com.vivo.jovi.scene.common.model.vo;

import com.vivo.jovi.scene.common.model.BizObject;
import com.vivo.jovi.scene.common.model.vo.LinkVO;
import com.vivo.jovi.scene.common.model.vo.NoticeVO;

import java.util.Date;

/**
 * @author David
 * @version 3.0
 * @date 2019-02-01
 */
public class TipsVO extends BizObject {

    /** Tips名称 */
    private String name;
    /** TipsVO id */
    private Long tipsId;
    /** 图标地址 */
    private String iconUrl;
    /** 显示内容 */
    private String displayText;
    /** 按钮名称,无按钮时为空 */
    private String buttonName;
    /** 状态 */
    private Integer status;
    /** 开始时间 */
    private Date startTime;
    /** 结束时间 */
    private Date endTime;
    /** 随机时间 */
    private Long randomTime;
    /** 优先级 */
    private Integer priority;
    /** 按钮链接 */
    private LinkVO buttonLink;
    /** 内容链接 */
    private LinkVO contentLink;
    /** 通知 */
    private NoticeVO notify;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTipsId() {
        return tipsId;
    }

    public void setTipsId(Long tipsId) {
        this.tipsId = tipsId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public LinkVO getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(LinkVO buttonLink) {
        this.buttonLink = buttonLink;
    }

    public LinkVO getContentLink() {
        return contentLink;
    }

    public void setContentLink(LinkVO contentLink) {
        this.contentLink = contentLink;
    }

    public NoticeVO getNotify() {
        return notify;
    }

    public void setNotify(NoticeVO notify) {
        this.notify = notify;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Long getRandomTime() {
        return randomTime;
    }

    public void setRandomTime(Long randomTime) {
        this.randomTime = randomTime;
    }

    @Override
    public String toString() {
        return "TipsVO{" +
                "name='" + name + '\'' +
                ", tipsId=" + tipsId +
                ", iconUrl='" + iconUrl + '\'' +
                ", displayText='" + displayText + '\'' +
                ", buttonName='" + buttonName + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", randomTime=" + randomTime +
                ", priority=" + priority +
                ", buttonLink=" + buttonLink +
                ", contentLink=" + contentLink +
                ", notify=" + notify +
                '}';
    }
}
