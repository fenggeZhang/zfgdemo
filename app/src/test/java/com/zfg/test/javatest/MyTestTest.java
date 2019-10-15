package com.zfg.test.javatest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/10/15
 * desc   :
 */
public class MyTestTest {
    @Test
    public void test() {
        int a = 10;
        int b = a;
        a = 12;
        System.out.println(b);
        System.out.println(a);
    }
}