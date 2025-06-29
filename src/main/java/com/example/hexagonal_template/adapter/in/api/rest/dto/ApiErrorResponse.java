package com.example.hexagonal_template.adapter.in.api.rest.dto;

import java.time.OffsetDateTime;

public record ApiErrorResponse(
        String code,
        String message,
        int status,
        String statusMessage,
        String path,
        String method,
        OffsetDateTime timestamp,
        String traceId
) {}