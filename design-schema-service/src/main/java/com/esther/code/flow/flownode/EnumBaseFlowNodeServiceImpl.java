package com.esther.code.flow.flownode;


import com.esther.code.flow.flownode.BusinessType;
import com.esther.code.flow.flownode.FlowNodeOperator;
import com.esther.code.flow.flownode.IFlowNodeService;
import com.esther.code.model.FlowNode;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: jiyanbin@zafh.com.cn JDK: 1.8 Created on 15/11/10.
 */
@Service("enumBaseFlowNodeService")
public class EnumBaseFlowNodeServiceImpl implements IFlowNodeService {

    @Override
    public FlowNode getFlowNode(String flowType, String nodeCode) {
        BusinessType businessType = BusinessType.getInstance(flowType);
        FlowNodeOperator flowNodeOperator = businessType.getFlowNode(nodeCode);
        if (flowNodeOperator == null) {
            throw new NoSuchElementException("流程[" + flowType + "]中不存在[" + nodeCode + "]流程节点");
        }
        FlowNode node = new FlowNode();
        node.setFlowType(flowType);
        node.setNodeIndex(flowNodeOperator.getNodeIndex());
        node.setNodeCode(flowNodeOperator.getNodeCode());
        node.setNodeName(flowNodeOperator.getNodeName());
        node.setNodeDesc(flowNodeOperator.getNodeDesc());
        return node;
    }

    @Override
    public List<FlowNode> getFlowNodes(String flowType) {
        BusinessType businessType = BusinessType.getInstance(flowType);
        FlowNodeOperator[] flowNodeOperators = businessType.listFlowNode();
        return Stream.of(flowNodeOperators)
                .map(flowNodeOperator -> {
                    FlowNode node = new FlowNode();
                    node.setFlowType(flowType);
                    node.setNodeIndex(flowNodeOperator.getNodeIndex());
                    node.setNodeCode(flowNodeOperator.getNodeCode());
                    node.setNodeName(flowNodeOperator.getNodeName());
                    node.setNodeDesc(flowNodeOperator.getNodeDesc());
                    return node;
                })
                .collect(Collectors.toList());
    }

    @Override
    public FlowNode getNextFlowNode(String flowType, String nodeCode) {
        BusinessType businessType = BusinessType.getInstance(flowType);
        FlowNodeOperator flowNodeOperator = businessType.getFlowNode(nodeCode);

        List<FlowNode> nodes = getFlowNodes(flowType);
        FlowNode node = getFlowNode(flowType, nodeCode);
        Optional<FlowNode> nodeOptional = nodes.stream()
                .sorted((fn1, fn2) -> Integer.compare(fn1.getNodeIndex(), fn2.getNodeIndex()))
                .filter(fn -> fn.getNodeIndex() > node.getNodeIndex())
                .findFirst();
        return nodeOptional.orElse(null);
    }

    @Override
    public FlowNode getPreFlowNode(String flowType, String nodeCode) {
        List<FlowNode> nodes = getFlowNodes(flowType);
        FlowNode node = getFlowNode(flowType, nodeCode);
        Optional<FlowNode> nodeOptional = nodes.stream()
                .sorted(Comparator.comparing(FlowNode::getNodeIndex).reversed())
                .filter(fn -> fn.getNodeIndex() < node.getNodeIndex())
                .findFirst();
        return nodeOptional.orElse(null);
    }
}
