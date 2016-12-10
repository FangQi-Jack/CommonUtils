package com.jackfangqi.commonutil.utils;

import android.support.v4.util.SparseArrayCompat;
import android.view.View;

/**
 * Created by JackFang on 2016/12/10 23:30.
 * Project: CommonUtils
 * Email: jackfangqi1314@gmail.com
 */
public class CommonViewHolder {
    private static final String LOG_TAG = "CommonViewHolder";

    private static SparseArrayCompat<View> mViews = new SparseArrayCompat<>();

    private CommonViewHolder() {
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T getView(View convertView, int id) {
        View childView = mViews.get(id);
        LogUtil.d(LOG_TAG, "view id = " + id + ", is childView null? = " + (childView == null));
        if (childView == null) {
            childView = convertView.findViewById(id);
            mViews.put(id, childView);
        }
        return (T) childView;
    }
}
