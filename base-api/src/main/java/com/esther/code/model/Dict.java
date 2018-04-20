package com.esther.code.model;

import java.io.Serializable;
import java.util.Date;

public class Dict implements Serializable{
    private static final long serialVersionUID = 5993286892322436566L;

    private Integer id;

    private String dictValue;

    private String dictLabel;

    private String dictType;

    private String dictDesc;

    private Short dictSort;

    private Date createDate;

    private Date updateDate;

    private String remark;

    private Short delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Short delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "id=" + id +
                ", dictValue='" + dictValue + '\'' +
                ", dictLabel='" + dictLabel + '\'' +
                ", dictType='" + dictType + '\'' +
                ", dictDesc='" + dictDesc + '\'' +
                ", dictSort=" + dictSort +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", remark='" + remark + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}