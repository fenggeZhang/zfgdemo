package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import io.reactivex.Observable;


public class MyEditTextActivity extends BaseActivity {
    Button mButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_edit_text;
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
