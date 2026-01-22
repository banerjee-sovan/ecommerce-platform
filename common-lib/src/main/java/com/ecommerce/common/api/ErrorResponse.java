package com.ecommerce.common.api;

public class ErrorResponse {

    private final String code;
    private final String message;
    private final String traceId;

    public ErrorResponse(String code, String message, String traceId) {
        this.code = code;
        this.message = message;
        this.traceId = traceId;
    }

    public String getCode() { return code; }
    public String getMessage() { return message; }
    public String getTraceId() { return traceId; }
}
