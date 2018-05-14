package com.esther.code.flow.flownode;


import com.esther.code.model.Flow;
import com.esther.code.model.FlowNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: jiyanbin@zafh.com.cn JDK: 1.8 Created on 15/11/10.
 */
@Service("enumBaseFlowService")
public class EnumBaseFlowServiceImpl implements IFlowService {

    @Autowired
    @Qualifier("enumBaseFlowNodeService")
    private IFlowNodeService flowNodeService;

    public void setFlowNodeService(IFlowNodeService flowNodeService) {
        this.flowNodeService = flowNodeService;
    }

    @Override
    public Flow getFlowByType(String type) {
        BusinessType businessType = BusinessType.getInstance(type);
        Flow flow = new Flow();
        flow.setFlowType(businessType.getBusinessType());
        flow.setFlowName(businessType.getDesc());
        flow.setFlowDesc(businessType.getDesc());
        return flow;
    }

    @Override
    public Flow find(long id) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    @Override
    public List<Flow> getAllFlows() {
        BusinessType[] businessTypes = BusinessType.values();
        return Stream.of(businessTypes)
                .map(bt -> {
                    Flow flow = new Flow();
                    flow.setFlowType(bt.getBusinessType());
                    flow.setFlowName(bt.getDesc());
                    flow.setFlowDesc(bt.getDesc());
                    return flow;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Map<Flow, List<FlowNode>> getFlowAndNodeMap() {
        List<Flow> flows = getAllFlows();
        Map<Flow, List<FlowNode>> flowFlowNodeMap = new HashMap<>();
        for (Flow flow : flows) {
            List<FlowNode> flowNodes = flowNodeService.getFlowNodes(flow.getFlowType());
            flowFlowNodeMap.put(flow, flowNodes);
        }
        return flowFlowNodeMap;
    }

    @Override
    public FlowNode getFirstFlowNode(String flowType) {
        FlowNodeOperator flowNodeOperator = BusinessType.getInstance(flowType).getFirstNode();
        if (flowNodeOperator == null){
            return null;}
        FlowNode node = new FlowNode();
        node.setFlowType(flowType);
        node.setNodeIndex(flowNodeOperator.getNodeIndex());
        node.setNodeCode(flowNodeOperator.getNodeCode());
        node.setNodeName(flowNodeOperator.getNodeName());
        node.setNodeDesc(flowNodeOperator.getNodeDesc());
        return node;
    }

    @Override
    public FlowNode getLastFlowNode(String flowType) {
        FlowNodeOperator flowNodeOperator = BusinessType.getInstance(flowType).getLastNode();
        if (flowNodeOperator == null){
            return null;}
        FlowNode node = new FlowNode();
        node.setFlowType(flowType);
        node.setNodeIndex(flowNodeOperator.getNodeIndex());
        node.setNodeCode(flowNodeOperator.getNodeCode());
        node.setNodeName(flowNodeOperator.getNodeName());
        node.setNodeDesc(flowNodeOperator.getNodeDesc());
        return node;
    }
}
