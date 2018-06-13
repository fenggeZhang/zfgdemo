package com.zfg.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zfg.test.R;
import com.zfg.test.entitiy.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
    }

    public void send(View view) {
        EventBus.getDefault().post(new MessageEvent("hello..."));
    }

    public void start(View view) {
        startActivity(new Intent(this,BActivity.class));
    }
}
