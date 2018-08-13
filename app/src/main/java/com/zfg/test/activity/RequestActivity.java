package com.zfg.test.activity;

import android.os.Bundle;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.data.http.bean.BaseEntity;
import com.zfg.test.data.http.jsondata.JsonParserUtil;
import com.zfg.test.data.http.retrofit.WebService;
import com.zfg.test.utils.LogUtil;

public class RequestActivity extends BaseActivity {

    public static final int TASK_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        request();
    }

    private void request() {
        WebService.getInstance(this).getMain(TASK_MAIN, this);
    }

    @Override
    public BaseEntity<?> onTaskInBackground(int taskId, String result) {
        switch (taskId) {
            case TASK_MAIN:
                LogUtil.e("结果啊：："+result);
                return JsonParserUtil.getApiData(result);
        }
        return super.onTaskInBackground(taskId, result);
    }

    @Override
    public void onTaskComplete(int taskId, BaseEntity<?> data) {
        switch (taskId) {
            case TASK_MAIN:
                getMainSuccess(data);
                break;
        }
        super.onTaskComplete(taskId, data);
    }

    private void getMainSuccess(BaseEntity<?> data) {
        LogUtil.e(data.toString());
    }
}
