package com.zfg.test.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;
import com.zfg.test.entity.ClassicBean;

import java.util.List;

/**
 * Created by zfg on 2019/1/9
 */
public class ClassicRecyclerAdapter extends BaseMultiItemQuickAdapter<ClassicBean, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 1;
    public static final int TYPE_LEVEL_1 = 2;

    public ClassicRecyclerAdapter(List<ClassicBean> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_car_type1);
        addItemType(TYPE_LEVEL_1, R.layout.item_car_type2);
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassicBean item) {
        switch (item.getItemType()) {
            case TYPE_LEVEL_0:
                helper.setText(R.id.title, item.getTitle());
                break;
            case TYPE_LEVEL_1:
                helper.setText(R.id.title, item.getTitle());
                break;
        }
    }
}
