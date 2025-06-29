package com.example.hexagonal_template.domain.model.invoice;

import com.example.hexagonal_template.domain.exception.invoice.InvalidCustomerNameException;
import com.example.hexagonal_template.domain.exception.invoice.InvalidInvoiceAmountException;

import java.math.BigDecimal;
import java.util.UUID;

public class InvoiceModel {
    private final String id;
    private final String customerName;
    private final BigDecimal amount;

    public InvoiceModel(String customerName, BigDecimal amount) {
        if (customerName == null || customerName.isBlank()) {
            throw new InvalidCustomerNameException("Nome do cliente não pode ser nulo ou vazio");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidInvoiceAmountException("Valor da fatura deve ser maior que zero");
        }

        this.id = UUID.randomUUID().toString();
        this.customerName = customerName;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "InvoiceModel{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                '}';
    }
}