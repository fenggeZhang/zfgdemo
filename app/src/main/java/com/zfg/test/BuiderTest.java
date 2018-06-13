package com.zfg.test;

import android.content.Context;

/**
 * Created by zfg on 2018/5/16
 * 自由扩展 ，一个复杂对象的构建和他的表示分离
 * 优点 良好的封装性，建造者独立，容易扩展
 * 缺点 会产生多余的对象，消耗内存
 */
public class BuiderTest {


    public static class Builder {
        private Context context;
        private int maxInt;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        //设置最大值
        public Builder setMaxNum(int maxNum) {
            this.maxInt = maxNum;
            return this;
        }
    }
}
