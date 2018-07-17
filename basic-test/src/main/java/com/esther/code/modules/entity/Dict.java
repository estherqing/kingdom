package com.esther.code.modules.entity;


import com.esther.code.common.framework.entity.BaseEntity;

/**
 * 字典表对应Entity
 *
 * @author esther
 * @version 2016-09-19
 */
public class Dict extends BaseEntity {

    private String dictValue;//字典数据值

    private String dictLabel;//字典标签名

    private String dictType;//字典类型

    private String dictDesc;//字典类型描述

    private Short dictSort;//字典排序

    private static final long serialVersionUID = 1L;

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
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", remark=").append(remark);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}