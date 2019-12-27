package com.vivo.jovi.scene.common.constant;
/**
 * @Description
 * @Author Lu Guodong
 * @Date 2019-05-15 11:53
 */
public enum JoviContentStatusEnum {
    WAITING_ONLINE(3, "待上架"),
    ONLINE(4, "已上架"),
    OFFLINE(5, "已下架"),
    DISABLED(6, "禁用");

    JoviContentStatusEnum(int status , String desc) {
        this.status = status;
        this.desc = desc;
    }

    private int status;

    private String desc;

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static JoviContentStatusEnum statusOf(int status) {
        for (JoviContentStatusEnum joviContentStatusEnum : values()) {
            if (joviContentStatusEnum.getStatus() == status) {
                return joviContentStatusEnum;
            }
        }
        return null;
    }
}
