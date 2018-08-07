package com.zfg.test.data.http.bean;

import java.io.Serializable;

/**
 * Created by zfg on 2018/8/7
 * 网络请求返回得数据 （统一得格式）
 */
public class BaseEntity<T> implements Serializable {


    private static final long serialVersionUID = -4731323566809811989L;

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
