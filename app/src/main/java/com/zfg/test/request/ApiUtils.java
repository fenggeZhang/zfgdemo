package com.zfg.test.request;

/**
 * Created by zfg on 2018/6/7
 */
public class ApiUtils {
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static HttpHelper getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(HttpHelper.class);
    }

}
