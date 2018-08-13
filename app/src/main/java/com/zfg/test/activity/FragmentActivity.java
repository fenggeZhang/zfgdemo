package com.zfg.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zfg.test.R;
import com.zfg.test.fragment.TestFragment;

/**
 * Created by zfg on 2018/8/9
 */
public class FragmentActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        getFragmentManager().beginTransaction()
                .replace(R.id.ec_layout_content, new TestFragment())
                .commitAllowingStateLoss();

    }
}
