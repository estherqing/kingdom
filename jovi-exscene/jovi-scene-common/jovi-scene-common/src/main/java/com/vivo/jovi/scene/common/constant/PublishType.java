package com.vivo.jovi.scene.common.constant;

/**
 * 发布类型
 * @author Hu Han
 * @date 2019-02-20 16:54
 */
public enum PublishType {

    /**
     * 全量发布
     */
    ALL_PUBLISH(0, "全量发布"),

    /**
     * 灰度发布
     */
    GREY_PUBLISH(1, "灰度发布");

    PublishType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private Integer code;

    private String desc;

    public static String getDesc(int code) {
        for (PublishType value : values()) {
            if (value.getCode() == code) {
                return value.getDesc();
            }
        }
        return null;
    }


    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
