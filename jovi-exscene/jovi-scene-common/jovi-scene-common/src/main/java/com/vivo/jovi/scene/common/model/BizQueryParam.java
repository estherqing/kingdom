package com.vivo.jovi.scene.common.model;

import java.util.List;
import java.util.Map;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-03-21
 */
public class BizQueryParam {
    /** 是否启动debug记录, 0:否 1：是*/
    private Integer debug;
    /** imei*/
    private String imei;
    /**内部机型*/
    private String product;
    /**外部机型*/
    private String model;
    /**系统版本号*/
    private String sysVersion;
    /**场景系统客户端版本号*/
    private Integer appVersion;
    /**手机网络类型*/
    private String netType;
    /**内部机型*/
    private String pd;
    /**手机emmcId*/
    private String emmcid;
    /**sdk版本*/
    private Integer sdkVersion;
    /**负一屏版本*/
    private Integer hiveVersion;

    private String romVersion;
    /** 安卓版本*/
    private String androidVersion;

    private Map<String,List<BizAttribute>> bizMap;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getEmmcid() {
        return emmcid;
    }

    public void setEmmcid(String emmcid) {
        this.emmcid = emmcid;
    }

    public Integer getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(Integer sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public Integer getHiveVersion() {
        return hiveVersion;
    }

    public void setHiveVersion(Integer hiveVersion) {
        this.hiveVersion = hiveVersion;
    }

    public String getRomVersion() {
        return romVersion;
    }

    public void setRomVersion(String romVersion) {
        this.romVersion = romVersion;
    }

    public Map<String, List<BizAttribute>> getBizMap() {
        return bizMap;
    }

    public void setBizMap(Map<String, List<BizAttribute>> bizMap) {
        this.bizMap = bizMap;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public Integer getDebug() {
        return debug;
    }

    public void setDebug(Integer debug) {
        this.debug = debug;
    }
}
