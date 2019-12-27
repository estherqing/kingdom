package com.vivo.jovi.scene.common.constant;

/**
 * @Classname CardsServiceTypeEnum
 * @Description TODO
 * @Date 2019-03-27 10:38
 * @Created by xj
 * @Version 1.0
 */
public enum CardsServiceTypeEnum {

    DIRECT_APPLICATION(1, "应用直达"),
    DATA_INTERFACE(2, "数据接口"),
    JOVI_CARDS(3, "数据接口"),
    MIXED_DATA(4, "卡片模板与数据接口联合数据");

    CardsServiceTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;

    private String desc;

    public static CardsServiceTypeEnum codeOf(int code) {
        for (CardsServiceTypeEnum cardsServiceTypeEnum : values()) {
            if (cardsServiceTypeEnum.getCode() == code) {
                return cardsServiceTypeEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
