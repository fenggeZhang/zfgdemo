package com.zfg.test.javatest;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by zfg on 2018/12/10
 */
public class TestC {
    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
//        int[] result = twoSum(nums, target);
//        System.out.print("结果：" + result.length);

//        String str = "abba";
//        System.out.print("结果：" + lengthOfLongestSubstring(str));
//        int result = reverse(-2147483648);
//        System.out.println("反转:" + result);
//        String[] strings = new String[]{"aaa", "a", "aa"};
//        String str = longestCommonPrefix(strings);
//        System.out.println("结果：" + str);

        boolean b = isValid("{}[{}]");
        System.out.println("结果：" + b);
    }

    /**
     * 是否是有效得括号
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (stack.empty() || stack.peek() != map.get(s.charAt(i))) {
//                入栈
                stack.push(s.charAt(i));
            } else {
//                出栈 ：拿到栈顶元素，从栈顶移除，并将元素返回
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isKh(char c, char c1) {

        return true;
    }

    /**
     * 公共前缀
     * "flower","flow","flight"   结果  "fl"
     * 空                         结果   ""
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        if (strs.length > 1) {
            int len = strs[0].length();
            for (int i = 0; i < len; i++) {
                char curr = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() <= i || strs[j].charAt(i) != curr) {
                        return sb.toString();
                    }
                    if (strs[j].charAt(i) == curr && j == strs.length - 1) {
                        sb.append(curr);
                    }
                }
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        String y = CharAtreverse(xStr);
        return xStr.equals(y);
    }

    /**
     * 反转
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String str = "";
        if (x > 0) {
            str = CharAtreverse(String.valueOf(x));
        } else {
            str = CharAtreverse(String.valueOf((-x)));
        }
        long longInt = Long.parseLong(str);
        int returnId = new Long(longInt).intValue();
        return returnId;
    }

    public static String CharAtreverse(String s) {
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++)
            reverse = s.charAt(i) + reverse;
        return reverse;
    }

    public static int lengthOfLongestSubstring(String s) {
        int bigLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isSame(s, i, j)) {
                    if (bigLength < (j - i)) {
                        bigLength = j - i;
                    }
                }
            }
        }
        return bigLength;
    }

    private static boolean isSame(String s, int i, int j) {
        boolean issame = true;
        String myStr = s.substring(i, j);
        for (int k = i; k < j; k++) {
            Character ch = s.charAt(i);
            if (myStr.contains(ch.toString())) {
                issame = false;
            }
        }
        return issame;
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
