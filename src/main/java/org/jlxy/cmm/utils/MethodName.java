package org.jlxy.cmm.utils;

/**
 * Created by ORCHID on 2017/3/30.
 */
public class MethodName {

    public String getMethodName() {
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stacktrace[2];
        String methodName = e.getMethodName();
        return methodName;
    }
}
