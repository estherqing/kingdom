package com.vivo.jovi.scene.common.model.vo;

import com.vivo.jovi.scene.common.model.BizObject;

import java.util.Date;

/**
 *
 * 背景图对象，用于返回数据给客户端
 * @author David
 * @version 3.0
 * @date 2019-05-23
 */
public class BackgroundVO extends BizObject {

    private Long bizId;
    private String name;
    private String pictureUrl;

    /**开始时间*/
    private Date startTime;
    /**结束时间*/
    private Date endTime;
    /**开始渐变背景颜色*/
    private String startBgColor;
    /**结束渐变背景颜色*/
    private String endBgColor;

    private LinkVO contentLink;

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public LinkVO getContentLink() {
        return contentLink;
    }

    public void setContentLink(LinkVO contentLink) {
        this.contentLink = contentLink;
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

    @Override
    public String toString() {
        return "BackgroundVO{" +
                "bizId=" + bizId +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startBgColor='" + startBgColor + '\'' +
                ", endBgColor='" + endBgColor + '\'' +
                ", contentLink=" + contentLink +
                '}';
    }
}
