package com.vivo.jovi.scene.common.constant.activitycard;

/**
 * @author zhongjiajun
 * @date 2019/12/4 17:10
 * @describe 审核结果枚举类
 */
public enum AuditStatusEnum {
    /**
     * 待审核
     */
    AUDITING(0, "待审核"),
    /**
     * 通过
     */
    AUDIT_PASS(1, "通过"),
    /**
     * 不通过
     */
    AUDIT_REJECT(2, "不通过"),
    ;

    AuditStatusEnum(int status, String desc) {
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

    public static AuditStatusEnum statusOf(Integer status) {
        if (status == null) {
            return null;
        }
        for (AuditStatusEnum auditStatusEnum : values()) {
            if (auditStatusEnum.getStatus().intValue() == status) {
                return auditStatusEnum;
            }
        }
        return null;
    }
}
