package com.jackfangqi.commonutil.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack Fang on 2016/9/29, 14:42.
 * Project: CommonUtils
 * Compiler: Android Studio
 * Email: jackfangqi1314@gmail.com
 */
public class ResourceUtil {
    private static final String LOG_TAG = ResourceUtil.class.getSimpleName();

    private ResourceUtil() {
        throw new AssertionError();
    }

    public static String getFileFromAssets(Context context, String fileName) {
        if (context == null || StringUtil.isEmpty(fileName)) {
            return null;
        }

        StringBuilder s = new StringBuilder("");
        try {
            InputStreamReader in = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
            return s.toString();
        } catch (IOException e) {
            LogUtil.d(LOG_TAG, e);
            return null;
        }
    }

    public static String getFileFromRaw(Context context, int resId) {
        if (context == null) {
            return null;
        }

        StringBuilder s = new StringBuilder("");
        try {
            InputStreamReader in = new InputStreamReader(context.getResources().openRawResource(resId));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
            return s.toString();
        } catch (IOException e) {
            LogUtil.d(LOG_TAG, e);
            return null;
        }
    }

    public static List<String> getFile2ListFromAssets(Context context, String fileName) {
        if (context == null || StringUtil.isEmpty(fileName)) {
            return null;
        }

        List<String> fileContent = new ArrayList<>();
        try {
            InputStreamReader in = new InputStreamReader(context.getResources().getAssets().open(fileName));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.add(line);
            }
            return fileContent;
        } catch (IOException e) {
            LogUtil.d(LOG_TAG, e);
            return null;
        }
    }

    public static List<String> getFile2ListFromRaw(Context context, int resId) {
        if (context == null) {
            return null;
        }

        List<String> fileContent = new ArrayList<>();
        try {
            InputStreamReader in = new InputStreamReader(context.getResources().openRawResource(resId));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.add(line);
            }
            return fileContent;
        } catch (IOException e) {
            LogUtil.d(LOG_TAG, e);
            return null;
        }
    }
}
