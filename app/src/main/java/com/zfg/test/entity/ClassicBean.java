package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by zfg on 2019/1/9
 */
public class ClassicBean implements MultiItemEntity {

   /* "makeid": 183,
            "vehicletype": "轿车",
            "modelid": 1473,
            "modelbrandid": 256,
            "model": "A1",
            "makename": "奥迪汽车",
            "rowid": 1*/


    private String title;

    private int type;

    public ClassicBean(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
