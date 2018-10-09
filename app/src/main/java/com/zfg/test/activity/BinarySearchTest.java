package com.zfg.test.activity;


/**
 * Created by zfg on 2018/7/17
 * 二分查找
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] ints = {10, 55, 8, 100, 2, 6, 74, 25, 88};
        int position = binarySearch(ints, 74);
        System.out.println("位置：：" + position);
        System.out.println("数据：" + ints[position]);
    }

    /**
     * 二分法查找
     *
     * @param array
     * @param value
     */
    private static int binarySearch(int[] array, int value) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }
}
