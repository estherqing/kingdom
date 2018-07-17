package com.esther.code.common.framework.global;

 

/**
 * 返回值enum
 * 
 * @author chenyj
 * @version 2016-09-18
 */
public enum ReturnCode {
	NORMAL("0", "操作成功"),
	INTERFACE_ERROR("1","接口有误"),
	ACTION_ERROR("2","操作失败"),
	AUTHORITY_ERROR("3","没有访问权限"),
	SYSTEM_ERROR("4","系统错误"),
	TIMEOUT_ERROR("5","处理超时"),
	PARAM_ERROR("6","输入参数有误");
	

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private ReturnCode(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
}
