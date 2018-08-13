package com.zfg.test.data.http.base;

import android.content.Context;

import com.zfg.test.data.http.HttpCallback;
import com.zfg.test.data.http.bean.BaseEntity;
import com.zfg.test.data.http.config.HttpConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by zfg on 2018/8/8
 */
public class BaseRetrofitManager {
    private Context context;

    private static BaseRetrofitManager instance;

    protected OkHttpClient okHttpClient;

    private Disposable disposable;

    protected BaseRetrofitManager(Context context) {
        this.context = context;
        initHttpClient();
    }

    public static BaseRetrofitManager getInstance(Context context) {
        if (instance == null) {
            synchronized (BaseRetrofitManager.class) {
                if (instance == null) {
                    instance = new BaseRetrofitManager(context);
                }
            }
        }
        return instance;
    }

    public void initHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
//                String token = PrefUtil.getString(context, PrefKey.ACCESS_TOKEN, "");
//               / LogUtil.d("token=>" + token);
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                        .addHeader("Accept-Encoding", "gzip, deflate")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("Accept", "*/*")
//                        .addHeader("Authorization", token)
                        .build();
                return chain.proceed(request);
            }
        });
        if (HttpConfig.IS_DEBUG) {
            HttpLogInterceptor logging = new HttpLogInterceptor();
            logging.setLevel(HttpLogInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        builder.connectTimeout(HttpConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(HttpConfig.READ_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(HttpConfig.WRITE_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient = builder.build();
    }

    /**
     * 获取retrofit对象
     */
    public Retrofit getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    protected void parseResult(final int taskId, Observable<String> observable, final HttpCallback callback) {
        if (callback != null) {
            callback.onTaskStart(taskId);
        }
        disposable = observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if (callback != null) {
                            BaseEntity<?> data = callback.onTaskInBackground(taskId, s);
                            callback.onTaskComplete(taskId, data);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callback != null) {
                            callback.onFinish();
                            callback.onError(taskId, throwable);
                        }
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        if (callback != null) {
                            callback.onFinish();
                        }
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (callback != null) {
                            callback.onSubscribe(disposable);
                        }
                    }
                });
    }


    //解除被观察者的绑定
    public void unSubscription() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
