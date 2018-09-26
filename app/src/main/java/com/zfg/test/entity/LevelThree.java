package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by zfg on 2018/6/27
 */
public class LevelThree implements MultiItemEntity {

    private String title;
    private String desc;
    public Boolean isChecked = false;

    public LevelThree(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int getItemType() {
        return 2;
    }
}
