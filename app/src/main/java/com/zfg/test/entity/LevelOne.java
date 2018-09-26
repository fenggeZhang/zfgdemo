package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import static com.zfg.test.adapter.MyClassicAdapter.LEVEL_ONE;

/**
 * Created by zfg on 2018/6/27
 */
public class LevelOne extends AbstractExpandableItem<LevelOne> implements MultiItemEntity {

    public String title;
    public int level = LEVEL_ONE;//默认是一级分类

    public LevelOne(String title, int level) {
        this.title = title;
        this.level = level;
    }

    /*public void setLevel(int level) {
        this.level = level;
    }*/

    @Override
    public int getItemType() {
        return this.level;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}
