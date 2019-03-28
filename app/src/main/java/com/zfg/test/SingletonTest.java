package com.zfg.test;

/**
 * Created by zfg on 2019/3/26
 */
public class SingletonTest {
    private static volatile SingletonTest Instance;

    private SingletonTest() {
    }

    public SingletonTest getInstance() {
        if (Instance == null) {
            synchronized (SingletonTest.class) {
                if (Instance == null) {
                    Instance = new SingletonTest();
                }
            }
        }
        return Instance;
    }
}
