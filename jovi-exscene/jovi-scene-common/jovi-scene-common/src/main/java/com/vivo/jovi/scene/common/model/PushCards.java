package com.vivo.jovi.scene.common.model;

/**
 * @Classname PushCards
 * @Description TODO
 * @Date 2019-03-26 18:24
 * @Created by Administrator
 * @Version 1.0
 */

public class PushCards {

    private String cardId;

    private Integer op;

    private String cardName;

    private String version;

    private String cardUrl;

    private String fileMd5;

    private Integer minHeight;

    private Integer maxHeight;

    private String icon;

    private String description;

    private String enableFold;

    private String rpkPackage;

    private String rpkCardPath;

    private Integer minPlatformVersion;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public Integer getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Integer minHeight) {
        this.minHeight = minHeight;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
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

    public String getEnableFold() {
        return enableFold;
    }

    public void setEnableFold(String enableFold) {
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
}
