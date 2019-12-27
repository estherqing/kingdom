package com.vivo.jovi.scene.common.constant;

/**
 * @Description 发布策略中活动来源枚举类
 * @auther zhongjiajun
 * @create 2019-12-07 15:46
 */
public enum SourceTypeEnum {
    QNR("QNR", "调研卡片"),
    ACT("ACT", "活动卡片"),
    ;

    SourceTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private String type;

    private String desc;

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static SourceTypeEnum statusOf(String type) {
        if (type == null) {
            return null;
        }
        for (SourceTypeEnum sourceTypeEnum : values()) {
            if (sourceTypeEnum.getType().equals(type)) {
                return sourceTypeEnum;
            }
        }
        return null;
    }
}
