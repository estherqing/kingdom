package com.vivo.jovi.scene.common.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David
 */
public enum PublishGreyType {
    /**
     * 灰度类型
     */
    IMEI(0, "imei"),
    USER_TAG(1, "用户标签"),
    PHONE_MODEL(2, "外部机型"),
    ANDROID_VERSION(3, "安卓版本");

    PublishGreyType(int code, String desc) {
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

    public static List<PublishGreyType> getGreyTypeList(String greyTypeStr) {
        String[] types = greyTypeStr.split(",");
        List<PublishGreyType> result = new ArrayList<>();
        for (String typeStr : types) {
            for (PublishGreyType pg : PublishGreyType.values()) {
                if (pg.getCode().equals(Integer.valueOf(typeStr))) {
                    result.add(pg);
                }
            }
        }
        return result;
    }

    public static String getDesc(String greyTypeStr) {
        String[] types = greyTypeStr.split(",");
        StringBuilder sb = new StringBuilder();
        for (String type : types) {
            for (PublishGreyType pg : PublishGreyType.values()) {
                if (pg.getCode().equals(Integer.valueOf(type))) {
                    sb.append(pg.getDesc()).append(",");
                }
            }
        }
        return sb.toString();
    }
}
