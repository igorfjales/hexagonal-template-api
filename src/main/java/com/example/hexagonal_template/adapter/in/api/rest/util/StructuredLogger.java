package com.example.hexagonal_template.adapter.in.api.rest.util;

import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;

public class StructuredLogger {

    public static void logBusinessWarn(Logger logger, String code, String message, String traceId, Throwable ex) {
        StackTraceElement origin = getOrigin(ex);
        logger.warn(message,
                StructuredArguments.keyValue("code", code),
                StructuredArguments.keyValue("exceptionClass", ex.getClass().toString()),
                StructuredArguments.keyValue("originClass", origin.getClassName()),
                StructuredArguments.keyValue("originMethod", origin.getMethodName()),
                StructuredArguments.keyValue("originLine", origin.getLineNumber()));
    }

    public static void logUnexpectedError(Logger logger, String traceId, Throwable ex) {
        StackTraceElement origin = getOrigin(ex);
        logger.error("Unexpected error occurred",
                StructuredArguments.keyValue("exception", ex.getClass()),
                StructuredArguments.keyValue("message", ex.getMessage()),
                StructuredArguments.keyValue("originClass", origin.getClassName()),
                StructuredArguments.keyValue("originMethod", origin.getMethodName()),
                StructuredArguments.keyValue("originLine", origin.getLineNumber()),
                ex);
    }

    private static StackTraceElement getOrigin(Throwable throwable) {
        return (throwable != null && throwable.getStackTrace().length > 0)
                ? throwable.getStackTrace()[0]
                : new StackTraceElement("UNKNOWN", "UNKNOWN", null, -1);
    }
}