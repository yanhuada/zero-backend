package com.yanhuada.common.util.aliyun.sts;

/**
 * @author yanhuada
 * CREATE ON 2020/3/19 16:49
 */
public class StsException extends RuntimeException{
    public StsException() {
    }

    public StsException(String message) {
        super(message);
    }

    public StsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StsException(Throwable cause) {
        super(cause);
    }

    public StsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
