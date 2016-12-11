package com.jackfangqi.commonutil;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jackfangqi.commonutil.utils.LoadingDialogFragment;
import com.jackfangqi.commonutil.utils.LoadingDialogUtil;
import com.jackfangqi.commonutil.utils.LogUtil;
import com.jackfangqi.commonutil.utils.ToastUtil;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.d("onCreate->");
        //LoadingDialogFragment dialogFragment = LoadingDialogFragment.newInstance("loading...");
        //dialogFragment.show(getSupportFragmentManager(), "MainActivity");
        LoadingDialogUtil.showLoadingDialog(this, "loading...");

        Button button = (Button) findViewById(R.id.start_second_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        Button button1 = (Button) findViewById(R.id.show_loading_dialog);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                LoadingDialogUtil.showLoadingDialog(MainActivity.this, "loading...");
                dismissDialogDelay();
            }
        });

        dismissDialogDelay();
    }

    private void dismissDialogDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                LoadingDialogUtil.dismissLoadingDialog();
            }
        }, 3000);
    }

    @Override protected void onStart() {
        super.onStart();
        LogUtil.d("onStart->");
    }

    @Override protected void onResume() {
        super.onResume();
        LogUtil.d("onResume->");
    }

    @Override protected void onPause() {
        super.onPause();
        LogUtil.d("onPause->");
    }

    @Override protected void onStop() {
        super.onStop();
        LogUtil.d("onStop->");
    }

    @Override protected void onRestart() {
        super.onRestart();
        LogUtil.d("onRestart->");
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy->");
        LoadingDialogUtil.dismissLoadingDialog();
    }

    @Override protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtil.d("onNewIntent->");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtil.d("onSaveInstanceState->");
    }

    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.d("onRestoreInstanceState->");
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.d("onConfigurationChanged->");
    }
}
