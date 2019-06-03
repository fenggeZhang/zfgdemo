package com.zfg.test.activity.ehks;


import android.support.v4.app.Fragment;

import com.flyco.tablayout.SegmentTabLayout;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.ArrayList;

public class OrderActivity extends BaseActivity {
    private SegmentTabLayout mSegmentTabLayout;
    private String[] mTitles = new String[]{"订单", "退货单"};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void setupView() {
        mSegmentTabLayout = findViewById(R.id.tl_1);
        ArrayList<Fragment> mFragments2 = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            mFragments2.add(OrderFrament.getInstance(mTitles[i]));
        }
        mSegmentTabLayout.setTabData(mTitles, this, R.id.fl_change, mFragments2);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
