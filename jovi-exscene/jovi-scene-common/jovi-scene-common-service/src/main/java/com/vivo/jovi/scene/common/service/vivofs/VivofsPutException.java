package com.vivo.jovi.scene.common.service.vivofs;

/**
 * @author Tian Guangxin
 * @date 2018/9/17
 * @since 1.0
 */
public class VivofsPutException extends RuntimeException {

    public VivofsPutException(int code, String msg, String requestId) {
        this(new StringBuilder("Vivofs put operation error,code:").append(code)
                .append("msg:").append(msg)
                .append("requestId:").append(requestId).toString());
    }

    public VivofsPutException(String message) {
        super(message);
    }

    public VivofsPutException(String message, Throwable cause) {
        super(message, cause);
    }

    public VivofsPutException(Throwable cause) {
        super(cause);
    }

    public VivofsPutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
