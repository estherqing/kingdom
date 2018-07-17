package com.esther.code.common.framework.page;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description：分页实体类
 * @author：chenyj
 */
public class PageInfo<T> {
	private int pageNo;// 当前页码
	private int pageSize;// 每页记录数
	private int totalRecord;// 总记录数
	private List<T> dataList = new ArrayList<T>();// 每页数据
	private int start;// 起始位置
	private boolean isLastPage;//是否是最后一页
	private Map<String,Object> searchMap;// 查询条件

	public PageInfo(int pageNo, int pageSize, int totalRecord, Map<String,Object> searchMap) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.start = (this.pageNo - 1) * this.pageSize;
		this.totalRecord = totalRecord;
		if(pageNo*pageSize >= totalRecord){
			this.isLastPage = true;
		}else{
			this.isLastPage = false;
		}
		this.searchMap = searchMap;
	}

	@JsonIgnore
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@JsonIgnore
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@JsonIgnore
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	@JsonIgnore
	public Map<String, Object> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(Map<String, Object> searchMap) {
		this.searchMap = searchMap;
	}

}
