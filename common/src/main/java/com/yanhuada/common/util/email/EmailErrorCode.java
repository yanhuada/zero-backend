package com.yanhuada.common.util.email;

/**
 * @author yanhuada
 * CREATE ON 2020/3/17 17:27
 */
public enum EmailErrorCode {

    /**
     *
     */
    SEND_EMAIL_ERROR(600,"操作成功，但邮件下发失败");

    private int code;
    private String message;

    EmailErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
