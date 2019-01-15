package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import static com.zfg.test.adapter.CarListAdapter.TYPE_LEVEL_TITLE;

/**
 * Created by zfg on 2019/1/9
 */
public class CarBean extends AbstractExpandableItem<CarItemBean> implements MultiItemEntity {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return TYPE_LEVEL_TITLE;
    }
}
