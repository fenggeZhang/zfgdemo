package com.zfg.test.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zfg.test.R;
import com.zfg.test.request.ApiUtils;

import java.util.HashMap;

import io.reactivex.schedulers.Schedulers;

public class RetrofitTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);
        requestHttp();
    }

    private void requestHttp() {
        /*ApiUtils.getSOService().search("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())*/
    }
}
