package com.zfg.test.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfg on 2019/4/12
 * 全排列
 */
public class AllArrange {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getAllArrange(result, new ArrayList<Integer>(), nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("result:" + result.get(i));
        }
        return result;
    }

    private static void getAllArrange(List<List<Integer>> result, ArrayList<Integer> integers, int[] nums) {
        if (integers.size() == nums.length) {
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) {
                continue;
            }
            integers.add(nums[i]);
            getAllArrange(result, integers, nums);
            integers.remove(integers.size() - 1);
        }
    }
}
