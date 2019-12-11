package com.zfg.test.activity.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;
import com.zfg.test.R;
import com.zfg.test.data.http.ErrorHelper;
import com.zfg.test.data.http.HttpCallback;
import com.zfg.test.data.http.HttpTaskRunnable;
import com.zfg.test.data.http.bean.BaseEntity;
import com.zfg.test.utils.LogUtil;
import com.zfg.test.utils.ToastUtils;
import com.zfg.test.weigt.ILoadingDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

/**
 * Created by zfg on 2018/8/8
 */
public abstract class BaseActivity extends AppCompatActivity implements HttpCallback {

    public ILoadingDialog mDialog;
    public List<Disposable> mDisposable;

    private RelativeLayout mCommonTitleLayout;
    private TextView mCommonTitleTv;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        initView();
//        Slidr.attach(this);
    }

    protected abstract int getLayoutId();

    public void initView() {
        mDisposable = new ArrayList<>();
        initTitleBar(getTitleStringId());
        setupView();
        initData();
        addListener();
    }


    protected abstract void setupView();

    protected abstract void initData();

    protected abstract void addListener();


    protected abstract int getTitleStringId();

    private void initTitleBar(int titleResId) {
        if (titleResId != 0) {
            mCommonTitleLayout = findViewById(R.id.common_titlebar_layout);
            mCommonTitleTv = findViewById(R.id.common_title_tv);
            mCommonTitleTv.setText(titleResId);
        }
    }

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
        mDisposable.add(disposable);
    }

    @Override
    public void onFinish() {

    }

    public void showToast(String message) {
        ToastUtils.show(this, message);
    }

    public void back(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (int i = 0, size = mDisposable.size(); i < size; i++) {
            if (mDisposable.get(i) != null) {
                mDisposable.get(i).dispose();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.e("activity onStop");
    }
}
