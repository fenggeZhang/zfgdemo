package com.zfg.test.data.http;

import android.content.Context;
import android.net.ParseException;

import com.facebook.stetho.common.LogUtil;
import com.google.gson.JsonParseException;
import com.zfg.test.utils.ToastUtils;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * 请求异常处理
 */
public class ErrorHelper {
    public static void onError(Context context, Throwable throwable) {
        try {
            if (throwable != null) {
                LogUtil.e("errorMsg:" + throwable.getMessage());
                if (throwable instanceof SocketTimeoutException) {
                    ToastUtils.show(context, "服务器连接超时");
                } else if (throwable instanceof ConnectException || throwable instanceof UnknownHostException) {
                    ToastUtils.show(context, "服务器连接失败");
                } else if (throwable instanceof JsonParseException
                        || throwable instanceof JSONException
                        || throwable instanceof ParseException) {
                    ToastUtils.show(context, "数据解析异常");
                } else {
                    ToastUtils.show(context, "服务器错误");
                }
            }
        } catch (Exception e1) {

        }
    }
}
