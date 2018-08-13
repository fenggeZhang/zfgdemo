package com.zfg.test.data.http;

import com.zfg.test.data.http.bean.BaseEntity;

import io.reactivex.disposables.Disposable;

/**
 * Created by xiaote on 2017/1/10.
 * 网络请求回调接口
 */

public interface HttpCallback {

    /**
     * 启动网络线程
     */
    void startTask(int taskId);

    /**
     * 请求开始
     */
    void onTaskStart(int taskId);

    /**
     * 获取失败
     */
    void onError(int taskId, Throwable e);

    /**
     * 获取数据
     */
    BaseEntity<?> onTaskInBackground(int taskId, String result);

    /**
     * 获取成功
     */
    void onTaskComplete(int taskId, BaseEntity<?> data);

    /** 绑定观察者 */
    void onSubscribe(Disposable disposable);

    /** 完成 */
    void onFinish();
}
