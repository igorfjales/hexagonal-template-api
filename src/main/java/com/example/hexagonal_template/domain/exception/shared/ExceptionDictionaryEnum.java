package com.example.hexagonal_template.domain.exception.shared;

public enum ExceptionDictionaryEnum {
    // application
    INVOICE_NOT_FOUND("INVOICE_NOT_FOUND", "Invoice not found", HttpErrorStatusCodeEnum.NOT_FOUND),

    // domain
    INVOICE_INVALID_AMOUNT("INVOICE_INVALID_AMOUNT", "Invoice amount is invalid", HttpErrorStatusCodeEnum.UNPROCESSABLE_ENTITY),
    CUSTOMER_NAME_INVALID("CUSTOMER_NAME_INVALID", "Customer name is invalid", HttpErrorStatusCodeEnum.BAD_REQUEST);

    private final String code;
    private final String defaultMessage;
    private final HttpErrorStatusCodeEnum defaultHttpErrorStatusCode;

    ExceptionDictionaryEnum(String code, String defaultMessage, HttpErrorStatusCodeEnum defaultHttpErrorStatusCode) {
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.defaultHttpErrorStatusCode = defaultHttpErrorStatusCode;
    }

    public String getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public HttpErrorStatusCodeEnum getDefaultHttpErrorStatusCode() {
        return defaultHttpErrorStatusCode;
    }
}
