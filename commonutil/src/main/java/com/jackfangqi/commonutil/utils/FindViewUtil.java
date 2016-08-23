package com.jackfangqi.commonutil.utils;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;

/**
 * Compiler: Android Studio
 * Project: CommonUtil
 * Author: Jack Fang
 * Email: jackfangqi1314@gmail.com
 * Date: 2016/8/23 17:37
 */
public final class FindViewUtil {

    private FindViewUtil() {
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T findView(Activity context, int id) {
        if (context == null)
            throw new RuntimeException("context cannot be null");

        return (T) context.findViewById(id);
    }

    public static SparseArray<View> findViews(Activity context, int[] ids) {
        SparseArray<View> views = new SparseArray<>();
        if (ids != null && ids.length > 0) {
            for (int id : ids) {
                views.put(id, findView(context, id));
            }
        }

        return views;
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T findView(View parent, int id) {
        if (parent == null)
            throw new RuntimeException("parent view cannot be null");

        return (T) parent.findViewById(id);
    }

    public static SparseArray<View> findViews(View parent, int[] ids) {
        SparseArray<View> views = new SparseArray<>();
        if (ids != null && ids.length > 0) {
            for (int id : ids) {
                views.put(id, findView(parent, id));
            }
        }

        return views;
    }
}
