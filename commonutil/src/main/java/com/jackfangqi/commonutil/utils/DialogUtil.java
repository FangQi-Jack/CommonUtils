package com.jackfangqi.commonutil.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by JackFang on 2016/12/11 0:55.
 * Project: CommonUtils
 * Email: jackfangqi1314@gmail.com
 */
public class DialogUtil {
    private static final String LOG_TAG = "DialogUtil";

    private DialogUtil() {
        throw new AssertionError();
    }

    public static void showAlertDialog(Context context, CharSequence message,
            CharSequence negativeButtonText, CharSequence positiveButtonText,
            DialogInterface.OnClickListener onClickListener) {
        showAlertDialog(context, null, message, negativeButtonText, null, positiveButtonText,
                onClickListener, null, null, null, null, true);
    }

    public static void showAlertDialog(Context context, CharSequence title, CharSequence message,
            CharSequence negativeButtonText,
            DialogInterface.OnClickListener negativeButtonClickListener,
            CharSequence positiveButtonText,
            DialogInterface.OnClickListener positiveButtonClickListener,
            CharSequence neutralButtonText,
            DialogInterface.OnClickListener neutralButtonClickListener,
            DialogInterface.OnCancelListener cancelListener,
            DialogInterface.OnDismissListener dismissListener, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        if (TextUtils.isEmpty(message)) {
            builder.setMessage(message);
        }
        if (TextUtils.isEmpty(negativeButtonText)) {
            builder.setNeutralButton(negativeButtonText, negativeButtonClickListener);
        }
        if (TextUtils.isEmpty(positiveButtonText)) {
            builder.setPositiveButton(positiveButtonText, positiveButtonClickListener);
        }
        if (TextUtils.isEmpty(neutralButtonText)) {
            builder.setNeutralButton(neutralButtonText, neutralButtonClickListener);
        }
        builder.setOnCancelListener(cancelListener);
        builder.setOnDismissListener(dismissListener);
        builder.setCancelable(cancelable);
        builder.show();
    }

    public static void showAlertDialog(Context context, int title, int message,
            int negativeButtonText, DialogInterface.OnClickListener negativeButtonClickListener,
            int positiveButtonText, DialogInterface.OnClickListener positiveButtonClickListener,
            int neutralButtonText, DialogInterface.OnClickListener neutralButtonClickListener,
            DialogInterface.OnCancelListener cancelListener,
            DialogInterface.OnDismissListener dismissListener, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton(negativeButtonText, negativeButtonClickListener);
        builder.setPositiveButton(positiveButtonText, positiveButtonClickListener);
        builder.setNeutralButton(neutralButtonText, neutralButtonClickListener);
        builder.setOnCancelListener(cancelListener);
        builder.setOnDismissListener(dismissListener);
        builder.setCancelable(cancelable);
        builder.show();
    }

    public static void showCustomAlertDialog(Context context, View customViw,
            DialogInterface.OnCancelListener cancelListener,
            DialogInterface.OnDismissListener dismissListener, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(customViw);
        builder.setOnCancelListener(cancelListener);
        builder.setOnDismissListener(dismissListener);
        builder.setCancelable(cancelable);
        builder.show();
    }

    public static void showCustomAlertDialog(Context context, int customViwId,
            DialogInterface.OnCancelListener cancelListener,
            DialogInterface.OnDismissListener dismissListener, boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(customViwId);
        builder.setOnCancelListener(cancelListener);
        builder.setOnDismissListener(dismissListener);
        builder.setCancelable(cancelable);
        builder.show();
    }
}
