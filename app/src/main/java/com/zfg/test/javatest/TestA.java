package com.zfg.test.javatest;

import com.zfg.test.utils.LogUtil;

/**
 * Created by zfg on 2018/11/20
 */
public class TestA {
    protected int a;

    protected static void getName() {
        LogUtil.e("getName()");
    }

    private void test() {
        getName();
    }
}
