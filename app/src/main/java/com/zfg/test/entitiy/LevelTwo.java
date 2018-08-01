package com.zfg.test.entitiy;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.adapter.MyClassicAdapter;

/**
 * Created by zfg on 2018/6/27
 */
public class LevelTwo extends AbstractExpandableItem<LevelThree> implements MultiItemEntity {

    public String title;

    public LevelTwo(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return 1;
    }

    @Override
    public int getLevel() {
        return MyClassicAdapter.LEVEL_TWO;
    }
}
