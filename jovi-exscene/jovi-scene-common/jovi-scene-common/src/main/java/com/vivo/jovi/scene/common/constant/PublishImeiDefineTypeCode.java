package com.vivo.jovi.scene.common.constant;

/**
 * @author David
 */
public enum PublishImeiDefineTypeCode {

    /**
     * imei定义方式
     */
    UPLOAD_MODE(0,"上传IMEI"),
    MANTISSA_MODE(1,"尾数灰度");


    PublishImeiDefineTypeCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
