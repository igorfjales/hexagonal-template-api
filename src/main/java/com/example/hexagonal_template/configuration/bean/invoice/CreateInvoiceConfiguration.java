package com.example.hexagonal_template.configuration.bean.invoice;

import com.example.hexagonal_template.port.in.invoice.CreateInvoiceUseCase;
import com.example.hexagonal_template.application.invoice.CreateInvoiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateInvoiceConfiguration {

    @Bean
    public CreateInvoiceUseCase createInvoiceUseCase() {
        return new CreateInvoiceService();
    }
}