package com.zfg.test.javatest;

import com.zfg.test.utils.LogUtil;

/**
 * Created by zfg on 2018/12/17
 */
public class TestD {
    public static void main(String[] strings) {
//        int length = lengthOfLastWord(" ");
//        System.out.print("长度:" + length);

        int[] ints = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] plusOne = plusOne(ints);
        System.out.print("ll:" + plusOne.toString());
    }

    public static int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings != null && strings.length > 0) {
            return strings[strings.length - 1].length();
        }
        return 0;
    }

    public static int[] plusOne(int[] digits) {
        String str = "";

        for (int i = 0; i < digits.length; i++) {
            str += "" + digits[i];
        }
        int result = Integer.parseInt(str);
        str = String.valueOf(result + 1);
        int[] ints = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ints[i] = Integer.parseInt("" + str.charAt(i));
        }
        return ints;
    }
}
