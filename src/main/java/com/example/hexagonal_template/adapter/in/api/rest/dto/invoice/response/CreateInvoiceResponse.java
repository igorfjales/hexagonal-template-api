package com.example.hexagonal_template.adapter.in.api.rest.dto.invoice.response;

import java.math.BigDecimal;

public record CreateInvoiceResponse(
        String id,
        String customerName,
        BigDecimal amount
) {
}
