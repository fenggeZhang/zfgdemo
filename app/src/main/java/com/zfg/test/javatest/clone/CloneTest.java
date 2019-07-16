package com.zfg.test.javatest.clone;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/7/16
 * desc   :
 */
public class CloneTest {
    public static void main(String[] strings) {
        UserBean userBean = new UserBean();
        userBean.setId(11);
        userBean.setBean(new UserBean.AddressBean("中国北京"));

        UserBean userBean1 = (UserBean) userBean.clone();
//        userBean1.setBean((UserBean.AddressBean) userBean1.getBean().clone());
        userBean1.getBean().setAddress("中国河南");
        System.out.println(userBean.toString());
        System.out.println(userBean1.toString());
        System.out.println(userBean.getBean().getAddress());
        System.out.println(userBean1.getBean().getAddress());
    }
}
