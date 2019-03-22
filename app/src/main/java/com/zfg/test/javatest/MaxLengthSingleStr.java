package com.zfg.test.javatest;

import com.zfg.test.utils.LogUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zfg on 2019/3/21
 * 最长字串的长度
 */
public class MaxLengthSingleStr {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("pwwkew");
        System.out.println("length:" + length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s.equals(""))
            return maxLength;
        if (isSingle(s)) {
            return s.length();
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                if (isSingle(s.substring(i, j + 1))) {
                    if ((j + 1 - i) > maxLength) {
                        maxLength = j + 1 - i;
                        if (j == s.length() - 1) {
                            return maxLength;
                        }
                    }
                }
            }
        }
        return maxLength;
    }

    private static boolean isSingle(String substring) {
        for (int i = 0; i < substring.length(); i++) {
            for (int j = 0; j < substring.toCharArray().length; j++) {
                if (i != j) {
                    if ((substring.toCharArray()[j] + "").equals(substring.substring(i, i + 1))) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
