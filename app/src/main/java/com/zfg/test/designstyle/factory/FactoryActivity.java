package com.zfg.test.designstyle.factory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zfg.test.R;
import com.zfg.test.utils.LogUtil;

public class FactoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        ACar aCar = MyFactory.getCar(ACar.class);
        LogUtil.e(aCar.getCarName());
        BCar bCar = MyFactory.getCar(BCar.class);
        LogUtil.e(bCar.getCarName());
    }
}
