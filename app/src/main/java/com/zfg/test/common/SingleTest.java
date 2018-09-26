package com.zfg.test.common;

/**
 * Created by zfg on 2018/9/26
 * 单例
 */
public class SingleTest {
    private volatile static SingleTest mInstance;

    public SingleTest() {

    }

    public static SingleTest getInstance() {
        if (mInstance == null) {
            synchronized (SingleTest.class) {
                if (mInstance == null) {
                    mInstance = new SingleTest();
                }
            }
        }
        return mInstance;
    }
}
