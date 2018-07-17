package com.esther.code.common.framework.entity;

 
import java.io.Serializable;
import java.util.Date;


/**
 * Entity����
 * 
 * @author chenyj
 * @version 2016-09-02
 */
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id; // ��¼ID
	protected Date createDate; // ��������
	protected Date updateDate; // ��������
	protected int delFlag; // ɾ�����
	protected String remark; // ��ע

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
