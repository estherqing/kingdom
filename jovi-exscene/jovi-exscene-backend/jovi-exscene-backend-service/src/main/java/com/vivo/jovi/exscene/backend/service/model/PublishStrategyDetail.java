package com.vivo.jovi.exscene.backend.service.model;

import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class PublishStrategyDetail {

    private long id;

    /**
     * 发布策略id
     */
    private String strategyId;

    /**
     * 业务id
     */
    private String bizId;

    /**
     * 卡片状态
     */
    private Integer bizStatus;

    private Integer bizVersionCode;

    /**
     * 名称
     */
    private String name;

    private List<String> intelligSceneEdition;

    /**
     * 发布类型，0 全量；1 灰度
     */
    private Integer type;

    /**
     * 翻译文件路径
     */
    private String fileUrl;

    /**
     * 翻译文件名
     */
    private String fileName;

    /**
     * 指定role发布，多个用，分隔
     */
    private String roleGrey;

    /**
     * 状态，0 待发布；1 发布审核；2 待启动；3 驳回；4灰度; 5全量发布；6暂停中；7已失效
     */
    private Integer status;

    /**
     * 失效原因
     */
    private String failureReason;

    /**
     * 修改人名称
     */
    private String modifyUserName;

    private long expectedRelease;

    private long actualRelease;

    private String approvalTestUserId;

    private String approvalTestUserName;

    private String approvalTestReason;

    private Integer approvalTestStatus;

    private String approvalOperationUserId;

    private String approvalOperationUserName;

    private String approvalOperationReason;

    private Integer approvalOperationStatus;

    private Integer clientVersion;

    public PublishStrategyDetail() {

    }

    public PublishStrategyDetail(ExPublishEntity exPublishEntity) {
        this.id = exPublishEntity.getId();
        this.strategyId = exPublishEntity.getStrategyId();
        this.bizId = exPublishEntity.getBizId();
        this.bizStatus = exPublishEntity.getBizStatus();
        this.name = exPublishEntity.getBizName();
        if (StringUtils.isNotBlank(exPublishEntity.getIntelligSceneEdition())){
            this.intelligSceneEdition = Arrays.asList(exPublishEntity.getIntelligSceneEdition().split(","));
        }
        this.type = exPublishEntity.getType();
        this.fileUrl = exPublishEntity.getFileUrl();
        this.fileName = exPublishEntity.getFileName();
        this.roleGrey = exPublishEntity.getRoleGrey();
        this.status = exPublishEntity.getStatus();
        this.failureReason = exPublishEntity.getFailureReason();
        this.modifyUserName = exPublishEntity.getModifyUserName();
        this.clientVersion = exPublishEntity.getClientVersion() == null ? 0 : exPublishEntity.getClientVersion();
        this.expectedRelease = exPublishEntity.getExpectedRelease();
        this.actualRelease = exPublishEntity.getActualRelease();
        this.bizVersionCode = exPublishEntity.getBizVersionCode();
        this.approvalTestReason = exPublishEntity.getApprovalTestReason();
        this.approvalTestStatus = exPublishEntity.getApprovalTestStatus();
        this.approvalTestUserId = exPublishEntity.getApprovalTestUserId();
        this.approvalTestUserName = exPublishEntity.getApprovalTestUserName();
        this.approvalOperationReason = exPublishEntity.getApprovalOperationReason();
        this.approvalOperationStatus = exPublishEntity.getApprovalOperationStatus();
        this.approvalOperationUserId = exPublishEntity.getApprovalOperationUserId();
        this.approvalOperationUserName = exPublishEntity.getApprovalOperationUserName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIntelligSceneEdition() {
        return intelligSceneEdition;
    }

    public void setIntelligSceneEdition(List<String> intelligSceneEdition) {
        this.intelligSceneEdition = intelligSceneEdition;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRoleGrey() {
        return roleGrey;
    }

    public void setRoleGrey(String roleGrey) {
        this.roleGrey = roleGrey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public long getExpectedRelease() {
        return expectedRelease;
    }

    public void setExpectedRelease(long expectedRelease) {
        this.expectedRelease = expectedRelease;
    }

    public long getActualRelease() {
        return actualRelease;
    }

    public void setActualRelease(long actualRelease) {
        this.actualRelease = actualRelease;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Integer getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(Integer bizStatus) {
        this.bizStatus = bizStatus;
    }

    public Integer getBizVersionCode() {
        return bizVersionCode;
    }

    public void setBizVersionCode(Integer bizVersionCode) {
        this.bizVersionCode = bizVersionCode;
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

    public Integer getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(Integer clientVersion) {
        this.clientVersion = clientVersion;
    }
}
