package com.vivo.jovi.scene.common.constant;

/**
 * @author huhan
 * @description
 * @date 2019-08-17 9:40
 */
public enum QuestionTypeEnum {

    RADIO(0, "单选"),
    MULTIPLE(1, "多选"),
    TEXT(2, "文本");

    QuestionTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static QuestionTypeEnum statusOf(int code) {
        for (QuestionTypeEnum questionTypeEnum : values()) {
            if (questionTypeEnum.getCode() == code) {
                return questionTypeEnum;
            }
        }
        return null;
    }
}
