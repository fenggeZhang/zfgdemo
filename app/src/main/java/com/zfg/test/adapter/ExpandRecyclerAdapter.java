package com.zfg.test.adapter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.entity.ItemType1;
import com.zfg.test.entity.ItemType2;
import com.zfg.test.entity.ItemType3;
import com.zfg.test.utils.LogUtil;
import com.zfg.test.utils.ToastUtils;

import java.util.List;

/**
 * Created by zfg on 2018/9/14
 */
public class ExpandRecyclerAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_LEVEL_0 = 1;
    public static final int TYPE_LEVEL_1 = 2;
    public static final int TYPE_LEVEL_2 = 3;

    public ExpandRecyclerAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_type1);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_type2);
        addItemType(TYPE_LEVEL_2, R.layout.item_expandable_type3);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (item.getItemType()) {
            case TYPE_LEVEL_0: {
                final ItemType1 lv0 = (ItemType1) item;
                helper.setText(R.id.title, lv0.getTitle());
                helper.setImageResource(R.id.iv, lv0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos, false);
                        } else {
                            expand(pos, false);
                        }
                    }
                });
            }
            break;
            case TYPE_LEVEL_1: {
                final ItemType2 lv0 = (ItemType2) item;
                helper.setText(R.id.title, lv0.getTitle());
                helper.setImageResource(R.id.iv, lv0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        Log.d(TAG, "Level 1 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos, false);
                        } else {
                            expand(pos, false);
                        }
                    }
                });
            }
            break;
            case TYPE_LEVEL_2: {
                final ItemType3 lv0 = (ItemType3) item;
                helper.setText(R.id.title, lv0.getContent());
                helper.addOnClickListener(R.id.title);

               /* helper.getView(R.id.title).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.show(mContext,"点击了"+lv0.getContent());
                    }
                });*/
            }
            break;
        }
    }

}
