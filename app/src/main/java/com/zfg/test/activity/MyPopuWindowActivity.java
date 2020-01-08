package com.zfg.test.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.BitmapUtil;
import com.zfg.test.weigt.MyPopuWindow;

import java.io.IOException;

public class MyPopuWindowActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTextView1;
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
    }

    @Override
    protected void initData() {
        View view = getLayoutInflater().inflate(R.layout.popu_filter_setting, null);
        TextView textView = view.findViewById(R.id.confirmTextView);
        textView.setOnClickListener(view1 -> {
            // 核心代码start
            Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bitmap);
            view.layout(0, 0, view.getLayoutParams().width, view.getLayoutParams().height);
            view.draw(c);
            BitmapUtil.saveImageToGallery(mContext, bitmap);

        });
        myPopuWindow = new MyPopuWindow(this, view, mLinearLayout);
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
