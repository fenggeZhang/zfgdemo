package com.zfg.test.data.http.httpstores;

import com.zfg.test.data.http.bean.BaseEntity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by zfg on 2018/8/7
 */
public interface WebStores {

    @GET("/tools/mockapi/7492/main")
    Observable<String> getMainInfo();

    @POST("epcs/getSearchTerm?appcode=SAAS2")
    Observable<String> getName(@Body RequestBody requestBody);

}
