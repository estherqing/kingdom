package com.vivo.jovi.scene.common.constant;

/**
 * @Classname QuestionnaireStatusEnum
 * @Description TODO
 * @Date 2019-05-09 16:13
 * @Created by Administrator
 * @Version 1.0
 */
public enum  QuestionnaireStatusEnum {

    DRAFT(0, "草稿"),
    TEXT_TO_BE_EXPORTED(1, "文本待导出"),
    TRANSLATION_TO_BE_EXPORTED(2,  "翻译待导入"),
    TRANSLATION_TO_BE_IMPORTED(3,  "翻译已导入"),
    /*WAITING_ONLINE(4, "待上线"),*/
    BACK(5,  "驳回"),
    ONLINE_AUDIT(6, "上线审核"),
    OFFLINE_AUDIT(7, "下线审核"),
    DISABLEAUDIT(8, "禁用审核"),
    ONLINE(9, "已上线"),
    OFFLINE(10, "已下线"),
    DISABLED(11, "已禁用");

    QuestionnaireStatusEnum(int status , String desc) {
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

    public static QuestionnaireStatusEnum statusOf(int status) {
        for (QuestionnaireStatusEnum questionnaireStatusEnum : values()) {
            if (questionnaireStatusEnum.getStatus() == status) {
                return questionnaireStatusEnum;
            }
        }
        return null;
    }
}
