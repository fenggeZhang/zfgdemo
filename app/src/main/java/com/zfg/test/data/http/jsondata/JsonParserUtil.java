package com.zfg.test.data.http.jsondata;

import android.text.TextUtils;

import com.zfg.test.data.http.bean.BaseEntity;

/**
 * Created by zfg on 2018/8/8
 * 返回数据处理
 */
public class JsonParserUtil {
    /**
     * 获取数据
     *
     * @param result
     * @return
     */
    public static BaseEntity<String> getApiData(String result) {
        BaseEntity<String> data = new BaseEntity<String>();
        if (TextUtils.isEmpty(result)) {
            data.code = -1;
        } else {
            data.code = 0;
//            ApiData apiData = GSONUtil.parseJson(result, ApiData.class);
            data.setData(result);
        }
        return data;
    }
}
