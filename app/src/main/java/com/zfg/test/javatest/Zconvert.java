package com.zfg.test.javatest;

/**
 * Created by zfg on 2019/3/21
 * Z字型变换  找规律 然后再循环输出
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Zconvert {
    public static void main(String[] args) {
        long startTime = System.nanoTime();    //获取开始时间

        convert("LEETCODEISHIRING", 6);  //测试的代码段

        long endTime = System.nanoTime();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ns");    //输出程序运行时间

    }

    public static String convert(String s, int numRows) {
        int cols = 0;
        if (s.length() == 0)
            return "";
        if (numRows == 1) {
            return s;
        }
        if (s.length() % (2 * numRows - 2) == 0) {
            cols = s.length() / (2 * numRows - 2) * (numRows - 1);
        } else {
            if (s.length() % (2 * numRows - 2) < (numRows - 1)) {
                cols = s.length() / (2 * numRows - 2) * (numRows - 1) + 1;
            } else {
                cols = s.length() / (2 * numRows - 2) * (numRows - 1) + (s.length() % (2 * numRows - 2));
            }
        }
        char[][] chars = new char[numRows][cols];
        char[] chars1 = s.toCharArray();
        int index = 0;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < numRows; i++) {
                if (index < s.length()) {
                    if (j % (numRows - 1) == 0) {
                        chars[i][j] = chars1[index];
                        index++;
                    } else {
                        if ((i + j) % (numRows - 1) == 0) {
                            chars[i][j] = chars1[index];
                            index++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        String s1 = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chars[i][j] != '\0') {
                    s1 += chars[i][j];
                }
            }
        }
        return s1;
    }
}
