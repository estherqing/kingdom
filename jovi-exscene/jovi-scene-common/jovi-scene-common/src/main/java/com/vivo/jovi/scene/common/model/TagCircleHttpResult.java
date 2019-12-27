package com.vivo.jovi.scene.common.model;

public class TagCircleHttpResult {

    private String code;

    private TagCircle data;

    private boolean succeed;

    private String errorMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TagCircle getData() {
        return data;
    }

    public void setData(TagCircle data) {
        this.data = data;
    }

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
