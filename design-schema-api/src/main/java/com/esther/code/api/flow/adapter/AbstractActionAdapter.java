package com.esther.code.api.flow.adapter;

import com.esther.code.api.flow.IBaseProcessAction;
import com.esther.code.api.flow.ProcessNodeActionMapper;
import com.esther.code.api.flow.flownode.IFlowNodeService;
import com.esther.code.api.flow.flownode.IFlowService;
import com.esther.code.base.exception.I18NSupportException;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;
import com.esther.code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/12/2.
 */
public abstract class AbstractActionAdapter<Action extends IBaseProcessAction<I18NSupportException>> implements ActionAdapter {

    @Autowired
    @Qualifier("enumBaseFlowNodeService")
    protected IFlowNodeService flowNodeService;

    @Autowired
    @Qualifier("enumBaseFlowService")
    protected IFlowService flowService;

    protected Action fetchProcessAction(BusinessObjectProcessInfo info) {
        String currentFlowType = info.getBusinessType();
        String currentFlowNodeCode = info.getNodeKey();
        Action action = getProcessNodeActionMapper().getActionByFlowNodeKey(currentFlowType + "#" + currentFlowNodeCode);
        return action;
    }

    protected abstract ProcessNodeActionMapper<Action> getProcessNodeActionMapper();

    @Override
    public SubmitParam back2PreNode(User user, BusinessObjectProcessInfo info) throws I18NSupportException {
        IBaseProcessAction<I18NSupportException> action = fetchProcessAction(info);
        return action.back2PreNode(info);
    }

    @Override
    public SubmitParam preSubmit(User user, BusinessObjectProcessInfo info) throws I18NSupportException {
        IBaseProcessAction<I18NSupportException> action = fetchProcessAction(info);
        return action.preSubmit(info);
    }

    @Override
    public SubmitParam submit2NextNode(User user, BusinessObjectProcessInfo info, int nextNodeUserId, String nextNodeUserName) throws I18NSupportException {
        IBaseProcessAction<I18NSupportException> action = fetchProcessAction(info);
        return action.submit2NextNode(nextNodeUserId, nextNodeUserName, info);
    }

    @Override
    public Boolean cancel(User user, BusinessObjectProcessInfo info) throws I18NSupportException {
        IBaseProcessAction<I18NSupportException> action = fetchProcessAction(info);
        return action.cancel(info);
    }

}
