package com.vivo.jovi.scene.common.model;


import org.apache.commons.lang3.StringUtils;

/**
 * 客户端基本参数
 * @author Tian Guangxin
 * @date 2018/03/01
 * @since 1.0
 */
public class DeviceBasicParam {
    private String imei;

    /**内部机型*/
    private String product;

    /**外部机型*/
    private String model;

    /**系统版本号*/
    private String sysVersion;

    /**场景系统客户端版本号*/
    private String appVersion;

    /**手机网络类型*/
    private String netType;

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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public boolean verify(){
        if(StringUtils.isBlank(imei) || imei.length() > 60){
            return false;
        }

        if(StringUtils.isBlank(sysVersion) || sysVersion.length() > 100){
            return false;
        }

        if(StringUtils.isBlank(product) || product.length() > 60){
            return false;
        }

        if(StringUtils.isBlank(model) || model.length() > 60){
            return false;
        }

        if(StringUtils.isBlank(appVersion) || appVersion.length() > 60){
            return false;
        }

        return true;
    }


}
