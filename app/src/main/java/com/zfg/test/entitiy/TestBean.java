package com.zfg.test.entitiy;

import android.app.Activity;

import java.io.Serializable;

/**
 * Created by zfg on 2018/5/17
 */
public class TestBean implements Serializable {
    private String type;
    private String name;
    private Activity mActivity=null;

    public TestBean() {
    }

    public TestBean(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
