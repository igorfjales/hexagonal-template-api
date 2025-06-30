package com.example.hexagonal_template.adapter.out.logging;


import com.example.hexagonal_template.port.out.logging.LogPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;


@Component
public class LogAdapter implements LogPort {

    private static final Logger log = LoggerFactory.getLogger(LogAdapter.class);

    private final String MDC_CODE = "code";
    private final String MDC_EXCEPTION = "exception";
    private final String MDC_ORIGINAL_CLASS = "originClass";
    private final String MDC_ORIGINAL_METHOD = "originMethod";
    private final String MDC_ORIGINAL_LINE = "originLine";

    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void warn(String message) {
        log.warn(message);
    }

    @Override
    public void warn(String message, String code, String traceId, Throwable throwable) {

    }

    @Override
    public void error(String message, Throwable throwable) {
        log.error(message, throwable);
    }

    @Override
    public void error(String message, String code, String traceId, Throwable throwable) {
        try {
            StackTraceElement origin = getOrigin(throwable);
            MDC.put(MDC_CODE, code);
            MDC.put(MDC_EXCEPTION, throwable.getClass().getName());
            MDC.put(MDC_ORIGINAL_CLASS, origin.getClassName());
            MDC.put(MDC_ORIGINAL_METHOD, origin.getMethodName());
            MDC.put(MDC_ORIGINAL_LINE, String.valueOf(origin.getLineNumber()));
            log.error(message);
        } finally {
            clearMdc();
        }
    }

    private static StackTraceElement getOrigin(Throwable throwable) {
        return (throwable != null && throwable.getStackTrace().length > 0)
                ? throwable.getStackTrace()[0]
                : new StackTraceElement("UNKNOWN", "UNKNOWN", null, -1);
    }

    private void clearMdc() {
        MDC.remove(MDC_CODE);
        MDC.remove(MDC_EXCEPTION);
        MDC.remove(MDC_ORIGINAL_CLASS);
        MDC.remove(MDC_ORIGINAL_METHOD);
        MDC.remove(MDC_ORIGINAL_LINE);
    }

}
