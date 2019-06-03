package com.zfg.test.activity.ehks;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by zfg on 2019/5/5
 */
public class TabEntity implements CustomTabEntity {
    private String title;


    public TabEntity(String title) {
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return null;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
