package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zfg.test.R;

public class RetrofitTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);
        requestHttp();
    }

    private void requestHttp() {

    }
}
