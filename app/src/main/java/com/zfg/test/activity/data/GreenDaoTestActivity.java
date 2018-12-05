package com.zfg.test.activity.data;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.data.http.bean.BaseEntity;
import com.zfg.test.data.http.jsondata.JsonParserUtil;
import com.zfg.test.data.http.retrofit.WebService;
import com.zfg.test.entity.RequestData;
import com.zfg.test.utils.GSONUtil;
import com.zfg.test.utils.GsonUtils;
import com.zfg.test.utils.LogUtil;
import com.zfg.test.utils.RetrofitUtil;

/**
 * greenDao 测试
 */
public class GreenDaoTestActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_green_dao_test;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {


        WebService.getInstance(this, "http://139.129.205.11:92").getName(1, RetrofitUtil.getJSONRequestBody(GSONUtil.toJson(new RequestData())), this);
    }

    @Override
    public BaseEntity<?> onTaskInBackground(int taskId, String result) {
        switch (taskId) {
            case 1:
                LogUtil.e("结果啊：：" + result);
                return JsonParserUtil.getApiData(result);
        }
        return super.onTaskInBackground(taskId, result);
    }

    @Override
    public void onTaskComplete(int taskId, BaseEntity<?> data) {
        switch (taskId) {
            case 1:
                NameResultData searchTerm = GsonUtils.fromJson((String) data.getData(), NameResultData.class);
                LogUtil.e("获取得data" + searchTerm.getData());
                break;
        }
        super.onTaskComplete(taskId, data);
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
