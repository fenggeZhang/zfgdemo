package com.zfg.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zfg.test.R;
import com.zfg.test.utils.LogUtil;

public class IntentBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        setContentView(R.layout.activity_intent_b);
        LogUtil.e("B::onCreate");
    }

    public void start(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "我是返回的数据");
        setResult(100, intent);
        finish();
    }
}
