package com.example.hexagonal_template.adapter.in.api.rest.dto.invoice.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateInvoiceRequest(
        @NotBlank(message = "O nome do cliente é obrigatório")
        String customerName,

        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser positivo")
        BigDecimal amount
) {
}
