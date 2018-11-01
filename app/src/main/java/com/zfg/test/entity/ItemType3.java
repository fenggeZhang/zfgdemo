package com.zfg.test.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.adapter.ExpandRecyclerAdapter;

/**
 * Created by zfg on 2018/9/14
 */
public class ItemType3 implements MultiItemEntity {
    private String content;
    private Class<?> mActivity;

    public ItemType3(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return ExpandRecyclerAdapter.TYPE_LEVEL_2;
    }

    public Class<?> getActivity() {
        return mActivity;
    }

    public void setActivity(Class<?> activity) {
        mActivity = activity;
    }
}
