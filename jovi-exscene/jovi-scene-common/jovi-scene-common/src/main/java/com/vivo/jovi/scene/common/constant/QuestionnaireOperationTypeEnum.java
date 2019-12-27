package com.vivo.jovi.scene.common.constant;

/**
 * @Description
 * @Author xj
 * @Date 2019-03-15 15:05
 */
public enum QuestionnaireOperationTypeEnum {

    ONLINE_AUDIT_SUCCESS(6,6, 1, 9, "待上线卡片上线审核通过"),
    ONLINE_AUDIT_FAILED(6,6, 2, 5, "待上线卡片上线审核不通过"),
    OFFLINE_AUDIT_SUCCESS(7,7, 1, 10, "已上线卡片下线审核通过"),
    OFFLINE_AUDIT_FAILED(7,7, 2, 9, "已上线卡片下线审核不通过"),
    ON_LINE_DISABLE_AUDIT_SUCCESS(8,8, 1, 11, "已上线卡片禁用审核通过"),
    ON_LINE_DISABLE_AUDIT_FAILED(8,8, 2, 9, "已上线卡片禁用审核不通过"),
    OFFLINE_DISABLE_AUDIT_SUCCESS(8,8, 1, 11, "已下线卡片禁用审核通过"),
    OFFLINE_DISABLE_AUDIT_FAILED(8,8, 2, 10, "已下线卡片禁用审核不通过");

    QuestionnaireOperationTypeEnum(int auditBeforerstatus, int auditType, int auditStatus, int auditAfterstatus, String desc) {
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

    public static QuestionnaireOperationTypeEnum codeOf(int auditBeforerstatus, int auditType, int auditStatus) {
        for (QuestionnaireOperationTypeEnum cardsOperationTypeEnum : values()) {
            if (cardsOperationTypeEnum.getAuditBeforerstatus() == auditBeforerstatus && cardsOperationTypeEnum.getAuditType() == auditType && cardsOperationTypeEnum.getAuditStatus() == auditStatus) {
                return cardsOperationTypeEnum;
            }
        }
       return null;
    }

    public static QuestionnaireOperationTypeEnum codeOf(int auditBeforerstatus, int auditType, int auditStatus, int auditAfterstatus) {
        for (QuestionnaireOperationTypeEnum cardsOperationTypeEnum : values()) {
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
