package com.esther.springboot;

import java.util.List;

/**
 * @author lijun
 * @date 2018/11/09
 * @since 1.0
 */
public class CommonVO {

    private Integer code;

    private Object data;

    private String msg;

    private List<String> log;

    public CommonVO() {
    }

    public CommonVO(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public CommonVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonVO(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public CommonVO(Integer code, Object data, String msg, List<String> log) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.log = log;
    }

    public static CommonVO success(Object data,List<String> log) {
        return new CommonVO(CommonVOCode.SUCCESS, data,null,log);
    }


    public static CommonVO success(Object data) {
        return new CommonVO(CommonVOCode.SUCCESS, data);
    }

    public static CommonVO success() {
        return success(null);
    }

    public static CommonVO badParams(String msg) {
        return new CommonVO(CommonVOCode.BAD_PARAMS, msg);
    }

    public static CommonVO badParams(Object data) {
        return badParams(data, null);
    }

    public static CommonVO badParams(Object data, String msg) {
        return new CommonVO(CommonVOCode.BAD_PARAMS, data, msg);
    }

    public static CommonVO badParams() {
        return badParams(null);
    }

    public static CommonVO error(Integer code, String msg, List<String> log) {
        return new CommonVO(code, null,msg,log);
    }

    public static CommonVO error(Integer code, String msg) {
        return new CommonVO(code, msg);
    }

    public static CommonVO error(Object data) {
        return new CommonVO(CommonVOCode.SERVER_ERROR, data);
    }

    public static CommonVO error() {
        return error(null);
    }

    public static CommonVO error(Integer code, Object data) {
        return new CommonVO(code, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }
}
