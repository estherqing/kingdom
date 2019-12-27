package com.vivo.jovi.scene.common.dal.entity;

import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @Description
 * @Author Lu Guodong
 * @Date 2019-03-11 11:03
 */

public class CardsEntity extends BizEntity{
    private Long id;

    private String cardId;

    /**cards名称*/
    private String cardName;

    /**卡片类型*/
    private Integer cardType;

    /**卡片版本*/
    private Integer cardVersionCode;

    /**版本名称*/
    private String cardVersionName;

    /**模板中卡片状态，1已上架，2已下架，搜索中控中使用*/
    private Integer cardState;

    /**卡片压缩包地址*/
    private String cardUrl;

    /**卡片压缩包md5*/
    private String fileMd5;

    /**卡片大小*/
    private Integer size;

    /**卡片引擎支持最小版本号*/
    private Integer minEngineVersion;

    /**cp卡片内容更新地址*/
    private String updateUrl;

    /**cp卡片更新时间间隔(秒)*/
    private Integer refreshDuration;

    /**卡片折叠的最小高度*/
    private Integer minHeight;

    /**卡片折叠的最大高度*/
    private Integer maxHeight;

    /**图标地址uri*/
    private String icon;

    /**图片描述*/
    private String description;

    /**卡片预览图url*/
    private String screenshots;

    /**卡片展开预览图url*/
    private String screenshotsExtend;

    /**备注*/
    private String remark;

    /**是否可折叠*/
    private Integer enableFold;

    /**包类型，1-上传包，2-更新包*/
    private Integer packageType;

    /**审核前状态,1:待上线; 2:驳回；7:已上线；8:已下线*/
    private Integer preApprovalStatus;

    /**修改者名字*/
    private String modifyUserName;

    /**最近更新的时间*/
    private Date modifyTime;

    /**创建时间*/
    private Date createTime;

    /**下线原因*/
    private String pulloffReason;

    /**禁用原因*/
    private String disableReason;

    /**驳回原因*/
    private String rejectReason;

    /**审核测试id*/
    private String approvalTestUserId;

    /**审核测试姓名*/
    private String approvalTestUserName;

    /**测试审核原因*/
    private String approvalTestReason;

    /**0 未审批；1审批通过；2 审批不通过*/
    private Integer approvalTestStatus;

    /**审核运营id*/
    private String approvalOperationUserId;

    /**审核运营姓名*/
    private String approvalOperationUserName;

    /**运营审核原因*/
    private String approvalOperationReason;

    /**0 未审批；1审批通过；2 审批不通过*/
    private Integer approvalOperationStatus;

    /**关联的发布策略*/
    private String publishStrategyId;

    /**Jovi服务id ,服务唯一标识*/
    private String serviceId;

    /** Jovi服务类型, 1-应用直达 2-数据接口3-jovi卡片 4-卡片模板与数据接口联合数据（搜索中控）*/
    private Integer serviceType;

    /** Jovi服务名称*/
    private String serviceName;

    /** Jovi服务简介*/
    private String serviceDesc;

    /** Jovi服务一级分类*/
    private Integer categorieId;

    /** Jovi服务一级分类名称*/
    private String categorieName;

    /** Jovi服务二级分类*/
    private Integer subCategorieId;

    /** Jovi服务二级分类名称*/
    private String subCategorieName;

    /** Jovi服务状态, 1-待分发、2-审核中、3-审核未通过、4-部分入口审核通过待上架、5-全部入口审核通过待上架、6-部分入口上架、7-全部入口上架、8-已下架、9-禁用*/
    private Integer serviceState;

    /** Jovi服务更新说明*/
    private String updateDesc;

    /** 流量入口类别, 1-智慧场景、2-jovi语音、3-全局搜索、4-智慧桌面*/
    private Integer accessType;

    /** 各流量入口Jovi服务状态, 3-待上架 4-已上架 5-已下架 6-禁用*/
    private Integer state;

    /** Jovi服务状态变化原因*/
    private String desc;

    /**是否进行逻辑删除，0-未删除，1-已删除*/
    private Integer isDelete;

    /**意图关键词*/
    private String intentKeyWord;

    /**意图标准话术*/
    private String intentNormalJasgon;

    /**场景配置*/
    private String sceneConfig;

    /** 卡片关联快应用包名,如：com.ss.quickapp.auto*/
    private String rpkPackage;

    /** 卡片关联app包名*/
    private String apkPackage;

    /** 启动app的类名*/
    private String appClassName;

    /** 依赖apk最小版本号*/
    private Integer minApkVersion;

    /** 快应用卡片路径，如/demo*/
    private String rpkCardPath;

    /**快应用引擎支持最小版本号 */
    private Integer minPlatformVersion;

    /** 依赖rpk最小版本号*/
    private Integer minRpkVersion;

    /** 分发途径*/
    private String distributeChannel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public Integer getCardVersionCode() {
        return cardVersionCode;
    }

    public void setCardVersionCode(Integer cardVersionCode) {
        this.cardVersionCode = cardVersionCode;
    }

    public String getCardVersionName() {
        return cardVersionName;
    }

    public void setCardVersionName(String cardVersionName) {
        this.cardVersionName = cardVersionName;
    }

    public Integer getCardState() {
        return cardState;
    }

    public void setCardState(Integer cardState) {
        this.cardState = cardState;
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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getMinEngineVersion() {
        return minEngineVersion;
    }

    public void setMinEngineVersion(Integer minEngineVersion) {
        this.minEngineVersion = minEngineVersion;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public Integer getRefreshDuration() {
        return refreshDuration;
    }

    public void setRefreshDuration(Integer refreshDuration) {
        this.refreshDuration = refreshDuration;
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

    public String getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(String screenshots) {
        this.screenshots = screenshots;
    }

    public String getScreenshotsExtend() {
        return screenshotsExtend;
    }

    public void setScreenshotsExtend(String screenshotsExtend) {
        this.screenshotsExtend = screenshotsExtend;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnableFold() {
        return enableFold;
    }

    public void setEnableFold(Integer enableFold) {
        this.enableFold = enableFold;
    }

    public Integer getPackageType() {
        return packageType;
    }

    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    public Integer getPreApprovalStatus() {
        return preApprovalStatus;
    }

    public void setPreApprovalStatus(Integer preApprovalStatus) {
        this.preApprovalStatus = preApprovalStatus;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPulloffReason() {
        return pulloffReason;
    }

    public void setPulloffReason(String pulloffReason) {
        this.pulloffReason = pulloffReason;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getApprovalTestUserId() {
        return approvalTestUserId;
    }

    public void setApprovalTestUserId(String approvalTestUserId) {
        this.approvalTestUserId = approvalTestUserId;
    }

    public String getApprovalTestUserName() {
        return approvalTestUserName;
    }

    public void setApprovalTestUserName(String approvalTestUserName) {
        this.approvalTestUserName = approvalTestUserName;
    }

    public String getApprovalTestReason() {
        return approvalTestReason;
    }

    public void setApprovalTestReason(String approvalTestReason) {
        this.approvalTestReason = approvalTestReason;
    }

    public Integer getApprovalTestStatus() {
        return approvalTestStatus;
    }

    public void setApprovalTestStatus(Integer approvalTestStatus) {
        this.approvalTestStatus = approvalTestStatus;
    }

    public String getApprovalOperationUserId() {
        return approvalOperationUserId;
    }

    public void setApprovalOperationUserId(String approvalOperationUserId) {
        this.approvalOperationUserId = approvalOperationUserId;
    }

    public String getApprovalOperationUserName() {
        return approvalOperationUserName;
    }

    public void setApprovalOperationUserName(String approvalOperationUserName) {
        this.approvalOperationUserName = approvalOperationUserName;
    }

    public String getApprovalOperationReason() {
        return approvalOperationReason;
    }

    public void setApprovalOperationReason(String approvalOperationReason) {
        this.approvalOperationReason = approvalOperationReason;
    }

    public Integer getApprovalOperationStatus() {
        return approvalOperationStatus;
    }

    public void setApprovalOperationStatus(Integer approvalOperationStatus) {
        this.approvalOperationStatus = approvalOperationStatus;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public Integer getSubCategorieId() {
        return subCategorieId;
    }

    public void setSubCategorieId(Integer subCategorieId) {
        this.subCategorieId = subCategorieId;
    }

    public String getSubCategorieName() {
        return subCategorieName;
    }

    public void setSubCategorieName(String subCategorieName) {
        this.subCategorieName = subCategorieName;
    }

    public Integer getServiceState() {
        return serviceState;
    }

    public void setServiceState(Integer serviceState) {
        this.serviceState = serviceState;
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getIntentKeyWord() {
        return intentKeyWord;
    }

    public void setIntentKeyWord(String intentKeyWord) {
        this.intentKeyWord = intentKeyWord;
    }

    public String getIntentNormalJasgon() {
        return intentNormalJasgon;
    }

    public void setIntentNormalJasgon(String intentNormalJasgon) {
        this.intentNormalJasgon = intentNormalJasgon;
    }

    public String getSceneConfig() {
        return sceneConfig;
    }

    public void setSceneConfig(String sceneConfig) {
        this.sceneConfig = sceneConfig;
    }

    public String getRpkPackage() {
        return rpkPackage;
    }

    public void setRpkPackage(String rpkPackage) {
        this.rpkPackage = rpkPackage;
    }

    public String getApkPackage() {
        return apkPackage;
    }

    public void setApkPackage(String apkPackage) {
        this.apkPackage = apkPackage;
    }

    public String getAppClassName() {
        return appClassName;
    }

    public void setAppClassName(String appClassName) {
        this.appClassName = appClassName;
    }

    public Integer getMinApkVersion() {
        return minApkVersion;
    }

    public void setMinApkVersion(Integer minApkVersion) {
        this.minApkVersion = minApkVersion;
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

    public Integer getMinRpkVersion() {
        return minRpkVersion;
    }

    public void setMinRpkVersion(Integer minRpkVersion) {
        this.minRpkVersion = minRpkVersion;
    }

    public String getDistributeChannel() {
        return distributeChannel;
    }

    public void setDistributeChannel(String distributeChannel) {
        this.distributeChannel = distributeChannel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public CardsEntity cloneAndCopyPublishInfo(PublishEntity publishEntity) {
        CardsEntity newEntity = new CardsEntity();
        BeanUtils.copyProperties(this,newEntity);
        newEntity.setStrategyId(publishEntity.getStrategyId());
        newEntity.setStatusInPublish(publishEntity.getBizStatus());
        newEntity.setPublishStatus(publishEntity.getStatus());
        newEntity.setBizId(newEntity.getCardId());
        newEntity.setVersionCode(newEntity.getCardVersionCode());
        newEntity.setBizType(newEntity.getRpkPackage() + "_" + newEntity.getRpkCardPath());
        newEntity.setPublishCreateTime(publishEntity.getCreateTime());
        newEntity.setPublishUpdateTime(publishEntity.getUpdateTime());
        return newEntity;
    }
}
