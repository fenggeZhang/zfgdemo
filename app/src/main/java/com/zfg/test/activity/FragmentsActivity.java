package com.zfg.test.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.facebook.stetho.common.LogUtil;
import com.zfg.test.R;
import com.zfg.test.adapter.FragmentAdapter;
import com.zfg.test.fragment.AFragment;
import com.zfg.test.weigt.NoScrollViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class FragmentsActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    List<String> titles;//标题
    List<Fragment> fragments;
    private String mHeight="";

    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        initView();
        initData();
        EventBus.getDefault().register(this);
    }

    private void initData() {
        titles = new ArrayList<>();
        titles.add("页面A");
        titles.add("页面B");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        fragments = new ArrayList<>();
        AFragment oneFragment = new AFragment();
        AFragment twoFragment = new AFragment();
        fragments.add(oneFragment);
        fragments.add(twoFragment);
        FragmentAdapter mFragmentAdapteradapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);
    }

    private void initView() {
        mTabLayout=findViewById(R.id.my_tablayout);
        mViewPager=findViewById(R.id.view_pager);
        mButton=findViewById(R.id.my_btn);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String height) {
        if(!TextUtils.isEmpty(height)){
            mHeight=height;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void getHeight(View view) {
        mButton.setText(mHeight);
        LogUtil.e("高度：："+mHeight);
    }
}
