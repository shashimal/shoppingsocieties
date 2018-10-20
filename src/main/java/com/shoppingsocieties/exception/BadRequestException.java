package com.shoppingsocieties.exception;

import com.shoppingsocieties.error.ErrorCode;

public class BadRequestException extends Exception {

    private ErrorCode errorCode;

    public BadRequestException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BadRequestException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BadRequestException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}