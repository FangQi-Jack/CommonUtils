package com.jackfangqi.commonutil.utils;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jackfangqi.commonutil.R;

/**
 * Loading dialog
 *
 * @author Jack Fang
 */
public class LoadingDialogFragment extends DialogFragment {
    private static final String MSG_TAG_KEY = "msg_key";
    private static final String CANCELABLE_TAG_KEY = "cancelable";
    private static final String CANCELABLE_OUTSIDE_TAG_KEY = "cancelable_outside";

    private String mDialogMsg;
    private boolean cancelable;
    private boolean cancelableOutside;

    public static LoadingDialogFragment newInstance(String msg) {
        return newInstance(msg, true, true);
    }

    public static LoadingDialogFragment newInstance(String msg, boolean cancelable, boolean cancelableOutside) {
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        Bundle args = new Bundle();
        args.putString(MSG_TAG_KEY, msg);
        args.putBoolean(CANCELABLE_TAG_KEY, cancelable);
        args.putBoolean(CANCELABLE_OUTSIDE_TAG_KEY, cancelableOutside);
        fragment.setArguments(args);

        return fragment;
    }

    public LoadingDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mDialogMsg = args.getString(MSG_TAG_KEY);
        cancelable = args.getBoolean(CANCELABLE_TAG_KEY, true);
        cancelableOutside = args.getBoolean(CANCELABLE_OUTSIDE_TAG_KEY, true);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_loading_dialog, null);

        TextView dialogMsgText = (TextView) view.findViewById(R.id.loading_msg);
        if (mDialogMsg == null || "".equals(mDialogMsg))
            mDialogMsg = getActivity().getResources().getString(R.string.loading_dialog_default_msg);
        dialogMsgText.setText(mDialogMsg);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        return builder.create();
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(cancelableOutside);
    }
}
