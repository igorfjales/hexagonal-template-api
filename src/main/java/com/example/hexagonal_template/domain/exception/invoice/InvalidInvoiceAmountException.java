package com.example.hexagonal_template.domain.exception.invoice;

import com.example.hexagonal_template.domain.exception.DomainException;
import com.example.hexagonal_template.domain.exception.shared.ExceptionDictionaryEnum;
import com.example.hexagonal_template.domain.exception.shared.HttpErrorStatusCodeEnum;

public class InvalidInvoiceAmountException extends DomainException {
    public InvalidInvoiceAmountException() {
        super(ExceptionDictionaryEnum.INVOICE_INVALID_AMOUNT);
    }

    public InvalidInvoiceAmountException(String customMessage) {
        super(ExceptionDictionaryEnum.INVOICE_INVALID_AMOUNT, customMessage);
    }

    public InvalidInvoiceAmountException(HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
        super(ExceptionDictionaryEnum.INVOICE_INVALID_AMOUNT, customHttpErrorStatusCode);
    }

    public InvalidInvoiceAmountException(String customMessage, HttpErrorStatusCodeEnum customHttpStatusCode) {
        super(ExceptionDictionaryEnum.INVOICE_INVALID_AMOUNT, customMessage, customHttpStatusCode);
    }
}