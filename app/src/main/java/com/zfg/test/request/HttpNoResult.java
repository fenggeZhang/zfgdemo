package com.zfg.test.request;

/**
 * Created by zfg on 2018/6/7
 */
public class HttpNoResult {
    private int code;
    private String msg;

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

    @Override
    public String toString() {
        return "HttpNoResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
