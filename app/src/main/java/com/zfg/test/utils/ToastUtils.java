package com.zfg.test.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zfg on 2018/8/7
 * 土司提示
 */
public class ToastUtils {

    public static void show(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context, int content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
