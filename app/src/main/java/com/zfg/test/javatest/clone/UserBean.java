package com.zfg.test.javatest.clone;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/7/16
 * desc   :
 */
public class UserBean implements Cloneable {
    private int id;
    private String name;
    private AddressBean bean;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressBean getBean() {
        return bean;
    }

    public void setBean(AddressBean bean) {
        this.bean = bean;
    }

    @Override
    protected Object clone() {
        try {
            UserBean newUser = (UserBean) super.clone();
            newUser.setBean((AddressBean) newUser.getBean().clone());
            return newUser;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    public static class AddressBean implements Cloneable {
        private String address;

        public AddressBean(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new InternalError();
            }
        }
    }
}
