package com.zfg.test.adapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.entity.CarBean;
import com.zfg.test.entity.CarItemBean;

import java.util.List;

/**
 * Created by zfg on 2019/1/9
 */
public class CarListAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_TITLE = 1;
    public static final int TYPE_LEVEL_CONTENT = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public CarListAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_TITLE, R.layout.item_car_type1);
        addItemType(TYPE_LEVEL_CONTENT, R.layout.item_car_type2);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (item.getItemType()) {
            case TYPE_LEVEL_TITLE: {
                CarBean carBean = (CarBean) item;
                helper.setText(R.id.title, carBean.getTitle());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        if (carBean.isExpanded()) {
                            collapse(pos, false);
                        } else {
                            expand(pos, false);
                        }
                    }
                });
            }
            break;
            case TYPE_LEVEL_CONTENT: {
                CarItemBean carItemBean = (CarItemBean) item;
                helper.setText(R.id.title, carItemBean.getModel() + carItemBean.getVehicletype());
            }
            break;
        }

    }
}
