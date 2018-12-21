package com.zfg.test.javatest;

import java.lang.reflect.Field;

/**
 * Created by zfg on 2018/12/20
 * 使用反射得时候 object 一定要有个无参构造方法
 */
public class GetFiled {
    public static void main(String[] strings) {
        Class<?> class1 = null;
        try {
            class1 = Class.forName("com.zfg.test.entity.CkBean");
            Object obj = class1.newInstance();

            Field personNameField = class1.getDeclaredField("type");
            personNameField.setAccessible(true);//暴力访问权限
            personNameField.set(obj, "胖虎先森");

            String nameString = class1.getClassLoader().getClass().getName();

            System.out.println(personNameField.get(obj));

            System.out.print("类加载name:" + nameString);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
