package com.zfg.test.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;
import com.zfg.test.entity.CkBean;

import java.util.List;

/**
 * Created by zfg on 2018/5/17
 */
public class FlexAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public FlexAdapter(@Nullable List<String> data) {
        super(R.layout.item_flex, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.content_tv, item);
    }
}
