package com.zfg.test.data.http.retrofit;

import android.content.Context;

import com.zfg.test.data.http.HttpCallback;
import com.zfg.test.data.http.base.BaseRetrofitManager;
import com.zfg.test.data.http.config.HttpConfig;
import com.zfg.test.data.http.httpstores.WebStores;


import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by zfg on 2018/8/8
 */
public class WebService extends BaseRetrofitManager {

    private static WebService instance;

    private String baseUrl;
    private Retrofit retrofit;
    private WebStores webApiStores;

    private WebService(Context context) {
        super(context);
        baseUrl = HttpConfig.BASE_URL;
    }

    public static WebService getInstance(Context context) {
        if (instance == null) {
            synchronized (WebService.class) {
                if (instance == null) {
                    instance = new WebService(context);
                }
            }
        }
        return instance;
    }

    public Retrofit createRetrofit() {
        retrofit = getRetrofit(baseUrl);
        return retrofit;
    }

    public WebStores createApiStores() {
        webApiStores = createRetrofit().create(WebStores.class);
        return webApiStores;
    }


    /**
     * 获取首页
     */
    public void getMain(int taskId,HttpCallback callback) {
        Observable<String> observable = createApiStores().getMainInfo();
        parseResult(taskId, observable, callback);
    }

    public void clear() {
        retrofit = null;
        webApiStores = null;
        instance = null;
    }
}
