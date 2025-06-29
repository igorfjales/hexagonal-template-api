package com.example.hexagonal_template.application.exception;

import com.example.hexagonal_template.domain.exception.shared.ExceptionDictionaryEnum;
import com.example.hexagonal_template.domain.exception.shared.HttpErrorStatusCodeEnum;

public abstract class BusinessException extends RuntimeException {
    private final ExceptionDictionaryEnum exceptionDictionaryRegistry;
    private final String message;
    private final HttpErrorStatusCodeEnum httpErrorStatusCode;

    protected BusinessException(ExceptionDictionaryEnum errorCode) {
        this(errorCode, null, null);
    }

    protected BusinessException(ExceptionDictionaryEnum errorCode, String customMessage) {
        this(errorCode, customMessage, null);
    }

    protected BusinessException(ExceptionDictionaryEnum errorCode, HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
        this(errorCode, null, customHttpErrorStatusCode);
    }

    protected BusinessException(ExceptionDictionaryEnum exceptionDictionaryRegistry, String customMessage, HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
        super(customMessage != null ? customMessage : exceptionDictionaryRegistry.getDefaultMessage());

        this.exceptionDictionaryRegistry = exceptionDictionaryRegistry;
        this.message = customMessage;
        this.httpErrorStatusCode = customHttpErrorStatusCode;
    }

    public ExceptionDictionaryEnum getExceptionDictionaryRegistry() {
        return exceptionDictionaryRegistry;
    }

    @Override
    public String getMessage() {
        return message != null ? message : exceptionDictionaryRegistry.getDefaultMessage();
    }

    public HttpErrorStatusCodeEnum getHttpStatusCode() {
        return httpErrorStatusCode != null ? httpErrorStatusCode : exceptionDictionaryRegistry.getDefaultHttpErrorStatusCode();
    }
}