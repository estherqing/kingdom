package com.vivo.jovi.scene.common.constant.activitycard;

/**
 * @author zhongjiajun
 * @date 2019/12/4 17:08
 * @describe 卡片位置枚举类
 */
public enum CardPositionEnum {
    /**
     * 在负一屏展示
     */
    DISPLAY(0, "在负一屏展示"),
    /**
     * 不在负一屏展示
     */
    DISAPPER(1, "不在负一屏展示"),
    ;

    CardPositionEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private Integer type;

    private String desc;

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static CardPositionEnum statusOf(Integer type) {
        if (type == null) {
            return null;
        }
        for (CardPositionEnum jumpTypeEnum : values()) {
            if (jumpTypeEnum.getType().intValue() == type) {
                return jumpTypeEnum;
            }
        }
        return null;
    }
}
