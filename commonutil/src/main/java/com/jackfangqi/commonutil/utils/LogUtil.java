package com.jackfangqi.commonutil.utils;

import android.util.Log;
import com.jackfangqi.commonutil.BuildConfig;

/**
 * Compiler: Android Studio
 * Project: CommonUtils
 * Author: Jack Fang
 * Email: jackfangqi1314@gmail.com
 * Date: 2016/8/18 17:13
 */
public final class LogUtil {
    private static final String LOG_TAG = LogUtil.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    public LogUtil() {
        throw new AssertionError();
    }

    public static void d(String log) {
        d(LOG_TAG, log);
    }

    public static void d(String tag, String log) {
        if (DEBUG)
            Log.d(tag, log);
    }

    public static void d(String log, Throwable tr) {
        d(LOG_TAG, log, tr);
    }

    public static void d(String tag, String log, Throwable tr) {
        if (DEBUG)
            Log.d(tag, log, tr);
    }

    public static void v(String log) {
        v(LOG_TAG, log);
    }

    public static void v(String tag, String log) {
        if (DEBUG)
            Log.v(tag, log);
    }

    public static void v(String log, Throwable tr) {
        v(LOG_TAG, log, tr);
    }

    public static void v(String tag, String log, Throwable tr) {
        if (DEBUG)
            Log.v(tag, log, tr);
    }

    public static void e(String log) {
        e(LOG_TAG, log);
    }

    public static void e(String tag, String log) {
        if (DEBUG)
            Log.e(tag, log);
    }

    public static void e(String log, Throwable tr) {
        e(LOG_TAG, log, tr);
    }

    public static void e(String tag, String log, Throwable tr) {
        if (DEBUG)
            Log.e(tag, log, tr);
    }

    public static void i(String log) {
        i(LOG_TAG, log);
    }

    public static void i(String tag, String log) {
        if (DEBUG)
            Log.i(tag, log);
    }

    public static void i(String log, Throwable tr) {
        i(LOG_TAG, log, tr);
    }

    public static void i(String tag, String log, Throwable tr) {
        if (DEBUG)
            Log.i(tag, log, tr);
    }

    public static void w(String log) {
        w(LOG_TAG, log);
    }

    public static void w(String tag, String log) {
        if (DEBUG)
            Log.w(tag, log);
    }

    public static void w(String log, Throwable tr) {
        w(LOG_TAG, log, tr);
    }

    public static void w(String tag, String log, Throwable tr) {
        if (DEBUG)
            Log.w(tag, log, tr);
    }

    public static void wtf(String log) {
        wtf(LOG_TAG, log);
    }

    public static void wtf(String tag, String log) {
        if (DEBUG)
            Log.wtf(tag, log);
    }

    public static void wtf(String log, Throwable tr) {
        wtf(LOG_TAG, log, tr);
    }

    public static void wtf(String tag, String log, Throwable tr) {
        if (DEBUG)
            Log.wtf(tag, log, tr);
    }

}
