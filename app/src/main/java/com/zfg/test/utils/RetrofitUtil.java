package com.zfg.test.utils;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * <p>描述： </p>
 *
 * @author by houJia<br>
 * 2018/4/10 <br>
 */
public class RetrofitUtil {
    public static RequestBody getJSONRequestBody(String jsonStr) {
        return RequestBody.create(MediaType.parse("application/json"), jsonStr);
    }

    public static <T> RequestBody getJSONRequestBodyForBean(T t) {
        Gson gson = new Gson();
        String newCarInfoJson = gson.toJson(t);
        return RequestBody.create(MediaType.parse("application/json"), newCarInfoJson);
    }
}
