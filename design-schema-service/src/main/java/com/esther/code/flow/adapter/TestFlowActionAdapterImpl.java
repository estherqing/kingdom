package com.esther.code.flow.adapter;


import com.esther.code.flow.ProcessNodeActionMapper;
import com.esther.code.flow.flownode.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/15.
 */
@Component("testFlowProcessActionAdapterImpl")
@Transactional(rollbackFor = Exception.class)
public class TestFlowActionAdapterImpl extends AbstractTestFlowActionAdapterImpl
        implements TestFlowProcessActionAdapter {

    @Autowired
    @Qualifier("testProcessNodeActionMapper")
    private ProcessNodeActionMapper<ITestProcessFlowAction> processNodeActionMapper;

    @Override
    protected ProcessNodeActionMapper<ITestProcessFlowAction> getProcessNodeActionMapper() {
        return processNodeActionMapper;
    }

    @Override
    public BusinessType getBusinessType() {
        return BusinessType.TEST_FLOW;
    }
}
