package com.zfg.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.stetho.common.LogUtil;
import com.zfg.test.R;

import static com.zfg.test.common.Contants.START_AROUTER_ACTIVITY;

@Route(path = START_AROUTER_ACTIVITY)
public class ArouterTestActivity extends AppCompatActivity {
    @Autowired(name = "name")
    public String name;//可以获取到传递的data不用主动获取
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_test);
        ARouter.getInstance().inject(this);
        LogUtil.e("name::"+name+"::"+age);

    }
}
