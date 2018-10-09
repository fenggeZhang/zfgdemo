package com.zfg.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.zfg.test.R;

public class LinearLayoutActivity extends AppCompatActivity {
    private LinearLayout myLiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        myLiner = findViewById(R.id.my_linear);
//        myLiner.setShowDividers(SHOW_DIVIDER_MIDDLE);
    }
}
