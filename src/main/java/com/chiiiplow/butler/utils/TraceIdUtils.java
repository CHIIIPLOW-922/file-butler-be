package com.chiiiplow.butler.utils;

import org.slf4j.MDC;

import java.util.UUID;

/**
 * 跟踪 ID 实用程序
 *
 * @author yangzhixiong
 * @date 2025/10/14
 */
public class TraceIdUtils {

    private static final String TRACE_ID_KEY = "traceId";

    public static void set() {
        MDC.put(TRACE_ID_KEY, generate());
    }

    public static String get() {
        return MDC.get(TRACE_ID_KEY);
    }

    public static void remove() {
        MDC.remove(TRACE_ID_KEY);
    }

    public static String generate() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

}
