package com.zfg.test.data.http.base;

import android.content.Context;

import com.zfg.test.data.http.bean.BaseEntity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by zfg on 2018/8/7
 */
public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {

    protected Context mContext;

    public BaseObserver() {
    }

    public BaseObserver(Context context) {
        mContext = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }


    @Override
    public void onNext(BaseEntity<T> value) {
        onRequestEnd();
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    protected void onRequestStart() {

    }

    protected void onRequestEnd() {

    }
}
