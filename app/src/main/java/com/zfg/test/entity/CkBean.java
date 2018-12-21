package com.zfg.test.entity;

/**
 * Created by zfg on 2018/12/13
 */
public class CkBean {
    private String type;
    private String title;

    public CkBean() {
    }

    public CkBean(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
