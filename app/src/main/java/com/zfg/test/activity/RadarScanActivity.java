package com.zfg.test.activity;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

/**
 * 雷达扫描
 */
public class RadarScanActivity extends BaseActivity {

//    private RadarView mRadarView;
//    private TestRadar mTestRadar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_radar_scan;
    }

    @Override
    protected void setupView() {
//        mRadarView = findViewById(R.id.radar_view);
//        mTestRadar = findViewById(R.id.my_radar_view);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {
//        mRadarView.start();
    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_radar_scan;
    }
}
