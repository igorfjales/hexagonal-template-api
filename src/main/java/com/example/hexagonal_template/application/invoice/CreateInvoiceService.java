package com.example.hexagonal_template.application.invoice;

import com.example.hexagonal_template.application.exception.invoice.InvoiceNotFoundException;
import com.example.hexagonal_template.domain.exception.shared.HttpErrorStatusCodeEnum;
import com.example.hexagonal_template.domain.model.invoice.InvoiceModel;
import com.example.hexagonal_template.port.in.invoice.CreateInvoiceUseCase;

public class CreateInvoiceService implements CreateInvoiceUseCase {
    @Override
    public InvoiceModel execute(InvoiceModel model) {
        System.out.println("Create invoice service");
        System.out.println(model.toString());

//        throw new InvoiceNotFoundException();
//        throw new InvoiceNotFoundException("TESTE MENSAGEM");
        throw new InvoiceNotFoundException(HttpErrorStatusCodeEnum.INTERNAL_ERROR);
//        return null;
    }
}
