package com.zfg.test.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zfg.test.adapter.NullStringToEmptyAdapterFactory;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zfg on 2018/8/8
 */
public class GSONUtil {
    public static <T> T parseJson(String jsonString, Class<T> clazz) {
        if (TextUtils.isEmpty(jsonString)) {
            return null;
        }
        T t = null;
        try {
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
            t = gson.fromJson(jsonString, clazz);
        } catch (Exception e) {
            LogUtil.e(e.getMessage());
            // TODO: handle exception
            e.printStackTrace();
        }
        return t;
    }

    public static <T> String toJson(T t) {
        Gson gson = new Gson();
        return gson.toJson(t);
    }

    public static <T> String toJson(List<T> t, Type type) {
        Gson gson = new Gson();
        return gson.toJson(t, type);
    }
}
