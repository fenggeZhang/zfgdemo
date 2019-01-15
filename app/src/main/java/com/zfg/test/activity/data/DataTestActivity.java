package com.zfg.test.activity.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

public class DataTestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);
    }

    @Override
    protected int getLayoutId() {
        return 0;
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
        return 0;
    }
}
