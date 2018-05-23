package com.saileijieji.mylibrary;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @describe: mymvp
 * @author: 武梁
 * @date: 2018/5/23 16:10
 * @mailbox: 1034905058@qq.com
 */

public class LogUtil {
    private static final int MIN_STACK_OFFSET = 3;// starts at this class after two native calls
    private static final int MAX_STACK_TRACE_SIZE = 131071; //128 KB - 1
    private static final int METHOD_COUNT = 2; // show method count in trace
    private static final boolean DEBUG = true;


    public static void d(String msg) {
        if (DEBUG) {
            Log.d(_FILE_(), "[" + getLineMethod() + "]" + msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG) {
            Log.e(_FILE_(), "[" + getLineMethod() + "]" + msg);
        }
    }
    public static void i(String msg) {
        if (DEBUG) {
            Log.i(_FILE_(), "[" + getLineMethod() + "]" + msg);
        }
    }


    public static String getFileLineMethod() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        StringBuffer toStringBuffer = new StringBuffer("[")
                .append(traceElement.getFileName()).append(" | ")
                .append(traceElement.getLineNumber()).append(" | ")
                .append(traceElement.getMethodName()).append("]");
        return toStringBuffer.toString();
    }

    public static String getLineMethod() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        StringBuffer toStringBuffer = new StringBuffer("[")
                .append(traceElement.getLineNumber()).append(" | ")
                .append(traceElement.getMethodName()).append("]");
        return toStringBuffer.toString();
    }

    private static String _FILE_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        return traceElement.getFileName();
    }

    private static String _FUNC_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getMethodName();
    }

    private static int _LINE_() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getLineNumber();
    }

    private static String _TIME_() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(now);
    }
    public static void e(Throwable e) {
        e(toStackTraceString(e));
    }

    /**
     * To stack trace string string.
     * <p/>
     * 此方法参见：https://github.com/Ereza/CustomActivityOnCrash
     *
     * @param throwable the throwable
     * @return the string
     */
    public static String toStackTraceString(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        String stackTraceString = sw.toString();
        //Reduce data to 128KB so we don't get a TransactionTooLargeException when sending the intent.
        //The limit is 1MB on Android but some devices seem to have it lower.
        //See: http://developer.android.com/reference/android/os/TransactionTooLargeException.html
        //And: http://stackoverflow.com/questions/11451393/what-to-do-on-transactiontoolargeexception#comment46697371_12809171
        if (stackTraceString.length() > MAX_STACK_TRACE_SIZE) {
            String disclaimer = " [stack trace too large]";
            stackTraceString = stackTraceString.substring(0, MAX_STACK_TRACE_SIZE - disclaimer.length()) + disclaimer;
        }
        return stackTraceString;
    }

}
