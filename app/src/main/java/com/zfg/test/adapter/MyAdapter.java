package com.zfg.test.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;
import com.zfg.test.entity.TestBean;

import java.util.List;

/**
 * Created by zfg on 2018/5/17
 */
public class MyAdapter extends BaseQuickAdapter<TestBean, BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<TestBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean item) {
        helper.setText(R.id.title_tv, item.getName());
    }
}
