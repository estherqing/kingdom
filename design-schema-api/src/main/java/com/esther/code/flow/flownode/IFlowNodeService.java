package com.esther.code.flow.flownode;


import com.esther.code.model.FlowNode;

import java.util.List;

/**
 * Author: jiyanbin@zafh.com.cn JDK: 1.8 Created on 15/11/10.
 * <p/>
 * 流程服务数据字典接口
 */
public interface IFlowNodeService {

	/**
	 * 根据流程类型和节点编码获取流程节点
	 *
	 * @param flowType
	 *            流程类型
	 * @param nodeCode
	 *            节点编码
	 * @return
	 */
	public FlowNode getFlowNode(String flowType, String nodeCode);

	/**
	 * 获取某一流程下所有节点
	 *
	 * @param flowType
	 *            流程类型
	 * @return
	 */
	public List<FlowNode> getFlowNodes(String flowType);

	/**
	 * 根据流程类型和节点编码获取流程下一节点
	 *
	 * @param flowType
	 *            流程类型
	 * @param nodeCode
	 *            节点编码
	 * @return
	 */
	public FlowNode getNextFlowNode(String flowType, String nodeCode);

	/**
	 * 根据流程类型和节点编码获取流程前一节点
	 *
	 * @param flowType
	 *            流程类型
	 * @param nodeCode
	 *            节点编码
	 * @return
	 */
	public FlowNode getPreFlowNode(String flowType, String nodeCode);
}
