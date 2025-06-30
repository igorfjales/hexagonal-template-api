package com.example.hexagonal_template.port.out.logging;

public interface LogPort {
    void info(String message);
    void warn(String message);
    void warn(String message, String code, String traceId, Throwable throwable);
    void error(String message, Throwable throwable);
    void error(String message, String code, String traceId, Throwable throwable);
}
