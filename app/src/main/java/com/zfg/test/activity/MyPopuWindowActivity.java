package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.weigt.MyPopuWindow;

public class MyPopuWindowActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTextView1, mTextView2, mTextView3, mTextView4;
    private LinearLayout mLinearLayout;
    MyPopuWindow myPopuWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_popu_window;
    }

    @Override
    protected void setupView() {
        mLinearLayout = findViewById(R.id.filter_layout);
        mTextView1 = findViewById(R.id.filter_area_tv);
        mTextView2 = findViewById(R.id.filter_sales_detail_tv);
        mTextView3 = findViewById(R.id.filter_sales_money_tv);
        mTextView4 = findViewById(R.id.filter_setting_tv);
    }

    @Override
    protected void initData() {
        View view = getLayoutInflater().inflate(R.layout.popu_filter_setting, null);
        myPopuWindow = new MyPopuWindow(this,view, mLinearLayout);
    }

    @Override
    protected void addListener() {
        mTextView1.setOnClickListener(this);
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.filter_area_tv:
                myPopuWindow.show();
                break;
            case R.id.filter_sales_detail_tv:
                break;
            case R.id.filter_sales_money_tv:
                break;
            case R.id.filter_setting_tv:
                break;
        }
    }
}