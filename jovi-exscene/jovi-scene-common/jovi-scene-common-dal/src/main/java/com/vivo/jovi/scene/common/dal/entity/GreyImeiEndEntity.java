package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class GreyImeiEndEntity {
    private Integer id;

    private Long activityId;

    private Integer greyType;

    private Integer effectiveType;

    private String imeiEnd;

    private Integer imeiEndNum;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getGreyType() {
        return greyType;
    }

    public void setGreyType(Integer greyType) {
        this.greyType = greyType;
    }

    public Integer getEffectiveType() {
        return effectiveType;
    }

    public void setEffectiveType(Integer effectiveType) {
        this.effectiveType = effectiveType;
    }

    public String getImeiEnd() {
        return imeiEnd;
    }

    public void setImeiEnd(String imeiEnd) {
        this.imeiEnd = imeiEnd;
    }

    public Integer getImeiEndNum() {
        return imeiEndNum;
    }

    public void setImeiEndNum(Integer imeiEndNum) {
        this.imeiEndNum = imeiEndNum;
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
}