package com.zfg.test.activity.recyclerview;

import android.graphics.drawable.Drawable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/9/16
 * desc   :
 */
public class SpanDataBean implements MultiItemEntity {
    String title;
    int type;
    Drawable mDrawable;

    public SpanDataBean(int type, String titleStr) {
        this.type = type;
        this.title = titleStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getDrawable() {
        return mDrawable;
    }

    public void setDrawable(Drawable drawable) {
        mDrawable = drawable;
    }

    @Override
    public int getItemType() {
        return type;
    }
}
