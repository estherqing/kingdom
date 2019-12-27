package com.vivo.jovi.scene.common.constant.activitycard;

/**
 * @author zhongjiajun
 * @date 2019/12/4 17:09
 * @describe 卡片通知方式枚举类
 */
public enum NoticeTypeEnum {
    /**
     * 跟随卡片触发和消失时间
     */
    FOLLOW_CARD(0, "跟随卡片触发和消失时间"),
    /**
     * 自定义
     */
    CUSTOM(1, "自定义"),
    ;

    NoticeTypeEnum(int type, String desc) {
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

    public static NoticeTypeEnum statusOf(Integer type) {
        if (type == null) {
            return null;
        }
        for (NoticeTypeEnum noticeTypeEnum : values()) {
            if (noticeTypeEnum.getType().intValue() == type) {
                return noticeTypeEnum;
            }
        }
        return null;
    }
}
