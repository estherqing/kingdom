package com.vivo.jovi.scene.common.constant.activitycard;

/**
 * @author zhongjiajun
 * @date 2019/12/4 17:09
 * @describe 卡片触发消失枚举类
 */
public enum DisapperTypeEnum {
    /**
     * 点击消失
     */
    CLICK_DISAPPER(0, "点击消失"),
    /**
     * 点击不消失
     */
    CLICK_NOT_DISAPPER(1, "点击不消失"),
    ;

    DisapperTypeEnum(int type, String desc) {
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

    public static DisapperTypeEnum statusOf(int type) {
        for (DisapperTypeEnum disapperTypeEnum : values()) {
            if (disapperTypeEnum.getType() == type) {
                return disapperTypeEnum;
            }
        }
        return null;
    }
}
