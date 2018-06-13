package com.zfg.test.algorithm;

import com.facebook.stetho.common.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zfg on 2018/6/8
 */
public class AddSumTest {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Map<Integer,Integer>  integerMap=new HashMap<Integer, Integer>() ;
        for (int i = 0; i < num; i++) {
            int aNum=in.nextInt();
            for (int j = 0; j < aNum; j++) {
                int value=0;
                if(integerMap.get(i)!=null){
                    value=integerMap.get(i);
                }
                integerMap.put(i,value+in.nextInt());
            }
        }
        for (int i = 0; i <num ; i++) {
            System.out.println(integerMap.get(i));
        }
    }
}
