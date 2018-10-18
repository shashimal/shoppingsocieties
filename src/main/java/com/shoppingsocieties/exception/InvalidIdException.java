package com.shoppingsocieties.exception;

import com.shoppingsocieties.error.ErrorCode;

public class InvalidIdException extends Exception {

    private ErrorCode errorCode;

    public InvalidIdException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidIdException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidIdException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}