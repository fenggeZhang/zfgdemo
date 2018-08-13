package com.zfg.test.activity.base;

import android.support.v7.app.AppCompatActivity;

import com.zfg.test.data.http.ErrorHelper;
import com.zfg.test.data.http.HttpCallback;
import com.zfg.test.data.http.HttpTaskRunnable;
import com.zfg.test.data.http.bean.BaseEntity;
import com.zfg.test.weigt.ILoadingDialog;

import io.reactivex.disposables.Disposable;

/**
 * Created by zfg on 2018/8/8
 */
public class BaseActivity extends AppCompatActivity implements HttpCallback {

    public ILoadingDialog mDialog;
    public Disposable mDisposable;

    @Override
    public void startTask(int taskId) {
        Thread thread = new Thread(new HttpTaskRunnable(taskId, this), String.valueOf(taskId));
        thread.start();
    }

    @Override
    public void onTaskStart(int taskId) {

    }

    @Override
    public void onError(int taskId, Throwable e) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        ErrorHelper.onError(this, e);
    }

    @Override
    public BaseEntity<?> onTaskInBackground(int taskId, String result) {
        return new BaseEntity<Object>(0, "ok");
    }

    @Override
    public void onTaskComplete(int taskId, BaseEntity<?> data) {

    }

    @Override
    public void onSubscribe(Disposable disposable) {
        mDisposable = disposable;
    }

    @Override
    public void onFinish() {

    }
}
