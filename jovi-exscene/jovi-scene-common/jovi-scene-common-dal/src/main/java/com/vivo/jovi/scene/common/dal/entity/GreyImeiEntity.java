package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class GreyImeiEntity {
    private Integer id;

    private Long activityId;

    private Integer greyType;

    private Integer effectiveType;

    private String fileId;

    private String fileName;

    private String imei;

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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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