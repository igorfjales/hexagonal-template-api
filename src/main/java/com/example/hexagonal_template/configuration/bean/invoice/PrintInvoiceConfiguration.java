package com.example.hexagonal_template.configuration.bean.invoice;

import com.example.hexagonal_template.port.in.invoice.PrintInvoiceUseCase;
import com.example.hexagonal_template.application.invoice.PrintInvoiceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintInvoiceConfiguration {

    @Bean
    public PrintInvoiceUseCase printInvoiceUseCase() {
        return new PrintInvoiceService();
    }
}
