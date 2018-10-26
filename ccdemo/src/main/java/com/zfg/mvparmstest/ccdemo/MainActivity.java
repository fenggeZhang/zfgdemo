package com.zfg.mvparmstest.ccdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("zfg", "demoMian");
        TextView textView =new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText("demoMian");
        setContentView(textView);
    }
}
