package com.esther.code.model;

import com.esther.code.api.flow.enums.ActionMethod;
import com.esther.code.api.flow.flownode.BusinessType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author esther
 * 2018-04-27 18:02
 * $DESCRIPTION}
 */

public class SubmitParam {
    private User user;
    private boolean isOk;

    private FlowNode nextFlowNode;
    List<User> nextUsers;
    private BusinessObjectProcessInfo currentBOPInfo;
    private BusinessType businessType;
    private boolean isConfirmSubmit2NextUser;
    private BusinessObjectProcessInfo nextBOPInfo;
    private ActionMethod actionMethod;

    public FlowNode getNextFlowNode() {
        return nextFlowNode;
    }

    public void setNextFlowNode(FlowNode nextFlowNode) {
        this.nextFlowNode = nextFlowNode;
    }

    public List<User> getNextUsers() {
        return Objects.isNull(nextUsers) ? new ArrayList<>() : new ArrayList<>(nextUsers);
    }

    public void setNextUsers(List<User> nextUsers) {
        this.nextUsers = nextUsers;
    }

    public boolean isConfirmSubmit2NextUser() {
        return isConfirmSubmit2NextUser;
    }

    public void setConfirmSubmit2NextUser(boolean isConfirmSubmit2NextUser) {
        this.isConfirmSubmit2NextUser = isConfirmSubmit2NextUser;
    }

    public BusinessObjectProcessInfo getCurrentBOPInfo() {
        return currentBOPInfo;
    }

    public void setCurrentBOPInfo(BusinessObjectProcessInfo currentBOPInfo) {
        this.currentBOPInfo = currentBOPInfo;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public BusinessObjectProcessInfo getNextBOPInfo() {
        return nextBOPInfo;
    }

    public void setNextBOPInfo(BusinessObjectProcessInfo nextBOPInfo) {
        this.nextBOPInfo = nextBOPInfo;
    }

    public ActionMethod getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(ActionMethod actionMethod) {
        this.actionMethod = actionMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }
}
