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
        request();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_request;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_request_title;
    }

    private void request() {
        WebService.getInstance(this).getMain(TASK_MAIN, this);
    }

    @Override
    public BaseEntity<?> onTaskInBackground(int taskId, String result) {
        if (taskId == TASK_MAIN) {
            LogUtil.e("结果啊：：" + result);
            return JsonParserUtil.getApiData(result);
        }
        return super.onTaskInBackground(taskId, result);
    }

    @Override
    public void onTaskComplete(int taskId, BaseEntity<?> data) {
        if (taskId == TASK_MAIN) {
            getMainSuccess(data);
        }
        super.onTaskComplete(taskId, data);
    }

    private void getMainSuccess(BaseEntity<?> data) {
        LogUtil.e(data.toString());
    }
}
