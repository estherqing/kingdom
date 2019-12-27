package com.vivo.jovi.scene.common.dal.entity;

import java.util.Date;

public class SmsPlatform {
    private Integer id;

    private String fileName;

    private String md5;

    private Byte fileStatus;

    private Integer patchVersion;

    private String fileDownloadUrl;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Byte getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Byte fileStatus) {
        this.fileStatus = fileStatus;
    }

    public Integer getPatchVersion() {
        return patchVersion;
    }

    public void setPatchVersion(Integer patchVersion) {
        this.patchVersion = patchVersion;
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

    public String getFileDownloadUrl() {
        return fileDownloadUrl;
    }

    public void setFileDownloadUrl(String fileDownloadUrl) {
        this.fileDownloadUrl = fileDownloadUrl;
    }
}