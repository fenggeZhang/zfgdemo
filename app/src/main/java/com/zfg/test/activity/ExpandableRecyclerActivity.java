package com.zfg.test.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.ExpandRecyclerAdapter;
import com.zfg.test.adapter.MyClassicAdapter;
import com.zfg.test.entity.ItemType1;
import com.zfg.test.entity.ItemType2;
import com.zfg.test.entity.ItemType3;
import com.zfg.test.entity.LevelOne;
import com.zfg.test.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分组
 */
public class ExpandableRecyclerActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ExpandRecyclerAdapter mExpandRecyclerAdapter;
    private List<MultiItemEntity> mEntityList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_expandable_recycler;
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void initData() {
        mEntityList = new ArrayList<>();
        mExpandRecyclerAdapter = new ExpandRecyclerAdapter(generateData());
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mExpandRecyclerAdapter.getItemViewType(position) == ExpandRecyclerAdapter.TYPE_LEVEL_2 ? 1 : manager.getSpanCount();
            }
        });
        mRecyclerView.setAdapter(mExpandRecyclerAdapter);
        mRecyclerView.setLayoutManager(manager);
        mExpandRecyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.show(ExpandableRecyclerActivity.this, "我是item" + position);
            }
        });
        mExpandRecyclerAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.show(ExpandableRecyclerActivity.this, "我是child" + position);
            }
        });
        mExpandRecyclerAdapter.expandAll();
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.expand_recycler);
    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_expand_title;
    }

    private List<MultiItemEntity> generateData() {

        int levelOne = 10;
        int levelTwo = 3;

        List<MultiItemEntity> res = new ArrayList<>();

        for (int i = 0; i < levelOne; i++) {

            ItemType1 lv1 = new ItemType1("一级列表" + i);

            for (int j = 0; j < levelTwo; j++) {

                ItemType2 lv2 = new ItemType2("二级列表");
                ItemType3 lv3 = new ItemType3("苹果");
                ItemType3 lv30 = new ItemType3("香蕉");
                ItemType3 lv31 = new ItemType3("小番茄");
                lv2.addSubItem(lv3);
                lv2.addSubItem(lv30);
                lv2.addSubItem(lv31);
                lv1.addSubItem(lv2);
            }
            res.add(lv1);
        }
        return res;
    }
}
