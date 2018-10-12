package com.zfg.test.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfg on 2018/10/12
 */
public class ExpandGroupBean implements Serializable {

    private static final long serialVersionUID = 4313758813571559971L;

    private String groupName;

    private List<ExpandChildBean> mChildBeans = new ArrayList<>();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ExpandChildBean> getChildBeans() {
        return mChildBeans;
    }

    public void setChildBeans(List<ExpandChildBean> childBeans) {
        mChildBeans = childBeans;
    }

    public static class ExpandChildBean {
        private String childName;

        public String getChildName() {
            return childName;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }
    }

}
