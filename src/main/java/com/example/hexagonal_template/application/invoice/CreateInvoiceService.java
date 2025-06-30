package com.example.hexagonal_template.application.invoice;

import com.example.hexagonal_template.application.exception.invoice.InvoiceNotFoundException;
import com.example.hexagonal_template.domain.model.invoice.InvoiceModel;
import com.example.hexagonal_template.port.in.invoice.CreateInvoiceUseCase;
import com.example.hexagonal_template.port.out.logging.LogPort;

public class CreateInvoiceService implements CreateInvoiceUseCase {

    private final LogPort logPort;

    public CreateInvoiceService(LogPort logPort) {
        this.logPort = logPort;
    }


    @Override
    public InvoiceModel execute(InvoiceModel model) {
        System.out.println("Create invoice service");
        System.out.println(model.toString());

        logPort.info("Starting invoice creation for customer: " + model.getCustomerName());

        throw new InvoiceNotFoundException();
//        throw new InvoiceNotFoundException("TESTE MENSAGEM");
//        throw new InvoiceNotFoundException(HttpErrorStatusCodeEnum.INTERNAL_ERROR);
//        return null;
    }
}
