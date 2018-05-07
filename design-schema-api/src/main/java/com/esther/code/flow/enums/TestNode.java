package com.esther.code.flow.enums;

import com.esther.code.flow.flownode.BusinessType;
import com.esther.code.flow.flownode.FlowNodeOperator;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Author:jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 2015/11/27.
 *
 * 征信流程的节点定义
 */
public enum TestNode implements FlowNodeOperator<TestNode> {
    LAUNCH(1, "开始", ""),
    VERIFY(2, "验证", ""),
    REVIEW(3, "查看", "");

    private int nodeIndex;
    private String nodeName;
    private String desc;

    TestNode(int nodeIndex, String nodeName, String desc) {
        this.nodeIndex = nodeIndex;
        this.nodeName = nodeName;
        this.desc = desc;
    }

    public TestNode[] getValues() {
        return TestNode.values();
    }

    public int getNodeIndex() {
        return nodeIndex;
    }

    public String getNodeName() {
        return nodeName;
    }

    @Override
    public String getNodeDesc() {
        return desc;
    }


    public BusinessType getBusinessType() {
        return BusinessType.TEST_FLOW;
    }

    public String getNodeCode() {
        return name();
    }

    @Override
    public TestNode self() {
        return this;
    }


    public static TestNode getInstance(String nodeCode) {
        return Stream.of(TestNode.values())
                .filter(node -> Objects.equals(node.name(), nodeCode))
                .findAny()
                .orElse(null);
    }
}
