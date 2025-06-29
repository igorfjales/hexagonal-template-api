package com.example.hexagonal_template.adapter.out.persistence.repository.invoice;

import com.example.hexagonal_template.adapter.out.persistence.entity.invoice.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, String> {}