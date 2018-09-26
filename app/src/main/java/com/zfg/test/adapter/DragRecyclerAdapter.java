package com.zfg.test.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.entity.DragContentItemBean;
import com.zfg.test.entity.DragItemBean;

import java.util.List;

/**
 * Created by zfg on 2018/9/17
 * 拖拽效果
 */
public class DragRecyclerAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int ITEM_HEAD = 1;
    public static final int ITEM_CONTENT = 2;

    public DragRecyclerAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(ITEM_HEAD, R.layout.item_drag_header);
        addItemType(ITEM_CONTENT, R.layout.item_drag_content);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (item.getItemType()) {
            case ITEM_HEAD:
                DragItemBean headeritem = (DragItemBean) item;
                helper.setText(R.id.item_header_tv, headeritem.getTitle());
                break;
            case ITEM_CONTENT:
                DragContentItemBean contentitem = (DragContentItemBean) item;
                helper.setImageResource(R.id.item_content_iv, R.mipmap.ic_launcher);
                helper.setText(R.id.item_content_tv, contentitem.getTitle());
                break;
        }
    }
}
