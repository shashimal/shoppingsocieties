package com.shoppingsocieties.exception;

import com.shoppingsocieties.error.ErrorCode;

public class ProductPurchaseException extends Exception {

    private ErrorCode errorCode;

    public ProductPurchaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public ProductPurchaseException(String message) {
        super(message);
    }

    public ProductPurchaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ProductPurchaseException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ProductPurchaseException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}