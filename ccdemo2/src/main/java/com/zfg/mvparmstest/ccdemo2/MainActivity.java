package com.zfg.mvparmstest.ccdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo2);
        TextView textView = findViewById(R.id.demo2_tv);
        textView.setText("哈哈哈哈哈");
    }
}
