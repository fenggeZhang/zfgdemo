package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.classic.common.MultipleStatusView;
import com.zfg.test.R;

public class MutlViewActivity extends AppCompatActivity {
    private MultipleStatusView mMultipleStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutl_view);
        mMultipleStatusView = findViewById(R.id.multiple_status_view);

    }

    public void empty(View view) {
        //显示空视图
        mMultipleStatusView.showEmpty();
    }

    public void loading(View view) {
        mMultipleStatusView.showLoading();
    }

    public void error(View view) {
        mMultipleStatusView.showError();
    }

    public void net_error(View view) {
        mMultipleStatusView.showNoNetwork();
    }
}
