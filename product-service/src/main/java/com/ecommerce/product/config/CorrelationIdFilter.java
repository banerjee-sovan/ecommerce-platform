package com.ecommerce.product.config;

import com.ecommerce.common.logging.CorrelationIdUtil;
import com.ecommerce.common.tracing.RequestContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CorrelationIdFilter extends OncePerRequestFilter {

    private static final String MDC_TRACE_ID_KEY = "traceId";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String traceId =
                request.getHeader(CorrelationIdUtil.CORRELATION_ID_HEADER);

        if (traceId == null || traceId.isBlank()) {
            traceId = CorrelationIdUtil.generate();
        }

        RequestContext.setTraceId(traceId);
        MDC.put(MDC_TRACE_ID_KEY, traceId);
        response.setHeader(CorrelationIdUtil.CORRELATION_ID_HEADER, traceId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
            RequestContext.clear();
        }
    }
}
