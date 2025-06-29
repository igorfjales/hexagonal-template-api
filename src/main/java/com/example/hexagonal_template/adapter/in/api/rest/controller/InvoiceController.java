package com.example.hexagonal_template.adapter.in.api.rest.controller;

import com.example.hexagonal_template.adapter.in.api.rest.dto.invoice.request.CreateInvoiceRequest;
import com.example.hexagonal_template.adapter.in.api.rest.dto.invoice.response.CreateInvoiceResponse;
import com.example.hexagonal_template.adapter.in.api.rest.mapper.invoice.CreateInvoiceMapper;
import com.example.hexagonal_template.port.in.invoice.CreateInvoiceUseCase;
import com.example.hexagonal_template.port.in.invoice.PrintInvoiceUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("invoice")
public class InvoiceController {
    private final CreateInvoiceUseCase createInvoiceUseCase;
    private final PrintInvoiceUseCase printInvoiceUseCase;
    private final CreateInvoiceMapper createInvoiceMapper;

    public InvoiceController(CreateInvoiceUseCase createInvoiceUseCase, PrintInvoiceUseCase printInvoiceUseCase, CreateInvoiceMapper createInvoiceMapper) {
        this.createInvoiceUseCase = createInvoiceUseCase;
        this.printInvoiceUseCase = printInvoiceUseCase;
        this.createInvoiceMapper = createInvoiceMapper;
    }

    @PostMapping
    public ResponseEntity<CreateInvoiceResponse> create(@Valid @RequestBody CreateInvoiceRequest request) {
        var model = createInvoiceMapper.requestToModel(request);
        var created = createInvoiceUseCase.execute(model);
        var response = createInvoiceMapper.modelToResponse(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}/print")
    private String print(@PathVariable String id) {
        return printInvoiceUseCase.execute(id);
    }
}
