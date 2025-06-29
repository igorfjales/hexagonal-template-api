package com.example.hexagonal_template.adapter.in.api.rest.handler;

import com.example.hexagonal_template.adapter.in.api.rest.dto.ApiErrorResponse;
import com.example.hexagonal_template.adapter.in.api.rest.dto.ValidationErrorResponse;
import com.example.hexagonal_template.adapter.in.api.rest.util.StackTraceUtils;
import com.example.hexagonal_template.adapter.in.api.rest.util.StructuredLogger;
import com.example.hexagonal_template.adapter.in.api.rest.util.TraceUtils;
import com.example.hexagonal_template.application.exception.BusinessException;
import com.example.hexagonal_template.domain.exception.DomainException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusiness(BusinessException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.valueOf(ex.getHttpStatusCode().value());
        return buildErrorResponse(ex.getExceptionDictionaryRegistry().getCode(), ex.getMessage(), status, request, ex);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ApiErrorResponse> handleDomain(DomainException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.valueOf(ex.getHttpStatusCode().value());
        return buildErrorResponse(ex.getExceptionDictionaryRegistry().getCode(), ex.getMessage(), status, request, ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnexpected(Exception ex, HttpServletRequest request) {
        return buildErrorResponse("INTERNAL_ERROR", "Erro interno inesperado.", HttpStatus.INTERNAL_SERVER_ERROR, request, ex);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            @NonNull MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest webRequest
    ) {
        HttpServletRequest request = (HttpServletRequest) webRequest.resolveReference(WebRequest.REFERENCE_REQUEST);
        String traceId = TraceUtils.getTraceId(request);

        List<ValidationErrorResponse.ValidationError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ValidationErrorResponse.ValidationError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        ValidationErrorResponse response = new ValidationErrorResponse(
                "VALIDATION_ERROR",
                errors,
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                request != null ? request.getRequestURI() : "UNKNOWN",
                OffsetDateTime.now(),
                traceId
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private ResponseEntity<ApiErrorResponse> buildErrorResponse(
            String code,
            String message,
            HttpStatus status,
            HttpServletRequest request,
            Exception ex
    ) {
        String traceId = TraceUtils.getTraceId(request);
        String teste = StackTraceUtils.getOriginClass(ex);
        String teste1 = StackTraceUtils.getOriginMethod(ex);

        System.out.println(teste);
        System.out.println(teste1);

        StructuredLogger.logBusinessWarn(log, code, message, traceId, ex);

        ApiErrorResponse error = new ApiErrorResponse(
                code,
                message,
                status.value(),
                status.getReasonPhrase(),
                request.getRequestURI(),
                request.getMethod(),
                OffsetDateTime.now(),
                traceId
        );

        return ResponseEntity.status(status).body(error);
    }

    private void logError(Exception ex, String traceId){
        String originClass = StackTraceUtils.getOriginClass(ex);
        String originMethod = StackTraceUtils.getOriginMethod(ex);

        System.out.println(originClass);
        System.out.println(originMethod);
    }
}
