package com.jackfangqi.commonutil.utils;

import android.app.Activity;
import android.view.View;

/**
 * Compiler: Android Studio
 * Project: CommonUtil
 * Author: Jack Fang
 * Email: jackfangqi1314@gmail.com
 * Date: 2016/8/23 17:37
 */
public final class FindViewUtil {
    public static <T extends View> T findView(Activity context, int id) {
        if (context == null)
            throw new RuntimeException("context cannot be null");

        return (T) context.findViewById(id);
    }

    public static <T extends View> T findView(View parent, int id) {
        if (parent == null)
            throw new RuntimeException("parent cannot be null");

        return (T) parent.findViewById(id);
    }
}
