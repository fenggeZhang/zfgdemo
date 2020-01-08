package com.zfg.test.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.TimeLineAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 横向时间轴
 */

public class TimeLineRvActivity extends BaseActivity {
    List<String> strings = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_time_line_rv;
    }

    @Override
    protected void setupView() {
        RecyclerView recyclerView = findViewById(R.id.my_rv);
        strings.add("待退款");
        strings.add("车磐收货并退回供应商");
        strings.add("供应商收货");
        strings.add("完成");
        TimeLineAdapter timeLineAdapter = new TimeLineAdapter(strings);
        recyclerView.setLayoutManager(new GridLayoutManager(this, strings.size()));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        timeLineAdapter.setSelectState(setSelectState("完成"));
        recyclerView.setAdapter(timeLineAdapter);

    }

    private int setSelectState(String state) {
        for (int i = 0; i < strings.size(); i++) {
            if (state.equals(strings.get(i))) {
                return i;
            }
        }
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
