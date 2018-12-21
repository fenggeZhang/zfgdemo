package com.zfg.test.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by zfg on 2018/12/13
 */
public class PxUtils {
    /**
     * dip转pix
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
