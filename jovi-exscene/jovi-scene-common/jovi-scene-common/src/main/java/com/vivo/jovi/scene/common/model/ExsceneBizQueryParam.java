package com.vivo.jovi.scene.common.model;

import com.vivo.jovi.scene.common.model.dto.QuestionnaireDTO;

import java.util.List;
import java.util.Map;

public class ExsceneBizQueryParam {
    private String role;

    private String userId;

    /**外部机型*/
    private String model;

    private String sysVersion;

    private Integer appVersion;

    /**内部机型*/
    private String pd;

    private String language;
    /**
     * 判定请求类型
     */
    private Map<String, List<QuestionnaireDTO>> bizMap;

    public ExsceneBizQueryParam(String role, String userId, String model, String sysVersion, Integer appVersion, String pd, String language, Map<String, List<QuestionnaireDTO>> bizMap) {
        this.role = role;
        this.userId = userId;
        this.model = model;
        this.sysVersion = sysVersion;
        this.appVersion = appVersion;
        this.pd = pd;
        this.language = language;
        this.bizMap = bizMap;
    }

    public ExsceneBizQueryParam() {
    }

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

    public Integer getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Integer appVersion) {
        this.appVersion = appVersion;
    }

    public Map<String, List<QuestionnaireDTO>> getBizMap() {
        return bizMap;
    }

    public void setBizMap(Map<String, List<QuestionnaireDTO>> bizMap) {
        this.bizMap = bizMap;
    }

    @Override
    public String toString() {
        return "ExsceneBizQueryParam{" +
                "role='" + role + '\'' +
                ", userId='" + userId + '\'' +
                ", model='" + model + '\'' +
                ", sysVersion='" + sysVersion + '\'' +
                ", appVersion=" + appVersion +
                ", pd='" + pd + '\'' +
                ", language='" + language + '\'' +
                ", bizMap=" + bizMap +
                '}';
    }
}
