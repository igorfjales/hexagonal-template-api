package com.example.hexagonal_template.adapter.in.api.rest.util;

public class StackTraceUtils {
    public static String getOriginClass(Throwable throwable) {
        if (throwable == null || throwable.getStackTrace().length == 0) return "UNKNOWN";
        return throwable.getStackTrace()[0].getClassName();
    }

    public static String getOriginMethod(Throwable throwable) {
        if (throwable == null || throwable.getStackTrace().length == 0) return "UNKNOWN";
        return throwable.getStackTrace()[0].getMethodName();
    }
}
