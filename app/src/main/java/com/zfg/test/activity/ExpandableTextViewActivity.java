package com.zfg.test.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.DividerGridItemDecoration;
import com.zfg.test.adapter.ExpandableTvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以收缩伸展 得Text
 */
public class ExpandableTextViewActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private ExpandableTvAdapter mExpandableTvAdapter;

    private List<String> mStringList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_expandable_text_view;
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.my_recycler);
    }

    @Override
    protected void initData() {
        mStringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mStringList.add(getString(R.string.textContent));
        }
        mExpandableTvAdapter = new ExpandableTvAdapter(mStringList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setAdapter(mExpandableTvAdapter);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_expand_tv;
    }
}
