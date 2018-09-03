package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zfg.test.R;
import com.zfg.test.utils.DisplayUtil;

/**
 * 屏幕适配
 */
public class FitXYActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_xy);
//        DisplayUtil.setCustomDensity(this, getApplication());
    }
}
