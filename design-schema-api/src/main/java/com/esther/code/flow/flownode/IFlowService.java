package com.esther.code.flow.flownode;

import com.esther.code.model.Flow;
import com.esther.code.model.FlowNode;

import java.util.List;
import java.util.Map;

/**
 * Author: jiyanbin@zafh.com.cn
 * JDK: 1.8
 * Created on 15/11/10.
 *
 * 流程服务数据字典接口
 */

public interface IFlowService {

	/**
	 * 根据流程类型获取流程对象
	 *
	 * @param type
	 *            流程类型编码
	 * @return
	 */
	public Flow getFlowByType(String type);

	/**
	 * 根据主键查询Flow
	 *
	 * @param id
	 * @return
	 */
	public Flow find(long id);

	/**
	 * 获取全部流程
	 *
	 * @return
	 */
	public List<Flow> getAllFlows();

	/**
	 * 获取所有流程和节点的映射关系
	 *
	 * @return
	 */
	public Map<Flow, List<FlowNode>> getFlowAndNodeMap();

    /**
     * 获取流程第一个节点
     * @param flowType 流程编码
     * @return
     */
    public FlowNode getFirstFlowNode(String flowType);

    /**
     * 获取流程最后一个节点
     * @param flowType 流程编码
     * @return
     */
    public FlowNode getLastFlowNode(String flowType);
}
