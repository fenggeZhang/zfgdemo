package com.zfg.test.javatest;

import com.zfg.test.utils.LogUtil;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/10/12
 * desc   :
 */
public class HashMapTestTest {
    HashMap<String, String> mStringStringHashMap = new HashMap<>();
    HashMap<Integer, String> mIntegerStringHashMap = new HashMap<>();

    @Test
    public void test() {
        mStringStringHashMap.put(null, "A");
        System.out.println("获取：" + mStringStringHashMap.get(null));//A

        mStringStringHashMap.put(null, "B");
        System.out.println("获取：" + mStringStringHashMap.get(null));//B

        mStringStringHashMap.put("A", "C");
        mStringStringHashMap.put("A", "C");
        mStringStringHashMap.put("A", "D");
        System.out.println("获取：" + mStringStringHashMap.get("A"));//D

        mIntegerStringHashMap.put(null, "A");
        mIntegerStringHashMap.put(null, null);
        System.out.println("获取：" + mIntegerStringHashMap.get(null));//null
    }

    /**
     * 循环遍历
     */
    @Test
    public void eachMap() {

        testTime(10000);  //2 1 2 2  2
        testTime(100000);//5 4 5 4   17
        testTime(1000000);//18 18 21 17  81
        testTime(2000000);//36 39 51 40   192
        testTime(10000000);// 195 193 260 184  5846
        //总结 1 2 相当 然后第四种  最后一种最耗时

    }

    private void testTime(int num) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            map.put("测试" + i, "ceshi" + i);
        }
        System.out.println("测试size" + num);
        long startTime = System.currentTimeMillis(); // 获取开始时间
        for (Map.Entry<String, String> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("方式1:" + (endTime - startTime));


        startTime = System.currentTimeMillis(); // 获取开始时间
        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            entry.getKey();
            entry.getValue();
        }
        endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("方式2:" + (endTime - startTime));

        startTime = System.currentTimeMillis(); // 获取开始时间
        for (String key : map.keySet()) {
            map.get(key);
        }
        endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("方式3:" + (endTime - startTime));


        startTime = System.currentTimeMillis(); // 获取开始时间
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            entry.getKey();
            entry.getValue();
        }
        endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("方式4:" + (endTime - startTime));


        startTime = System.currentTimeMillis(); // 获取开始时间
        for (int i = 0; i < map.size(); i++) {
            map.get("测试" + i);
        }
        endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("方式5:" + (endTime - startTime));
        System.out.println();


    }
}