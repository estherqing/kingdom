package com.vivo.jovi.scene.common.constant;
/**
 * @Description
 * @Author xj
 * @Date 2019-03-15 15:05
 */
public enum CardsStatusEnum {
    /**
     * 卡片状态
     */
    WAITING_ONLINE(1, "待上线"),
    BACK(2,  "驳回"),
    //TOBEAUDITED(3, "待审核"),
    ONLINE_AUDIT(4, "上线审核"),
    OFFLINE_AUDIT(5, "下线审核"),
    DISABLEAUDIT(6, "禁用审核"),
    ONLINE(7, "已上线"),
    OFFLINE(8, "已下线"),
    DISABLED(9, "已禁用");

    CardsStatusEnum(int status , String desc) {
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

    public static CardsStatusEnum statusOf(int status) {
        for (CardsStatusEnum cardsStatusEnum : values()) {
            if (cardsStatusEnum.getStatus() == status) {
                return cardsStatusEnum;
            }
        }
        return null;
    }
}
