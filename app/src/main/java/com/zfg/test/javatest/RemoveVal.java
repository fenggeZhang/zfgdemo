package com.zfg.test.javatest;

import com.zfg.test.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfg on 2019/3/19
 */
public class RemoveVal {
    public static void main(String[] args) {
      /*  int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        removeElement(ints, 0);

        List<String> strings = letterCombinations("12");
        System.out.print(strings.toString());*/
        char[][] chars = {
                {'1', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '1'}
        };
        int num = numIslands(chars);
        System.out.print("个数" + num);
    }

    /**
     * 计算岛屿
     *
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int num = 0;
        if (grid.length == 0)
            return num;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    isLand(grid, i, j);
                    num++;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        return num;
    }

    private static void isLand(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';//遍历过就置为0
        isLand(grid, i - 1, j);
        isLand(grid, i + 1, j);
        isLand(grid, i, j - 1);
        isLand(grid, i, j + 1);

    }

    /**
     * 删除指定元素，返回数组前几位
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                nums[i--] = nums[--length];
            }
        }
        return length;
    }

    /**
     * 删除重复元素
     * 前提是一个有序数组
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[length++] = nums[i];
            }
        }
        return length;
    }

    /**
     * 这个是 深度优先算法 自身可以重复
     *
     * @param candidates
     * @param target
     * @return
     */
    //输入得目标数组是有序得
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
//        每一个符合规则得list
        List<Integer> integerList = new ArrayList<>();
//        相加和
        int sum = 0;
//        遍历得位置
        int index = 0;
        funSumResult(result, integerList, sum, index, target, candidates);
        return result;
    }

    private void funSumResult(List<List<Integer>> result, List<Integer> integerList, int sum, int index, int target, int[] candidates) {
        if (sum == target) {
            result.add(new ArrayList<>(integerList));
        } else if (sum < target) {
            //遍历过的数字就不再遍历，所以从index开始
            for (int i = index; i < candidates.length; i++) {
                sum += candidates[i];
                integerList.add(candidates[i]);
                funSumResult(result, integerList, sum, i, target, candidates);
                sum -= candidates[i];
                integerList.remove(integerList.size() - 1);
            }
        }
    }

    /**
     * 字母组合
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        String[][] c = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}};
        List<String> strings = new ArrayList<>();
        if (digits.equals("")) return strings;
        strings.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> m = new ArrayList();
            int n = digits.charAt(i) - 50 + 1;
            for (int j = 0; j < c[n].length; j++) {
                for (String s : strings) {
                    m.add(s + c[n][j]);
                    System.out.println("s:" + s + ";c[n][j]:" + c[n][j]);
                }
            }
            strings = m;
        }
        return strings;
    }

    private static void getAns(String[][] c, int index, String digits, String[] temp, List<String> strings) {

        if (index > digits.length() - 1) {
            strings.add(temp.toString());
            System.out.print(temp);
            return;
        }
        int a = digits.charAt(index) - 50 + 1;
        for (int j = 0; j < c[a].length; j++) {
            temp[index] += c[a][j];
            getAns(c, index + 1, digits, temp, strings);
        }
    }

}
