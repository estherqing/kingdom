package com.vivo.jovi.exscene.backend.service.model;

import java.io.Serializable;

/**
 * @program: ssdp-content-lib
 * @description: 卡片和快应用传输数据
 * @author: xuxitao
 * @create: 2018-10-26 19:52
 **/
public class RpkCard implements Serializable {

    private static final long serialVersionUID = -344080071363921944L;

    /**卡片id*/
    private Long cardId;

    private String apkPackage;

    /**快应用包名*/
    private String rpkPackage;

    /**卡片文件md5*/
    private String fileMd5;

    /**卡片名字*/
    private String cardName;

    /**卡片类型：1-快应用卡片*/
    private Integer cardType;

    /**卡片路径*/
    private String cardPath;

    /**卡片版本名字*/
    private String versionName;

    /**卡片版本号*/
    private Integer versionCode;

    /**卡片压缩包vivofs fileId,需要自己配置前缀*/
    private String cardFileId;

    /**卡片大小*/
    private Long cardSize;

    /**支持的卡片引擎最小版本号,暂时不知道什么东西*/
    private Long minEngineVersion;

    /**支持快应用引擎最小版本号*/
    private Long minPlatformVersion;

    /**依赖的rpk最小版本号*/
    private Long minRpkVersion;

    /**是否折叠 1-是、0-否*/
    private Integer enableCollapse;

    /**折叠状态最小高度pd*/
    private String collapseMinHeight;

    /**折叠状态最大高度pd*/
    private String collapseMaxHeight;

    /**卡片icon fileId*/
    private String iconFileId;

    /**卡片一级分类*/
    private Integer categoryId;

    /**卡片一级分类名称*/
    private String categoryName;

    /**卡片二级分类*/
    private Integer subCategoryId;

    /**卡片二级分类名称*/
    private String subCategoryName;

    /**卡片简介*/
    private String shortDesc;

    /**更新说明*/
    private String updateDesc;

    /**卡片预览图fileId*/
    private String previewFileId;

    /**卡片展开状态预览图fileid*/
    private String expandPreviewFileId;

    /**卡片备注信息*/
    private String commentInfo;

    /**关键词*/
    private String keyword;

    /**开发者账号id*/
    private String developerUuid;

    /**支持智慧桌面版本号*/
    //private Long supportHiboardVersion;

    /**卡片当前状态，-1.禁用 1.已上架 2.已下架*/
    private Integer saleStatus;

    /**json格式，保存配置文件中的所有内容*/
    private String params;

    /**运营备注*/
    private String operationComment;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getApkPackage() {
        return apkPackage;
    }

    public void setApkPackage(String apkPackage) {
        this.apkPackage = apkPackage;
    }

    public String getRpkPackage() {
        return rpkPackage;
    }

    public void setRpkPackage(String rpkPackage) {
        this.rpkPackage = rpkPackage;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardPath() {
        return cardPath;
    }

    public void setCardPath(String cardPath) {
        this.cardPath = cardPath;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getCardFileId() {
        return cardFileId;
    }

    public void setCardFileId(String cardFileId) {
        this.cardFileId = cardFileId;
    }

    public Long getCardSize() {
        return cardSize;
    }

    public void setCardSize(Long cardSize) {
        this.cardSize = cardSize;
    }

    public Long getMinEngineVersion() {
        return minEngineVersion;
    }

    public void setMinEngineVersion(Long minEngineVersion) {
        this.minEngineVersion = minEngineVersion;
    }

    public Long getMinPlatformVersion() {
        return minPlatformVersion;
    }

    public void setMinPlatformVersion(Long minPlatformVersion) {
        this.minPlatformVersion = minPlatformVersion;
    }

    public Long getMinRpkVersion() {
        return minRpkVersion;
    }

    public void setMinRpkVersion(Long minRpkVersion) {
        this.minRpkVersion = minRpkVersion;
    }

    public Integer getEnableCollapse() {
        return enableCollapse;
    }

    public void setEnableCollapse(Integer enableCollapse) {
        this.enableCollapse = enableCollapse;
    }

    public String getCollapseMinHeight() {
        return collapseMinHeight;
    }

    public void setCollapseMinHeight(String collapseMinHeight) {
        this.collapseMinHeight = collapseMinHeight;
    }

    public String getCollapseMaxHeight() {
        return collapseMaxHeight;
    }

    public void setCollapseMaxHeight(String collapseMaxHeight) {
        this.collapseMaxHeight = collapseMaxHeight;
    }

    public String getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(String iconFileId) {
        this.iconFileId = iconFileId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
    }

    public String getPreviewFileId() {
        return previewFileId;
    }

    public void setPreviewFileId(String previewFileId) {
        this.previewFileId = previewFileId;
    }

    public String getExpandPreviewFileId() {
        return expandPreviewFileId;
    }

    public void setExpandPreviewFileId(String expandPreviewFileId) {
        this.expandPreviewFileId = expandPreviewFileId;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDeveloperUuid() {
        return developerUuid;
    }

    public void setDeveloperUuid(String developerUuid) {
        this.developerUuid = developerUuid;
    }

    public Integer getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Integer saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getOperationComment() {
        return operationComment;
    }

    public void setOperationComment(String operationComment) {
        this.operationComment = operationComment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RpkCard{");
        sb.append("cardId=").append(cardId);
        sb.append(", apkPackage='").append(apkPackage).append('\'');
        sb.append(", rpkPackage='").append(rpkPackage).append('\'');
        sb.append(", fileMd5='").append(fileMd5).append('\'');
        sb.append(", cardName='").append(cardName).append('\'');
        sb.append(", cardType=").append(cardType);
        sb.append(", cardPath='").append(cardPath).append('\'');
        sb.append(", versionName='").append(versionName).append('\'');
        sb.append(", versionCode=").append(versionCode);
        sb.append(", cardFileId='").append(cardFileId).append('\'');
        sb.append(", cardSize=").append(cardSize);
        sb.append(", minEngineVersion=").append(minEngineVersion);
        sb.append(", minPlatformVersion=").append(minPlatformVersion);
        sb.append(", minRpkVersion=").append(minRpkVersion);
        sb.append(", enableCollapse=").append(enableCollapse);
        sb.append(", collapseMinHeight='").append(collapseMinHeight).append('\'');
        sb.append(", collapseMaxHeight='").append(collapseMaxHeight).append('\'');
        sb.append(", iconFileId='").append(iconFileId).append('\'');
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", subCategoryId=").append(subCategoryId);
        sb.append(", subCategoryName='").append(subCategoryName).append('\'');
        sb.append(", shortDesc='").append(shortDesc).append('\'');
        sb.append(", updateDesc='").append(updateDesc).append('\'');
        sb.append(", previewFileId='").append(previewFileId).append('\'');
        sb.append(", expandPreviewFileId='").append(expandPreviewFileId).append('\'');
        sb.append(", commentInfo='").append(commentInfo).append('\'');
        sb.append(", keyword='").append(keyword).append('\'');
        sb.append(", developerUuid='").append(developerUuid).append('\'');
        sb.append(", saleStatus=").append(saleStatus);
        sb.append(", params='").append(params).append('\'');
        sb.append(", operationComment='").append(operationComment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
