package com.vivo.jovi.scene.common.constant.activitycard;

/**
 * @author zhongjiajun
 * @date 2019/12/4 17:11
 * @describe 活动卡片状态枚举类
 */
public enum ActivityCardStatusEnum {
    /**
     * 草稿
     * */
    DRAFT(0, "草稿"),
    /**
     * 翻译待导入
     * */
    TRANSLATION_TO_BE_EXPORTED(1, "翻译待导入"),
    /**
     * 待审核
     * */
    AWAIT_AUDIT(2, "待审核"),
    /**
     * 审核驳回
     * */
    AUDIT_REJECT(3, "审核驳回"),
    /**
     * 待上线
     * */
    AWAIT_ONLINE(4, "待上线"),
    /**
     * 上线
     * */
    ONLINE(5, "上线"),
    /**
     * 下线
     * */
    OFFLINE(6, "下线"),
    /**
     * 禁用
     * */
    DISABLED(7, "禁用");

    ActivityCardStatusEnum(int status, String desc) {
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

    public static ActivityCardStatusEnum statusOf(Integer status) {
        if (status == null) {
            return null;
        }
        for (ActivityCardStatusEnum activityCardStatusEnum : values()) {
            if (activityCardStatusEnum.getStatus() == status) {
                return activityCardStatusEnum;
            }
        }
        return null;
    }
}
