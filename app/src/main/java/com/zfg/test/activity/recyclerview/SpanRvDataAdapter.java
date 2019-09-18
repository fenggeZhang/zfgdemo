package com.zfg.test.activity.recyclerview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;

import java.util.List;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/9/12
 * desc   :
 */
public class SpanRvDataAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static int TYPE_TITLE = 1;
    public static int TYPE_CONTENT_TWO = 2;
    public static int TYPE_CONTENT_THREE = 3;
    public static int TYPE_CONTENT_ITEM = 6;
    public SpanRvDataAdapter(@Nullable List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_TITLE, R.layout.item_survey_data_title);
        addItemType(TYPE_CONTENT_TWO, R.layout.item_survey_data);
        addItemType(TYPE_CONTENT_THREE, R.layout.item_survey_data);
        addItemType(TYPE_CONTENT_ITEM, R.layout.item_survey_data1);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        SpanDataBean bean = (SpanDataBean) item;
        helper.setText(R.id.title_tv, bean.getTitle());
        if (bean.getDrawable() != null) {

        }

    }
}
