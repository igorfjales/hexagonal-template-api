package com.example.hexagonal_template.domain.exception.invoice;

import com.example.hexagonal_template.domain.exception.DomainException;
import com.example.hexagonal_template.domain.exception.shared.ExceptionDictionaryEnum;
import com.example.hexagonal_template.domain.exception.shared.HttpErrorStatusCodeEnum;

public class InvalidCustomerNameException extends DomainException {
    public InvalidCustomerNameException() {
        super(ExceptionDictionaryEnum.CUSTOMER_NAME_INVALID);
    }

    public InvalidCustomerNameException(String customMessage) {
        super(ExceptionDictionaryEnum.CUSTOMER_NAME_INVALID, customMessage);
    }

    public InvalidCustomerNameException(HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
        super(ExceptionDictionaryEnum.CUSTOMER_NAME_INVALID, customHttpErrorStatusCode);
    }

    public InvalidCustomerNameException(String customMessage, HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
        super(ExceptionDictionaryEnum.CUSTOMER_NAME_INVALID, customMessage, customHttpErrorStatusCode);
    }
}
