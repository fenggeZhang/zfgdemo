package com.zfg.test.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.zfg.test.R;
import com.zfg.test.entity.TestBean;

import java.util.List;

/**
 * Created by zfg on 2018/9/27
 */
public class ExpandableTvAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ExpandableTvAdapter(@Nullable List<String> data) {
        super(R.layout.item_expandtext, data);
    }

    public ExpandableTvAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ExpandableTextView expandableTextView = helper.getView(R.id.expand_tv);
        expandableTextView.setText(item);
    }
}
