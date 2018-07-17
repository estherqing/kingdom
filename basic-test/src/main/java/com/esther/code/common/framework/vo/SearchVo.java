package com.esther.code.common.framework.vo;
 
import java.io.Serializable;
import java.util.Map;

/**
 * 查询参数VO
 * 
 * @author chenyj
 * @version 2016-09-18
 */
public class SearchVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;// 用户ID
	private int pageNo;// 当前页码
	private int pageSize;// 每页显示条数
	private Map<String, String> searchMap;// 查询字符串

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, String> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(Map<String, String> searchMap) {
		this.searchMap = searchMap;
	}

}