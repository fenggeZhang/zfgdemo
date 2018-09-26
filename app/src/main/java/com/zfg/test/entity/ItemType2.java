package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.adapter.ExpandRecyclerAdapter;

/**
 * Created by zfg on 2018/9/14
 */
public class ItemType2 extends AbstractExpandableItem<ItemType3> implements MultiItemEntity {
    private String title;

    public ItemType2(String title) {
        this.title = title;
    }

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
        return ExpandRecyclerAdapter.TYPE_LEVEL_1;
    }
}
