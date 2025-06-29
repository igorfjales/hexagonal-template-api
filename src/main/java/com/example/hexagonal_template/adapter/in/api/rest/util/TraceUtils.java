package com.example.hexagonal_template.adapter.in.api.rest.util;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;

public class TraceUtils {
    private static final String TRACE_ID_HEADER = "X-Trace-Id";

    public static String getTraceId(@Nullable HttpServletRequest request) {
        if (request == null) return "UNKNOWN";
        Object traceId = request.getAttribute(TRACE_ID_HEADER);
        return traceId != null ? traceId.toString() : "UNKNOWN";
    }
}
