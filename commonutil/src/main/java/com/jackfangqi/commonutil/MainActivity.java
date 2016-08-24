package com.jackfangqi.commonutil;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jackfangqi.commonutil.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.d("onCreate->");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d("onStart->");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d("onResume->");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d("onPause->");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d("onStop->");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d("onRestart->");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("onDestroy->");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        LogUtil.d("onSaveInstanceState->");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.d("onRestoreInstanceState->");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.d("onConfigurationChanged->");
    }
}
