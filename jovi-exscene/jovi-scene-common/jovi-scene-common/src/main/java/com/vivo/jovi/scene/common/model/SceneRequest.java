package com.vivo.jovi.scene.common.model;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author Tian Guangxin
 * @date 2018/11/13
 * @since 1.0
 */
public class SceneRequest {

    /**外部机型*/
    private String model;

    /**内部机型*/
    private String pd;

    /**系统版本号*/
    private String sysVersion;

    /**场景系统客户端版本号*/
    private String appVersion;

    /**手机imei*/
    private String imei;

    /**手机emmcId*/
    private String emmcId;

    /**手机网络类型*/
    private String netType;

    private List<SceneAttribute> sceneAttributes;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getSysVersion() {
        return sysVersion;
    }

    public void setSysVersion(String sysVersion) {
        this.sysVersion = sysVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getEmmcId() {
        return emmcId;
    }

    public void setEmmcId(String emmcId) {
        this.emmcId = emmcId;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public List<SceneAttribute> getSceneAttributes() {
        return sceneAttributes;
    }

    public void setSceneAttributes(List<SceneAttribute> sceneAttributes) {
        this.sceneAttributes = sceneAttributes;
    }

    public boolean basicParamsVerfiy(){
        if(StringUtils.isBlank(model) || StringUtils.isBlank(pd) || StringUtils.isBlank(sysVersion) ||
                StringUtils.isBlank(appVersion) || StringUtils.isBlank(imei) ||
                StringUtils.isBlank(emmcId) || StringUtils.isBlank(netType)){
         return false;
        }
        return true;
    }
}
