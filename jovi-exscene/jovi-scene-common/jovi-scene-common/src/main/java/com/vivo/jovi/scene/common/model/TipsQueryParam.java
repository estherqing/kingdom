package com.vivo.jovi.scene.common.model;

import java.util.List;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-21
 */
public class TipsQueryParam {

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

    private List<BizAttribute> bizList;

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


    public List<BizAttribute> getBizList() {
        return bizList;
    }

    public void setBizList(List<BizAttribute> bizList) {
        this.bizList = bizList;
    }

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
}
