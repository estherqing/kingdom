package com.vivo.jovi.scene.common.constant;

/**
 * @Description
 * @Author xj
 * @Date 2019-03-15 15:05
 */
public enum CardsOperationTypeEnum {

    ONLINE_AUDIT_SUCCESS(4,4, 1, 7, "待上线卡片上线审核通过"),
    ONLINE_AUDIT_FAILED(4,4, 2, 2, "待上线卡片上线审核不通过"),
    OFFLINE_AUDIT_SUCCESS(5,5, 1, 8, "已上线卡片下线审核通过"),
    OFFLINE_AUDIT_FAILED(5,5, 2, 7, "已上线卡片下线审核不通过"),
    ON_LINE_DISABLE_AUDIT_SUCCESS(6,6, 1, 9, "已上线卡片禁用审核通过"),
    ON_LINE_DISABLE_AUDIT_FAILED(6,6, 2, 7, "已上线卡片禁用审核不通过"),
    OFFLINE_DISABLE_AUDIT_SUCCESS(6,6, 1, 9, "已下线卡片禁用审核通过"),
    OFFLINE_DISABLE_AUDIT_FAILED(6,6, 2, 8, "已下线卡片禁用审核不通过");

    CardsOperationTypeEnum(int auditBeforerstatus, int auditType, int auditStatus, int auditAfterstatus, String desc) {
        this.auditBeforerstatus = auditBeforerstatus;
        this.auditType = auditType;
        this.auditStatus = auditStatus;
        this.auditAfterstatus = auditAfterstatus;
        this.desc = desc;
    }

    private int auditBeforerstatus;

    private int auditType;

    private int auditStatus;

    private int auditAfterstatus;

    private String desc;

    public static CardsOperationTypeEnum codeOf(int auditBeforerstatus, int auditType, int auditStatus) {
        for (CardsOperationTypeEnum cardsOperationTypeEnum : values()) {
            if (cardsOperationTypeEnum.getAuditBeforerstatus() == auditBeforerstatus && cardsOperationTypeEnum.getAuditType() == auditType && cardsOperationTypeEnum.getAuditStatus() == auditStatus) {
                return cardsOperationTypeEnum;
            }
        }
       return null;
    }

    public static CardsOperationTypeEnum codeOf(int auditBeforerstatus, int auditType, int auditStatus, int auditAfterstatus) {
        for (CardsOperationTypeEnum cardsOperationTypeEnum : values()) {
            if (cardsOperationTypeEnum.getAuditBeforerstatus() == auditBeforerstatus && cardsOperationTypeEnum.getAuditType() == auditType
                    && cardsOperationTypeEnum.getAuditStatus() == auditStatus && auditAfterstatus==cardsOperationTypeEnum.getAuditAfterstatus()) {
                return cardsOperationTypeEnum;
            }
        }
       return null;
    }

    public int getAuditBeforerstatus() {
        return auditBeforerstatus;
    }

    public int getAuditType() {
        return auditType;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public int getAuditAfterstatus() {
        return auditAfterstatus;
    }

    public String getDesc() {
        return desc;
    }}
