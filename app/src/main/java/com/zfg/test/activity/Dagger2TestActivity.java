package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.entitiy.Cloth;
import com.zfg.test.entitiy.DaggerMainComponent;
import com.zfg.test.entitiy.MainComponent;
import com.zfg.test.entitiy.MainModule;

import javax.inject.Inject;

public class Dagger2TestActivity extends AppCompatActivity {
    private TextView mTextView;
    @Inject
    Cloth cloth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_test);
        mTextView = findViewById(R.id.my_tv);
        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        build.inject(this);
        mTextView.setText("我现在有" + cloth);
    }
}
