package com.esther.code.modules.vo;


import java.io.Serializable;

/**
 *  VO
 *
 * @author esther
 * @version 2016-09-19
 */
public class DictVo implements Serializable {

	private Integer id;// ID

    private String dictValue;//字典数据值

    private String dictLabel;//字典标签名

    private String dictType;//字典类型

    private String dictDesc;//字典类型描述

    private Short dictSort;//字典排序 
    
    private Integer delFlag;//删除字段

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDel() {
		return delFlag;
	}

	public void setDel(Integer del) {
		this.delFlag = del;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue == null ? null : dictValue.trim();
	}

	public String getDictLabel() {
		return dictLabel;
	}

	public void setDictLabel(String dictLabel) {
		this.dictLabel = dictLabel == null ? null : dictLabel.trim();
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType == null ? null : dictType.trim();
	}

	public String getDictDesc() {
		return dictDesc;
	}

	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc == null ? null : dictDesc.trim();
	}

	public Short getDictSort() {
		return dictSort;
	}

	public void setDictSort(Short dictSort) {
		this.dictSort = dictSort;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dictValue=").append(dictValue);
		sb.append(", dictLabel=").append(dictLabel);
		sb.append(", dictType=").append(dictType);
		sb.append(", dictDesc=").append(dictDesc);
		sb.append(", dictSort=").append(dictSort);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}