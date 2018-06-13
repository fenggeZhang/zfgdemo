package com.zfg.test.request;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zfg on 2018/6/7
 * 网络接口
 */
public interface HttpHelper {
    /**
     * 登录时获取验证码.
     *
     * @param phone 手机号
     * @return {"code":0}
     */

    @GET("login")
    Observable<HttpResult> search(@Query("phone") String phone);

}
