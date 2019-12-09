package com.zfg.test.activity;

import android.widget.Button;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.StringTagAdapter;
import com.zfg.test.interfaces.OnFlexboxSubscribeListener;
import com.zfg.test.weigt.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class TagViewActivity extends BaseActivity {

    TagFlowLayout mFlowLayout;
    TagFlowLayout mSingleTagFlowLayout;
    TagFlowLayout mMultTagFlowLayout;
    Button mButton;
    StringTagAdapter mStringTagAdapter;
    StringTagAdapter mStringTagAdapter1;
    StringTagAdapter mStringTagAdapter2;
//dividerDrawable 分割线 10dp 透明的
    @Override
    protected int getLayoutId() {
        return R.layout.activity_tag_view;
    }

    @Override
    protected void setupView() {
        mFlowLayout = findViewById(R.id.flow_layout);
        mSingleTagFlowLayout = findViewById(R.id.single_flow_layout);
        mMultTagFlowLayout = findViewById(R.id.mult_flow_layout);
        mButton = findViewById(R.id.count_btn);
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            strings.add("热卖" + i);
        }
        mStringTagAdapter = new StringTagAdapter(this, strings);
        mStringTagAdapter1 = new StringTagAdapter(this, strings);
        mStringTagAdapter2 = new StringTagAdapter(this, strings);
        mFlowLayout.setAdapter(mStringTagAdapter);
        mSingleTagFlowLayout.setAdapter(mStringTagAdapter1);
        mMultTagFlowLayout.setAdapter(mStringTagAdapter2);

        mButton.setText("已选择" + mStringTagAdapter2.getSelectedList().size() + "个");

        mStringTagAdapter2.setOnSubscribeListener(new MyOnFlexboxSubscribeListener());
    }

    private class MyOnFlexboxSubscribeListener implements OnFlexboxSubscribeListener<String> {
        @Override
        public void onSubscribe(List<String> selectedItem) {
            mButton.setText("已选择" + selectedItem.size() + "个");
        }
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
