package com.vivo.jovi.scene.common.model;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-21
 */
public class BizAttribute {
    private long bizId;
    private String bizName;
    private Integer versionCode;

    public long getBizId() {
        return bizId;
    }

    public void setBizId(long bizId) {
        this.bizId = bizId;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }
}
