package com.yanhuada.common.model;

import lombok.Data;

/**
 * @author yanhuada
 * CREATE ON 2020/8/9 18:57
 */
public enum CaptchaType {
    /**
     * 验证码类型
     */

    // 手机登陆验证码
    PHONE_LOGIN(0);

    private int code;

    CaptchaType(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
