package com.zfg.test.data.http.bean;

import java.io.Serializable;

/**
 * Created by zfg on 2018/8/7
 * 网络请求返回得数据 （统一得格式）
 */
public class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = -4731323566809811989L;

    public int code;
    public String msg;
    public T data;

    public BaseEntity() {
    }

    public BaseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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

    @Override
    public String toString() {
        return "BaseEntity{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
