package com.zfg.test.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.ExpandRecyclerAdapter;
import com.zfg.test.entity.ItemType2;
import com.zfg.test.entity.ItemType3;

import java.util.ArrayList;
import java.util.List;

/**
 * 分组
 */
public class ExpandableClassicRecyclerActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private ExpandRecyclerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_expandable_classic_recycler;
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.my_rv);
    }

    @Override
    protected void initData() {

        List<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ItemType2 lv02 = new ItemType2("201" + i+"年款");
            for (int j = 0; j < 5; j++) {
                ItemType3 lv031 = new ItemType3("2.0TFSl 双离合 运动型Plus" + j);
                lv02.addSubItem(lv031);
            }
            res.add(lv02);
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new ExpandRecyclerAdapter(res);
        mRecyclerView.setAdapter(mAdapter);

        /**
         * 既然是动画，就会有时间，我们把动画执行时间变大一点来看一看效果
         */
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000);
        defaultItemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(defaultItemAnimator);


    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
