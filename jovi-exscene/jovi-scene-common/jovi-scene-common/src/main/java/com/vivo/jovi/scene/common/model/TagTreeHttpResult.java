package com.vivo.jovi.scene.common.model;

public class TagTreeHttpResult {

    private String code;

    private TagTree data;

    private boolean succeed;

    private String errorMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TagTree getData() {
        return data;
    }

    public void setData(TagTree data) {
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
