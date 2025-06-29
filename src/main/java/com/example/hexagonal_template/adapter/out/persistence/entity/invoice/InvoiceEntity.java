package com.example.hexagonal_template.adapter.out.persistence.entity.invoice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class InvoiceEntity {
    @Id
    private String id;
    private String customerName;
    private BigDecimal amount;
}
