package com.shoppingsocieties.exception;

import com.shoppingsocieties.error.ErrorCode;

public class NoSalesException extends Exception {

    private ErrorCode errorCode;

    public NoSalesException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public NoSalesException(String message) {
        super(message);
    }

    public NoSalesException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public NoSalesException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public NoSalesException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}