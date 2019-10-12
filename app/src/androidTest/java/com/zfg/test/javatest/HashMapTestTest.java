package com.zfg.test.javatest;

import com.zfg.test.utils.LogUtil;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/10/12
 * desc   :
 */
public class HashMapTestTest {
    HashMap<String, String> mStringStringHashMap = new HashMap<>();

    @Test
    public void test() {
        mStringStringHashMap.put(null, "A");
        LogUtil.e("获取："+mStringStringHashMap.get(null));
        mStringStringHashMap.put(null, "B");
        LogUtil.e("获取："+mStringStringHashMap.get(null));
        mStringStringHashMap.put("A", "C");
        mStringStringHashMap.put("A", "C");
        mStringStringHashMap.put("A", "D");
        LogUtil.e("获取："+mStringStringHashMap.get("A"));
    }
}