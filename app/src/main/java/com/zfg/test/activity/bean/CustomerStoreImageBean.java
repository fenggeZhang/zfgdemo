package com.zfg.test.activity.bean;

import com.luck.picture.lib.entity.LocalMedia;

import java.io.Serializable;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/5/24
 * desc   :
 */
public class CustomerStoreImageBean implements Serializable {

    private static final long serialVersionUID = 7447925246556435497L;
    private String localPath;//本地地址
    private boolean isAdd = false;//是否是添加按钮

    public CustomerStoreImageBean() {
    }

    public CustomerStoreImageBean(boolean isAdd) {
        this.isAdd = isAdd;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }
}
