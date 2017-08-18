package com.zhaopin.core.utils;

import java.util.UUID;

public class RequestID {
    private static ThreadLocal<String> requestID = new ThreadLocal();
    private static ThreadLocal<Long> requestTime = new ThreadLocal();

    public RequestID() {
    }

    public static void setRequestID() {
        requestID.set(UUID.randomUUID().toString());
        requestTime.set(Long.valueOf(System.currentTimeMillis()));
    }

    public static void setRequestID(String taskId) {
        requestID.set(taskId);
        requestTime.set(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getRequestID() {
        return (String)requestID.get();
    }

    public static Long getRequestTime() {
        return (Long)requestTime.get();
    }
}
