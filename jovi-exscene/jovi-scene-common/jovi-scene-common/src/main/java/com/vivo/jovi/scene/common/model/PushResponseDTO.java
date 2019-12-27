package com.vivo.jovi.scene.common.model;

/**
 * @author WangWenqian
 * @version 1.0
 * @describe
 * @date 2017/12/14
 */
public class PushResponseDTO {

    private Integer code;

    private String msg;

    private Long data;

    private String timestamp;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
