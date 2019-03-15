package com.zfg.test.javatest;

/**
 * Created by zfg on 2018/12/12
 * 排序算法
 */
public class SortTest {
    public static void main(String[] args) {
        int[] ints = new int[]{5, 15, 3, 9, 10, 55, 13};
        bubbleSort(ints);
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(i + "::" + arrs[i]);
        }
    }
}
