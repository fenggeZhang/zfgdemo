package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.adapter.DragRecyclerAdapter;

/**
 * Created by zfg on 2018/9/17
 */
public class DragContentItemBean implements MultiItemEntity {

    private int type;
    private String title;

    public DragContentItemBean(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return DragRecyclerAdapter.ITEM_CONTENT;
    }
}
