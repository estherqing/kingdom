package com.esther.code.flow.adapter;

import com.esther.code.flow.IBusinessObjectProcessInfoService;
import com.esther.code.base.exception.I18NSupportException;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;
import com.esther.code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;


/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/15.
 */
@Transactional(rollbackFor = Exception.class)
public abstract class AbstractTestFlowActionAdapterImpl extends AbstractCommonActionAdapter<ITestProcessFlowAction> implements TestFlowProcessActionAdapter{

    @Autowired
    @Qualifier("defaultBOProcessInfoService")
    protected IBusinessObjectProcessInfoService boProcessInfoService;

    @Override
    public SubmitParam preSubmit(User user, BusinessObjectProcessInfo info) throws I18NSupportException {
        return super.preSubmit(user, info);
    }

    @SuppressWarnings("unchecked")
    @Override
    public BusinessObjectProcessInfo close(User user, BusinessObjectProcessInfo info) throws I18NSupportException {
        ITestProcessFlowAction action = fetchProcessAction(info);
        action.close(info);
        return info;
    }


    @Override
    public SubmitParam back2Launch(User user, BusinessObjectProcessInfo info) throws I18NSupportException {
        ITestProcessFlowAction action = fetchProcessAction(info);
        return action.back2Launch(info);
    }


    @Override
    public SubmitParam submit2NextByNodeKey(User user, BusinessObjectProcessInfo info, int nextNodeUserId, String nextNodeUserName, String nodeKey) throws I18NSupportException {
        ITestProcessFlowAction action = fetchProcessAction(info);
        return action.submit2NextByNodeKey(nextNodeUserId, nextNodeUserName, info, nodeKey);
    }
}
