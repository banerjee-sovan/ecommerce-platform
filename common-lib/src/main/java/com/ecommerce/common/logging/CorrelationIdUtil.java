package com.ecommerce.common.logging;

import java.util.UUID;

public class CorrelationIdUtil {

    public static final String CORRELATION_ID_HEADER = "X-Request-Id";

    private CorrelationIdUtil() {}

    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
