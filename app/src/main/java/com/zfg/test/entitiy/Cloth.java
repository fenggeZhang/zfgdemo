package com.zfg.test.entitiy;

/**
 * Created by zfg on 2018/5/28
 */
public class Cloth {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "布料";
    }

}
