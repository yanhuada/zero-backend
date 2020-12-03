package com.yanhuada.exception;

import com.yanhuada.common.exception.BaseException;
import com.yanhuada.common.exception.BaseExceptionEnum;

/**
 * @author yanhuada
 * CREATE ON 2020/3/14 18:00
 */
public class JwtException extends BaseException {
    public JwtException(String message, Integer code) {
        super(message, code);
    }

    public JwtException(String message, Throwable cause, Integer code) {
        super(message, cause, code);
    }

    public JwtException(Throwable cause, Integer code) {
        super(cause, code);
    }

    public JwtException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }

    public JwtException(BaseExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public JwtException(Integer code) {
        super(code);
    }

    public JwtException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode.getCode());
    }

    public JwtException(Throwable cause, ErrorCode errorCode) {
        super(errorCode.getMessage(), cause, errorCode.getCode());
    }
}
