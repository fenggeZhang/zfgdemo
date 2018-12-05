package com.zfg.test.activity.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zfg on 2018/11/16
 */
public class NameResultData implements Serializable {
    private static final long serialVersionUID = -5338167500805206318L;

    private int code;
    private List<String> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
