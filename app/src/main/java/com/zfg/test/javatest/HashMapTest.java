package com.zfg.test.javatest;

import java.util.HashMap;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/10/12
 * desc   :
 */
public class HashMapTest {
    HashMap<String, String> mStringStringHashMap = new HashMap<>();

    private void test() {
        mStringStringHashMap.put(null, "A");
        mStringStringHashMap.put(null, "B");
    }
}
