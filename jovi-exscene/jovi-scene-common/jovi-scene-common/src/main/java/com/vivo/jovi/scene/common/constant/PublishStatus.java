package com.vivo.jovi.scene.common.constant;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-03-04 18:49
 */
public enum PublishStatus {
    /**
     *
     */
    PUBLISH_TO_RELEASED(0, "待发布"),
    PUBLISH_TO_AUDIT(1, "发布审核"),
    PUBLISH_TO_START(2, "待启动"),
    PUBLISH_REJECT(3, "驳回"),
    PUBLISH_GRAY_LEVEL(4, "灰度"),
    PUBLISH_FULL(5, "全量发布"),
    PUBLISH_PAUSE(6, "暂停中"),
    PUBLISH_FAILURE(7, "已失效");

    PublishStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDesc(int code) {
        for (PublishStatus publishStatus : values()) {
            if (publishStatus.getCode() == code) {
                return publishStatus.getDesc();
            }
        }
        return null;
    }

    public static boolean checkInGrey(Integer status) {
        return PUBLISH_GRAY_LEVEL.getCode().equals(status)
                || PUBLISH_PAUSE.getCode().equals(status)
                || PUBLISH_FAILURE.getCode().equals(status);
    }

    private int code;

    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static boolean inPublish(Integer status) {
        return PUBLISH_GRAY_LEVEL.getCode().equals(status)
                || PUBLISH_FULL.getCode().equals(status);
    }
}

    //0 待发布；1 发布审核；2 待启动；3 驳回；4灰度; 5全量发布；6暂停中；7已失效
//    public static final Integer PUBLISH_TO_RELEASED = 0;
//    public static final Integer PUBLISH_TO_AUDIT = 1;
//    public static final Integer PUBLISH_TO_START = 2;
//    public static final Integer PUBLISH_REJECT = 3;
//    public static final Integer PUBLISH_GRAY_LEVEL = 4;
//    public static final Integer PUBLISH_FULL = 5;
//    public static final Integer PUBLISH_PAUSE = 6;
//    public static final Integer PUBLISH_FAILURE = 7;
//}

