package com.zfg.test.javatest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by zfg on 2018/12/20
 * 获取java对象的大小
 * <p>
 * eg：String value = "";   7
 * String value = " ";   8
 * String value = "10";  9
 * Integer value = 1;    81
 * Integer value = 10;  81
 */
public class GetObjectSize {

    public static void main(String[] strings) {


        Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true


        Integer m = 123;//自动装箱过程  所以就与z相同
        Integer n = 123;
        System.out.println(m == n);    // true
        System.out.println(x == m);//false
        System.out.println(x == z);//false
        System.out.println(m == z);//true

        int a = 123;
        System.out.println(a == m);//true

        String value = "10";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(value);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("大小：" + outputStream.size());
    }

}
