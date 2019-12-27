package com.vivo.jovi.scene.common.constant;
/**
 * @Description
 * @Author xj
 * @Date 2019-03-15 15:05
 */
public enum BackgroundStatusEnum {
    /**
     * 卡片状态
     */
    DRAFT(0, "草稿"),
    PENDING_AUDIT(1, "待审核"),
    PENDING_ONLINE(2, "待上架"),
    REJECT(3,  "驳回"),
//    OFFLINE_AUDIT(5, "上架审核"),
//    DISABLE_AUDIT(6, "下架审核"),
    ONLINE(4, "已上架"),
    OFFLINE(5, "已下架"),
    DISABLED(6, "已禁用");

    BackgroundStatusEnum(int status , String desc) {
        this.status = status;
        this.desc = desc;
    }

    private Integer status;

    private String desc;

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static BackgroundStatusEnum statusOf(int status) {
        for (BackgroundStatusEnum backgroundStatusEnum : values()) {
            if (backgroundStatusEnum.getStatus() == status) {
                return backgroundStatusEnum;
            }
        }
        return null;
    }
}
