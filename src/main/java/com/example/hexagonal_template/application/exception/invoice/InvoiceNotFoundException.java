package com.example.hexagonal_template.application.exception.invoice;

import com.example.hexagonal_template.application.exception.BusinessException;
import com.example.hexagonal_template.domain.exception.shared.ExceptionDictionaryEnum;
import com.example.hexagonal_template.domain.exception.shared.HttpErrorStatusCodeEnum;

public class InvoiceNotFoundException extends BusinessException {
    public InvoiceNotFoundException() {
        super(ExceptionDictionaryEnum.INVOICE_NOT_FOUND);
    }

    public InvoiceNotFoundException(String customMessage) {
        super(ExceptionDictionaryEnum.INVOICE_NOT_FOUND, customMessage);
    }

    public InvoiceNotFoundException(HttpErrorStatusCodeEnum customHttpErrorStatusCode) {
        super(ExceptionDictionaryEnum.INVOICE_NOT_FOUND, customHttpErrorStatusCode);
    }

    public InvoiceNotFoundException(String customMessage, HttpErrorStatusCodeEnum customHttpStatusCode) {
        super(ExceptionDictionaryEnum.INVOICE_NOT_FOUND, customMessage, customHttpStatusCode);
    }
}
