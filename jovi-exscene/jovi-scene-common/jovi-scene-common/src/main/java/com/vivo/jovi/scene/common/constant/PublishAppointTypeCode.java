package com.vivo.jovi.scene.common.constant;

/**
 * @author David
 */
public enum PublishAppointTypeCode {
    /**
     * 指定
     */
    APPOINT(0,"指定"),
    SHIELD(1,"屏蔽");

    PublishAppointTypeCode(int code, String desc) {
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
