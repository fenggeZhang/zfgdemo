package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.entity.Cloth;
import com.zfg.test.entity.Clothes;
import com.zfg.test.entity.DaggerMainComponent;
import com.zfg.test.entity.MainComponent;
import com.zfg.test.entity.MainModule;
import com.zfg.test.entity.Shoe;

import javax.inject.Inject;
import javax.inject.Named;

public class Dagger2Test1Activity extends AppCompatActivity {
    @Inject
    Shoe shoe;
    @Inject
    Cloth cloth;
    @Inject
    Clothes clothes;
    TextView mTextView;

    @Inject
    @Named("red")
    Cloth redCloth;
    @Inject
    @Named("blue")
    Cloth blueCloth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_test1);
        mTextView = findViewById(R.id.my_tv);
        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        build.inject(this);
        mTextView.setText("我现在有" + cloth + shoe);
        mTextView.setText("我现在有" + cloth + "和" + shoe + "和" + clothes);
        mTextView.setText("我现在有" + redCloth + blueCloth);
    }
}
