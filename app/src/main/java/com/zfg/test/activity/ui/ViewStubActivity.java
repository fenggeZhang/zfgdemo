package com.zfg.test.activity.ui;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

public class ViewStubActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_stub;
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

    public void show(View view) {

        ViewStub view1 = (ViewStub) findViewById(R.id.view_stub);
        View view2 = view1.inflate();//只能inflate一次，之后就会被置空
        TextView textView = view2.findViewById(R.id.viewstub_tv);
        textView.setText("ViewStub显示了");
    }
}
