package com.jackfangqi.commonutil.utils;

/**
 * Created by Jack Fang on 2016/9/29, 14:45.
 * Project: CommonUtils
 * Compiler: Android Studio
 * Email: jackfangqi1314@gmail.com
 */
public class StringUtil {
    private static final String LOG_TAG = StringUtil.class.getSimpleName();

    private StringUtil() {
        throw new AssertionError();
    }

    public static boolean isEmpty(CharSequence s) {
        return (s == null || s.length() == 0);
    }

    public static boolean isBlank(String s) {
        return (s == null || s.trim().length() == 0);
    }
}
