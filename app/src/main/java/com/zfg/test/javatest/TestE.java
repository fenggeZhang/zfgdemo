package com.zfg.test.javatest;

/**
 * Created by zfg on 2018/12/21
 */

 class TestE {
    public static void main(String[] args) {
        Outer.method().show();
    }

    interface Inter {
        void show();
    }

    static class Outer { //补齐代码
        public static Inter method() {
            return new Inter() {
                @Override
                public void show() {
                    System.out.print("helloWorld");
                }
            };
        }
    }


}
