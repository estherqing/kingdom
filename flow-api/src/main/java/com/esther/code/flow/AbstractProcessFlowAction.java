package com.esther.code.flow;

import com.esther.code.api.IBusinessObjectProcessInfoService;
import com.esther.code.api.IUserService;
import com.esther.code.exception.CLSException;
import com.esther.code.flow.enums.ActionMethod;
import com.esther.code.flow.flownode.BusinessType;
import com.esther.code.flow.flownode.IFlowNodeService;
import com.esther.code.flow.flownode.IFlowService;
import com.esther.code.logger.LoggerWrapper;
import com.esther.code.logger.LoggerWrapperAware;
import com.esther.code.model.*;
import com.esther.code.pipeline.Pipeline;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author esther
 * 2018-04-28 9:24
 * $DESCRIPTION}
 */

public abstract class AbstractProcessFlowAction<E extends Exception> implements IBaseProcessAction<E>, InitializedProcessAction<E>, LoggerWrapperAware {
    @Autowired
    @Qualifier("enumBaseFlowNodeService")
    protected IFlowNodeService flowNodeService;

    @Autowired
    @Qualifier("defaultBOProcessInfoService")
    protected IBusinessObjectProcessInfoService boProcessInfoService;

    @Autowired
    protected IUserService userService;

    @Autowired
    @Qualifier("enumBaseFlowService")
    protected IFlowService flowService;

    @Autowired
    @Qualifier("submitPipeline")
    protected Pipeline<SubmitParam, E> submitPipeline;

    private LoggerWrapper logger;

    @Override
    public void setLogger(LoggerWrapper logger) {
        this.logger = logger;
    }

    public void submit(User user, boolean isOk) throws E {
        SubmitParam submitParam = new SubmitParam();
        submitParam.setUser(user);
        submitParam.setOk(isOk);
        getSubmitPipeline().handle(submitParam);
    }

    public SubmitParam constructSubmitParam(int nextNodeUserId, String nextNodeUserName, FlowNode nextFlowNode, BusinessObjectProcessInfo currentBOProcessInfo, ActionMethod actionMethod) throws E {
        SubmitParam submitParam = new SubmitParam();
        submitParam.setBusinessType(BusinessType.getInstance(currentBOProcessInfo.getBusinessType()));
        submitParam.setCurrentBOPInfo(currentBOProcessInfo);
        submitParam.setNextFlowNode(nextFlowNode);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(nextNodeUserId);
        user.setUserRealName(nextNodeUserName);
        users.add(user);
        submitParam.setNextUsers(users);
        submitParam.setActionMethod(actionMethod);

        submitParam.setOk(true);
        submitParam.setUser(user);
        return submitParam;
    }

    public SubmitParam doSubmit(int nextNodeUserId, String nextNodeUserName, FlowNode nextFlowNode, BusinessObjectProcessInfo currentBOProcessInfo) throws E {
        SubmitParam submitParam = constructSubmitParam(nextNodeUserId, nextNodeUserName, nextFlowNode, currentBOProcessInfo, ActionMethod.SUBMIT);
        getSubmitPipeline().handle(submitParam);
        return submitParam;
    }

    public SubmitParam doRollback(int nextNodeUserId, String nextNodeUserName, FlowNode nextFlowNode, BusinessObjectProcessInfo currentBOProcessInfo) throws E {
        SubmitParam submitParam = constructSubmitParam(nextNodeUserId, nextNodeUserName, nextFlowNode, currentBOProcessInfo, ActionMethod.ROLLBACK);
        getSubmitPipeline().handle(submitParam);// TODO
        return submitParam;
    }

    @Override
    public FlowNode getNextFlowNode(BusinessObjectProcessInfo currentBOProcessInfo) {
        return flowNodeService.getNextFlowNode(currentBOProcessInfo.getBusinessType(), currentBOProcessInfo.getNodeKey());
    }

    @Override
    public SubmitParam preSubmit(BusinessObjectProcessInfo currentBOProcessInfo) throws E {
        FlowNode nextFlowNode = getNextFlowNode(currentBOProcessInfo);
        Flow flow = flowService.getFlowByType(nextFlowNode.getFlowType());
        List<User> users = userService.getUserListForFlowNode(flow.getFlowType(), nextFlowNode.getNodeCode());
        if (CollectionUtils.isEmpty(users)) {
            logger.warn(() -> "===============================没有找到业务组为【{}】,流程类型为【{}】,节点为【{}】相应在的操作者!错识信息:{}===============================",
                    currentBOProcessInfo.getBusinessGroupId(), flow.getFlowType(), nextFlowNode.getNodeCode(), "");
        }
        SubmitParam submitParam = new SubmitParam();
        submitParam.setBusinessType(BusinessType.getInstance(currentBOProcessInfo.getBusinessType()));
        submitParam.setCurrentBOPInfo(currentBOProcessInfo);
        submitParam.setNextUsers(users);
        submitParam.setNextFlowNode(nextFlowNode);
        submitParam.setUser(users.get(0));
        return submitParam;
    }

    @Override
    public SubmitParam submit2NextNode(int nextNodeUserId, String nextNodeUserName, BusinessObjectProcessInfo currentBOProcessInfo) throws E {
        FlowNode nextFlowNode = getNextFlowNode(currentBOProcessInfo);
        return doSubmit(nextNodeUserId, nextNodeUserName, nextFlowNode, currentBOProcessInfo);
    }

    @Override
    public SubmitParam back2PreNode(BusinessObjectProcessInfo currentBOProcessInfo) throws E {
        BusinessObjectProcessInfo preInfo = boProcessInfoService.getPreProcessedInfoOfBOPInfo(currentBOProcessInfo);
        if (Objects.isNull(preInfo)) {
            throw new CLSException("没有找到前一节点的流程信息,有可能流程有所变更,变更后,旧流程数据不可退回");
        }
        FlowNode preFlowNode = flowNodeService.getFlowNode(preInfo.getBusinessType(), preInfo.getNodeKey());
        return doRollback(preInfo.getOperatorId(), preInfo.getOperatorName(), preFlowNode, currentBOProcessInfo);
    }

    @Override
    public Boolean cancel(BusinessObjectProcessInfo currentBOProcessInfo) throws Exception {
        throw new IllegalArgumentException("此节点不允许撤销");
    }

    @Override
    public BusinessObjectProcessInfo init(BusinessObjectProcessInfo currentBOProcessInfo) throws E {
        throw new IllegalArgumentException("此节点不允许初始化流程");
    }

    public Pipeline<SubmitParam, E> getSubmitPipeline() {
        return submitPipeline;
    }

    public void setSubmitPipeline(Pipeline<SubmitParam, E> submitPipeline) {
        this.submitPipeline = submitPipeline;
    }
}
