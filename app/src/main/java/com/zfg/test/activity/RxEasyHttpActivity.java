package com.zfg.test.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.ProgressDialogCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.subsciber.IProgressDialog;

import io.reactivex.disposables.Disposable;

/**
 * RxEasyHttp 网络请求
 */
public class RxEasyHttpActivity extends BaseActivity {
    Disposable disposable;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rx_easy_http;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_rxeasyhttp_title;
    }

    public void requsest(View view) {
        IProgressDialog mProgressDialog = new IProgressDialog() {
            @Override
            public Dialog getDialog() {
                ProgressDialog dialog = new ProgressDialog(mContext);
                dialog.setMessage("请稍候...");
                return dialog;
            }
        };
         disposable = EasyHttp.get("/tools/mockapi/7492/main")
                 .baseUrl("http://wanandroid.com")
//                .readTimeOut(30 * 1000)//局部定义读超时
//                .writeTimeOut(30 * 1000)
//                .connectTimeout(30 * 1000)
                .params("name", "张三")
                .timeStamp(true)
                .execute(new ProgressDialogCallBack<String>(mProgressDialog, true, true) {
                    @Override
                    public void onError(ApiException e) {
                        super.onError(e);//super.onError(e)必须写不能删掉或者忘记了
                        showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String response) {
                        if (response != null) showToast(response.toString());
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EasyHttp.cancelSubscription(disposable);
    }
}
