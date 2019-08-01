package com.zfg.test.designstyle.factory;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/7/30
 * desc   :
 */
public class MyFactory {
    public static <T extends CommonCar> T getCar(Class<T> clz) {
        CommonCar commonCar = null;
        try {
            commonCar = (CommonCar) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) commonCar;
    }
}

