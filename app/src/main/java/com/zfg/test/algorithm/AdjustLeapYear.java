package com.zfg.test.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zfg on 2018/6/8
 * ACM 1076 闰年 使用while
 * http://acm.hdu.edu.cn/showproblem.php?pid=1076
 */
public class AdjustLeapYear {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();//测试个数
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int count=0;
            int year = in.nextInt();
            int number = in.nextInt();
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            {
                count = 1;
            }
            while (count < number)
            {
                year++;
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                {
                    count++;
                }
            }
            integers.add(year);
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}
