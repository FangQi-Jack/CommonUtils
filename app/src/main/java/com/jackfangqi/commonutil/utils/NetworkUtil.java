package com.jackfangqi.commonutil.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Compiler: Android Studio
 * Project: CommonUtil
 * Author: Jack Fang
 * Email: fangqi@xywy.com
 * Date: 2016/8/19 17:30
 */
public final class NetworkUtil {
    private NetworkUtil() {
        throw new AssertionError();
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm == null || cm.getActiveNetworkInfo() == null;
    }

    public static int getNetworkType(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm == null ? null : cm.getActiveNetworkInfo();
        return networkInfo == null ? -1 : networkInfo.getType();
    }

    public static boolean isWiFiConnected(Context context) {
        return getNetworkType(context) == ConnectivityManager.TYPE_WIFI;
    }
}
