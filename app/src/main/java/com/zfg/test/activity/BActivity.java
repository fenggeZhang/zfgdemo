package com.zfg.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.common.LogUtil;
import com.zfg.test.R;
import com.zfg.test.entity.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(MessageEvent event) {
        /* Do something */
        LogUtil.e("收到了：" + event.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e("取消注册");
        EventBus.getDefault().unregister(this);
    }

    public void startA(View view) {
        startActivity(new Intent(this, AActivity.class));
    }
}
