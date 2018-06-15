package com.esther.code.model;

import java.io.Serializable;

public class FlowNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     */
	private Long id;

	/**
	 * 所属流程ID
	 */
	private String flowType;

	/**
	 * 节点所在流程内索引
	 */
	private Integer nodeIndex;

	/**
	 * 节点编码
	 */
	private String nodeCode;

	/**
	 * 节点名称
	 */
	private String nodeName;

	/**
	 * 节点描述
	 */
	private String nodeDesc;

	/**
     */
	public Long getId() {
		return id;
	}

	/**
     */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 所属流程ID
	 */
	public String getFlowType() {
		return flowType;
	}

	/**
	 * 设置 所属流程ID
	 */
	public void setFlowType(String flowType) {
		this.flowType = flowType == null ? null : flowType.trim();
	}

	/**
	 * 获取 节点所在流程内索引
	 */
	public Integer getNodeIndex() {
		return nodeIndex;
	}

	/**
	 * 设置 节点所在流程内索引
	 */
	public void setNodeIndex(Integer nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	/**
	 * 获取 节点编码
	 */
	public String getNodeCode() {
		return nodeCode;
	}

	/**
	 * 设置 节点编码
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode == null ? null : nodeCode.trim();
	}

	/**
	 * 获取 节点名称
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * 设置 节点名称
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName == null ? null : nodeName.trim();
	}

	/**
	 * 获取 节点描述
	 */
	public String getNodeDesc() {
		return nodeDesc;
	}

	/**
	 * 设置 节点描述
	 */
	public void setNodeDesc(String nodeDesc) {
		this.nodeDesc = nodeDesc == null ? null : nodeDesc.trim();
	}
}