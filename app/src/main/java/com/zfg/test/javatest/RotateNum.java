package com.zfg.test.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfg on 2019/3/21
 * 数组转换
 */
public class RotateNum {
    public static void main(String[] args) {
//        [-1,-100,3,99] 和 k = 2
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        rotate(ints, 1);
        rotate(ints, 2);
        rotate(ints, 3);
        rotate(ints, 4);
        rotate(ints, 5);
    }

    public static void rotate(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int tempk = k % nums.length;
        for (int i = nums.length - tempk; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length - tempk; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }

}
