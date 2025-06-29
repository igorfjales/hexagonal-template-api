package com.example.hexagonal_template.adapter.in.api.rest.mapper.invoice;

import com.example.hexagonal_template.adapter.in.api.rest.dto.invoice.request.CreateInvoiceRequest;

import com.example.hexagonal_template.adapter.in.api.rest.dto.invoice.response.CreateInvoiceResponse;
import com.example.hexagonal_template.domain.model.invoice.InvoiceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateInvoiceMapper {
    InvoiceModel requestToModel(CreateInvoiceRequest request);

    CreateInvoiceResponse modelToResponse(InvoiceModel invoice);
}
