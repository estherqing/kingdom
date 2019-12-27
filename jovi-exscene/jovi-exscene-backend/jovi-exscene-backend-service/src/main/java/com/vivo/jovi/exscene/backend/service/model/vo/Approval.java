package com.vivo.jovi.exscene.backend.service.model.vo;

import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;

public class Approval {

    private String strategyId;

    private Integer status;

    private String reason;

    private String approvalTestUserId;

    private String approvalTestUserName;

    private String approvalTestReason;

    private Integer approvalTestStatus;

    private String approvalOperationUserId;

    private String approvalOperationUserName;

    private String approvalOperationReason;

    private Integer approvalOperationStatus;

    public Approval() {
    }

    public Approval(ExPublishEntity ae) {
        this.strategyId = ae.getStrategyId();
        this.approvalTestUserId = ae.getApprovalTestUserId();
        this.approvalTestUserName = ae.getApprovalTestUserName();
        this.approvalTestReason = ae.getApprovalTestReason();
        this.approvalTestStatus = ae.getApprovalTestStatus();
        this.approvalOperationUserId = ae.getApprovalOperationUserId();
        this.approvalOperationUserName = ae.getApprovalOperationUserName();
        this.approvalOperationReason = ae.getApprovalOperationReason();
        this.approvalOperationStatus = ae.getApprovalOperationStatus();
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
}
