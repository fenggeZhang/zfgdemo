package com.zfg.test.algorithm;

import com.facebook.stetho.common.LogUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zfg on 2018/5/18
 */
public class YuanYinTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < num + 1; i++) {
            strings.add(in.nextLine());
        }
        for (int i = 1; i < strings.size(); i++) {
            countStr(strings.get(i), 'a');
            countStr(strings.get(i), 'e');
            countStr(strings.get(i), 'i');
            countStr(strings.get(i), 'o');
            countStr(strings.get(i), 'u');
            if(i!=strings.size()-1){
                System.out.println();
            }
        }
    }

    public static int countStr(String str, char key) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == key)
                count++;
        }
        System.out.print(key + ":" + count);
        System.out.println();

        return count;
    }
}
