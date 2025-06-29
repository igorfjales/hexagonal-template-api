package com.example.hexagonal_template.adapter.out.persistence.mapper.invoice;

import com.example.hexagonal_template.adapter.out.persistence.entity.invoice.InvoiceEntity;
import com.example.hexagonal_template.domain.model.invoice.InvoiceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoicePersistenceMapper {
    InvoiceModel entityToModel(InvoiceEntity entity);

    InvoiceEntity modelToEntity(InvoiceModel model);
}
