package com.vivo.jovi.scene.common.model;

/**
 * @author WangWenqian
 * @version 1.0
 * @describe
 * @date 2017/8/9
 */
public class HttpResult {

    private Integer statusCode;

    private String response;

    public HttpResult(Integer statusCode, String response) {
        this.statusCode = statusCode;
        this.response = response;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getResponse() {
        return response;
    }
}
