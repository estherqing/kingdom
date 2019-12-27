package com.vivo.jovi.scene.common.model.vo;

import com.vivo.jovi.scene.common.model.BizObject;

/**
 * @author David
 * @version 3.0
 * @date 2019-03-08
 */
public class CardVO extends BizObject {

    private Long cardId;

    /**Jovi服务版本号 */
    private Integer serviceVer;

    /**Jovi服务类型 */
    private Integer serviceType;

    /**Jovi服务id */
    private String serviceId;

    /**cards名称*/
    private String cardName;

    /**卡片压缩包地址*/
    private String cardUrl;

    /**卡片压缩包md5*/
    private String fileMd5;

    /**卡片引擎支持最小版本号*/
    private Integer minEngineVersion;

    /**图标地址uri*/
    private String icon;

    /**图片描述*/
    private String description;

    /**是否可折叠*/
    private Integer enableFold;

    /** 卡片关联快应用包名,如：com.ss.quickapp.auto*/
    private String rpkPackage;


    /** 快应用卡片路径，如/demo*/
    private String rpkCardPath;

    /**快应用引擎支持最小版本号 */
    private Integer minPlatformVersion;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**卡片类型唯一标识*/
    private String bizType;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public Integer getMinEngineVersion() {
        return minEngineVersion;
    }

    public void setMinEngineVersion(Integer minEngineVersion) {
        this.minEngineVersion = minEngineVersion;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnableFold() {
        return enableFold;
    }

    public void setEnableFold(Integer enableFold) {
        this.enableFold = enableFold;
    }

    public String getRpkPackage() {
        return rpkPackage;
    }

    public void setRpkPackage(String rpkPackage) {
        this.rpkPackage = rpkPackage;
    }

    public String getRpkCardPath() {
        return rpkCardPath;
    }

    public void setRpkCardPath(String rpkCardPath) {
        this.rpkCardPath = rpkCardPath;
    }

    public Integer getMinPlatformVersion() {
        return minPlatformVersion;
    }

    public void setMinPlatformVersion(Integer minPlatformVersion) {
        this.minPlatformVersion = minPlatformVersion;
    }

    public Integer getServiceVer() {
        return serviceVer;
    }

    public void setServiceVer(Integer serviceVer) {
        this.serviceVer = serviceVer;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "CardVO{" +
                "cardId=" + cardId +
                ", serviceVer=" + serviceVer +
                ", serviceType=" + serviceType +
                ", serviceId='" + serviceId + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardUrl='" + cardUrl + '\'' +
                ", fileMd5='" + fileMd5 + '\'' +
                ", minEngineVersion=" + minEngineVersion +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                ", enableFold=" + enableFold +
                ", rpkPackage='" + rpkPackage + '\'' +
                ", rpkCardPath='" + rpkCardPath + '\'' +
                ", minPlatformVersion=" + minPlatformVersion +
                ", bizType='" + bizType + '\'' +
                '}';
    }
}
