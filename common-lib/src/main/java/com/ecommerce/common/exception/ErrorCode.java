package com.ecommerce.common.exception;

public enum ErrorCode {
    // Generic
    INTERNAL_ERROR,
    INVALID_REQUEST,

    // Auth
    UNAUTHORIZED,
    FORBIDDEN,

    // Business
    PRODUCT_NOT_FOUND,
    INSUFFICIENT_INVENTORY
}
