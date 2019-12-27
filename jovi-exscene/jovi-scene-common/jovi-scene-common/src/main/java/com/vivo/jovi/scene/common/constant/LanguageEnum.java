package com.vivo.jovi.scene.common.constant;

/**
 * @Classname LanguageEnum
 * @Description TODO
 * @Date 2019-05-21 14:55
 * @Created by Administrator
 * @Version 1.0
 */
public enum LanguageEnum {

    CHINESE("zh_CN", "中文"),
    ENGLISH("en_US", "英语"),
    HINDI("hi_IN", "印地语");

     LanguageEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private String value;

    private String desc;

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static LanguageEnum getEnum(String value) {
        for (LanguageEnum languageEnum : values()) {
            if (languageEnum.getValue().equals(value)) {
                return languageEnum;
            }
        }
        return null;
    }
}
