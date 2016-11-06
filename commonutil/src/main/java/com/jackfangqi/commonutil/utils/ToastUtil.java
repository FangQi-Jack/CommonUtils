package com.jackfangqi.commonutil.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Compiler: Android Studio
 * Project: CommonUtils
 * Author: Jack Fang
 * Email: jackfangqi1314@gmail.com
 * Date: 2016/8/18 17:25
 */
public final class ToastUtil {

    private static final int DEFAULT_DURATION = Toast.LENGTH_SHORT;

    private ToastUtil() {
        throw new AssertionError();
    }

    public static void show(Context context, CharSequence msg) {
        show(context, msg, DEFAULT_DURATION);
    }

    public static void show(Context context, int resId) {
        show(context, context.getResources().getText(resId), DEFAULT_DURATION);
    }

    public static void show(Context context, int resId, int duration) {
        show(context, context.getResources().getText(resId), duration);
    }

    public static void show(Context context, CharSequence msg, int duration) {
        Toast.makeText(context, msg, duration).show();
    }

    public static void show(Context context, int resId, Object... args) {
        show(context, String.format(context.getResources().getString(resId), args), DEFAULT_DURATION);
    }

    public static void show(Context context, String msg, Object... args) {
        show(context, String.format(msg, args), DEFAULT_DURATION);
    }

    public static void show(Context context, int resId, int duration, Object... args) {
        show(context, String.format(context.getResources().getString(resId), args), duration);
    }

    public static void show(Context context, String msg, int duration, Object... args) {
        show(context, String.format(msg, args), duration);
    }

    public static void showCustomToast(Context context, int layoutId, int gravity, int xOffSet,
                                       int yOffSet) {
        showCustomToast(context, layoutId, gravity, xOffSet, yOffSet, DEFAULT_DURATION);
    }

    public static void showCustomToast(Context context, int layoutId, int gravity, int xOffSet,
                                       int yOffSet, int duration) {
        Toast t = new Toast(context);
        View view = LayoutInflater.from(context).inflate(layoutId, null);
        t.setView(view);
        t.setDuration(duration);
        t.setGravity(gravity, xOffSet, yOffSet);
        t.show();
    }

}
