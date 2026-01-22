package com.ecommerce.common.exception;

public class TechnicalException extends BaseException{

    public TechnicalException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public TechnicalException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message);
        initCause(cause);
    }
}
