package com.zfg.test.activity.permission;

/**
 * Created by zfg on 2018/12/14
 * 权限回调接口
 */
public interface PermissionsResultListener {
    //成功
    void onSuccessful(int[] grantResults);

    //失败
    void onFailure();
}
