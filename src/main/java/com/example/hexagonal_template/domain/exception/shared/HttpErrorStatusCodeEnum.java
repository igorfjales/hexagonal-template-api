package com.example.hexagonal_template.domain.exception.shared;

/**
 * Enum representando os tipos de erros de domínio,
 * mapeáveis para códigos HTTP sem depender de frameworks externos.
 */
public enum HttpErrorStatusCodeEnum {
    NOT_FOUND(404),
    UNPROCESSABLE_ENTITY(422),
    CONFLICT(409),
    BAD_REQUEST(400),
    FORBIDDEN(403),
    INTERNAL_ERROR(500);

    private final int httpCode;

    HttpErrorStatusCodeEnum(int httpCode) {
        this.httpCode = httpCode;
    }

    public int value() {
        return httpCode;
    }
}
