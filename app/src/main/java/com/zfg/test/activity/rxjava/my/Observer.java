package com.zfg.test.activity.rxjava.my;

/**
 * Created by zfg on 2019/5/22
 */
public interface Observer<T> {
    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
}
