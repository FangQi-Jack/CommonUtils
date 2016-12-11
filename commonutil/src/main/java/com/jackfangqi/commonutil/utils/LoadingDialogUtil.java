package com.jackfangqi.commonutil.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.jackfangqi.commonutil.R;

/**
 * Created by JackFang on 2016/12/11 10:00.
 * Project: CommonUtils
 * Email: jackfangqi1314@gmail.com
 */
public class LoadingDialogUtil {

    private static AlertDialog dialog;

    public static void showLoadingDialog(Context context, CharSequence loadingText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        @SuppressLint("InflateParams") View view =
                LayoutInflater.from(context).inflate(R.layout.fragment_loading_dialog, null);
        TextView loadingTv = (TextView) view.findViewById(R.id.loading_msg);
        loadingTv.setText(loadingText);
        builder.setView(view);
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }

    public static void dismissLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
