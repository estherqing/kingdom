package com.vivo.jovi.scene.common.constant;

public enum SmsPlatformEnum {

    SUCCESS(0, "审核通过"),
    FAIL(-1, "审核未通过"),
    SERVER_ERROR(10000, "teddy服务器响应错误"),
    param_error(20000, "参数错误"),
    FILE_LIST_IS_EMPTY(21000, "文件列表为空"),
    INTERFACE_ACCESS_FAILURE(22000, "接口访问失败"),
    URL_DOWNLOAD_FILE_FAILED(23000, "url下载文件失败"),
    DIFFERENT_VALUE(24000, "url与md5值不一致"),
    PUSH_MAIL_FILE_DIFFERENCE(25000, "推送文件与线下邮件文件不一致"),
    push_pull_file_difference(26000, "推送文件与拉取文件不一致"),
    PUSH_PULL_FILE_VERSION_NUMBER_DIFFERENCE(27000, "文件拉取文件与推送文件版本号不一致"),
    ;

    private Integer code;

    private String message;

    SmsPlatformEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
