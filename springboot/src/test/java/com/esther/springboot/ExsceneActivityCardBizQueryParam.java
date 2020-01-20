package com.esther.springboot;


/**
 * @Description 查询活动卡片的请求
 * @auther zhongjiajun
 * @create 2019-12-21 14:56
 */
public class ExsceneActivityCardBizQueryParam {
    private String role;

    private String userId;

    /**
     * 外部机型
     */
    private String model;

    private String sysVersion;

    private Integer appVersion;

    /**
     * 内部机型
     */
    private String pd;

    private String language;
    /**
     * 上一次客户端查询时间
     */
    private String lastQueryTime;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public Integer getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Integer appVersion) {
        this.appVersion = appVersion;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastQueryTime() {
        return lastQueryTime;
    }

    public void setLastQueryTime(String lastQueryTime) {
        this.lastQueryTime = lastQueryTime;
    }

    @Override
    public String toString() {
        return "ExsceneActivityCardBizQueryParam{" +
                "role='" + role + '\'' +
                ", userId='" + userId + '\'' +
                ", model='" + model + '\'' +
                ", sysVersion='" + sysVersion + '\'' +
                ", appVersion=" + appVersion +
                ", pd='" + pd + '\'' +
                ", language='" + language + '\'' +
                ", lastQueryTime=" + lastQueryTime +
                '}';
    }

    public String toCacheString() {
        return "params:role=" +role+"&appVersion="+appVersion+"&lastQueryTime="+lastQueryTime;
    }

}
