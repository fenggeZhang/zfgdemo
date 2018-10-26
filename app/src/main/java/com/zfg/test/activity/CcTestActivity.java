package com.zfg.test.activity;

import android.view.View;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.LogUtil;

/**
 * 组件化 测试页面
 */
public class CcTestActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cc_test;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_component_title;
    }

    public void open(View view) {
        CC cc = null;
        cc = CC.obtainBuilder("MainComponent")
                .setActionName("showActivityA")
                .build();
        CCResult result = cc.call();
        if (cc != null && result != null) {
            showResult(cc, result);
        }
    }

    private void showResult(CC cc, CCResult result) {
        LogUtil.e("zfg::" + cc.toString() + result.toString());
    }

    public void open2(View view) {
        CC cc = null;
        cc = CC.obtainBuilder("MainComponent2")
                .setActionName("showActivityA")
                .build();
        CCResult result = cc.call();
        if (cc != null && result != null) {
            showResult(cc, result);
        }
    }
}
