package com.vivo.jovi.scene.common.constant.activitycard;


/**
 * @author zhongjiajun
 * @date 2019/12/4 17:08
 * @describe 跳转类型枚举类
 */
public enum JumpTypeEnum {
    /**
     * 不跳转
     */
    NO_JUMP(0, "不跳转"),
    /**
     * 智慧场景
     */
    JOVI_SCENE(1, "智慧场景"),
    /**
     * 网页
     */
    WEBSITE(2, "网页"),
    /**
     * 自定义
     */
    CUSTOM(3, "自定义"),
    ;

    JumpTypeEnum(int type, String desc) {
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

    public static JumpTypeEnum statusOf(Integer type) {
        if (type == null) {
            return null;
        }
        for (JumpTypeEnum jumpTypeEnum : values()) {
            if (jumpTypeEnum.getType().intValue() == type) {
                return jumpTypeEnum;
            }
        }
        return null;
    }
}
