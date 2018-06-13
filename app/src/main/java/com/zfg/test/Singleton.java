package com.zfg.test;

/**
 * Created by zfg on 2018/5/16
 * 单例
 */
public class Singleton {
    private Singleton() {
    }

    public static Singleton getinstence() {
        return SingletonHolder.sInstance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }
}
