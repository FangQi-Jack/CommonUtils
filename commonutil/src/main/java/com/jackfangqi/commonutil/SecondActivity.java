package com.jackfangqi.commonutil;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.jackfangqi.commonutil.utils.LoadingDialogUtil;

public class SecondActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        });

        LoadingDialogUtil.showLoadingDialog(this, "loading 2...");

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                LoadingDialogUtil.dismissLoadingDialog();
            }
        }, 5000);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        LoadingDialogUtil.dismissLoadingDialog();
    }
}
