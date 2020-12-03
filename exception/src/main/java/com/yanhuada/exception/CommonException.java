package com.yanhuada.exception;

import com.yanhuada.common.exception.BaseException;
import com.yanhuada.common.exception.BaseExceptionEnum;

/**
 * @author yanhuada
 * CREATE ON 2020/3/18 1:41
 */
public class CommonException extends BaseException {

    public CommonException(String message, Integer code) {
        super(message, code);
    }

    public CommonException(String message, Throwable cause, Integer code) {
        super(message, cause, code);
    }

    public CommonException(Throwable cause, Integer code) {
        super(cause, code);
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }

    public CommonException(BaseExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public CommonException(Integer code) {
        super(code);
    }

    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode.getCode());
    }

    public CommonException(Throwable cause, ErrorCode errorCode) {
        super(errorCode.getMessage(), cause, errorCode.getCode());
    }
}
