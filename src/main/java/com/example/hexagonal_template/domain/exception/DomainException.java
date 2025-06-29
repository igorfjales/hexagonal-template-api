/**
 * Origem: violação de regras de negócio puras, dentro do domínio
 * Nunca deve depender de bibliotecas externas (nem javax.validation, nem Spring)
 * ex: valor inválido para criação de uma entidade de domínio
 */
package com.example.hexagonal_template.domain.exception;

import com.example.hexagonal_template.domain.exception.shared.ExceptionDictionaryEnum;
import com.example.hexagonal_template.domain.exception.shared.HttpErrorStatusCodeEnum;

public abstract class DomainException extends RuntimeException {
    private final ExceptionDictionaryEnum exceptionDictionaryRegistry;
    private final String message;
    private final HttpErrorStatusCodeEnum httpErrorStatusCode;

    protected DomainException(ExceptionDictionaryEnum errorCode) {
        this(errorCode, null, null);
    }

    protected DomainException(ExceptionDictionaryEnum errorCode, String customMessage) {
        this(errorCode, customMessage, null);
    }

    protected DomainException(ExceptionDictionaryEnum errorCode, HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
        this(errorCode, null, customHttpErrorStatusCode);
    }

    protected DomainException(ExceptionDictionaryEnum exceptionDictionaryRegistry, String customMessage, HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
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
