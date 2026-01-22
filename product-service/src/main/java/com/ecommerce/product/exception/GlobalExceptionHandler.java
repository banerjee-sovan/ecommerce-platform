package com.ecommerce.product.exception;

import com.ecommerce.common.api.ApiResponse;
import com.ecommerce.common.api.ErrorResponse;
import com.ecommerce.common.exception.BaseException;
import com.ecommerce.common.tracing.RequestContext;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ApiResponse<ErrorResponse> handleBusinessException(BaseException ex) {
        return ApiResponse.failure(
                new ErrorResponse(
                        ex.getErrorCode().name(),
                        ex.getMessage(),
                        RequestContext.getTraceId()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<ErrorResponse> handleGenericException(Exception ex) {
        return ApiResponse.failure(
                new ErrorResponse(
                        "INTERNAL_ERROR",
                        "Unexpected error occurred",
                        RequestContext.getTraceId()
                )
        );
    }
}
