package com.example.hexagonal_template.application.invoice;

import com.example.hexagonal_template.port.in.invoice.PrintInvoiceUseCase;

public class PrintInvoiceService implements PrintInvoiceUseCase {

    @Override
    public String execute(String id) {
        return "executei o service com o id " + id;
    }
}
