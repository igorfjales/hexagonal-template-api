package com.example.hexagonal_template.port.in.invoice;

import com.example.hexagonal_template.domain.model.invoice.InvoiceModel;

public interface CreateInvoiceUseCase {
    InvoiceModel execute(InvoiceModel model);
}
