package com.esther.code.model;

import java.io.Serializable;

public class Flow implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 流程类型编码
	 */
	private String flowType;

	/**
	 * 流程名称
	 */
	private String flowName;

	/**
	 * 流程描述
	 */
	private String flowDesc;

	/**
	 * 获取 主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 流程类型编码
	 */
	public String getFlowType() {
		return flowType;
	}

	/**
	 * 设置 流程类型编码
	 */
	public void setFlowType(String flowType) {
		this.flowType = flowType == null ? null : flowType.trim();
	}

	/**
	 * 获取 流程名称
	 */
	public String getFlowName() {
		return flowName;
	}

	/**
	 * 设置 流程名称
	 */
	public void setFlowName(String flowName) {
		this.flowName = flowName == null ? null : flowName.trim();
	}

	/**
	 * 获取 流程描述
	 */
	public String getFlowDesc() {
		return flowDesc;
	}

	/**
	 * 设置 流程描述
	 */
	public void setFlowDesc(String flowDesc) {
		this.flowDesc = flowDesc == null ? null : flowDesc.trim();
	}
}