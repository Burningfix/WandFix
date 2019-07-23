package com.miqt.wand.utils;

import android.util.Log;

public class L {
    private static final String TAG = "sanbo";

    public static void i(String log) {
        Log.i(TAG, log);
    }

    public static void d(String log) {
        Log.d(TAG, log);
    }

    public static void v(String log) {
        Log.v(TAG, log);
    }

    public static void e(String log) {
        Log.e(TAG, log);
    }

    public static void w(String log) {
        Log.w(TAG, log);
    }

    public static void wtf(String log) {
        Log.wtf(TAG, log);
    }

    public static void v(Throwable e) {
        v(Log.getStackTraceString(e));
    }

    public static void d(Throwable e) {
        d(Log.getStackTraceString(e));
    }

    public static void i(Throwable e) {
        i(Log.getStackTraceString(e));
    }

    public static void w(Throwable e) {
        w(Log.getStackTraceString(e));
    }

    public static void e(Throwable e) {
        e(Log.getStackTraceString(e));
    }

    public static void wtf(Throwable e) {
        wtf(Log.getStackTraceString(e));
    }
}
