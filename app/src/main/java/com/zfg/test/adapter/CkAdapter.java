package com.zfg.test.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;
import com.zfg.test.entity.CkBean;
import com.zfg.test.entity.TestBean;

import java.util.List;

/**
 * Created by zfg on 2018/5/17
 */
public class CkAdapter extends BaseQuickAdapter<CkBean, BaseViewHolder> {
    public CkAdapter(@Nullable List<CkBean> data) {
        super(R.layout.item_ck, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CkBean item) {
        helper.setText(R.id.title_tv, item.getTitle());
    }
}
