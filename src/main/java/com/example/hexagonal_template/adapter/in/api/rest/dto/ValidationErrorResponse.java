package com.example.hexagonal_template.adapter.in.api.rest.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record ValidationErrorResponse(
        String code,
        List<ValidationError> errors,
        int status,
        String statusMessage,
        String path,
        OffsetDateTime timestamp,
        String traceId
) {
    public record ValidationError(
            String field,
            String message
    ) {
    }
}
