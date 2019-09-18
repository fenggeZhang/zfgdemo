package com.zfg.test.activity.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.common.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class SpanRecyclerActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    SpanRvDataAdapter mSpanRvDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span_recycler);
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.content);
        List<MultiItemEntity> strings = new ArrayList<>();
        SpanDataBean bean = new SpanDataBean(SpanRvDataAdapter.TYPE_TITLE, "甜甜圈");
        strings.add(bean);

        SpanDataBean bean1 = new SpanDataBean(SpanRvDataAdapter.TYPE_CONTENT_TWO, "小蛋糕");
        bean1.setDrawable(getResources().getDrawable(R.mipmap.icon_food2));
        strings.add(bean1);
        strings.add(bean1);
        strings.add(bean1);
        strings.add(bean1);
        strings.add(bean1);

        SpanDataBean bean5 = new SpanDataBean(SpanRvDataAdapter.TYPE_TITLE, "甜甜圈");
        strings.add(bean5);
        SpanDataBean bean6 = new SpanDataBean(SpanRvDataAdapter.TYPE_CONTENT_THREE, "大蛋糕");
        strings.add(bean6);
        strings.add(bean6);
        strings.add(bean6);
        strings.add(bean6);
        SpanDataBean bean8 = new SpanDataBean(SpanRvDataAdapter.TYPE_TITLE, "甜甜圈");
        strings.add(bean8);
        strings.add(bean1);
        strings.add(bean6);

        SpanDataBean bean11 = new SpanDataBean(SpanRvDataAdapter.TYPE_TITLE, "甜甜圈");
        strings.add(bean11);

        SpanDataBean bean12 = new SpanDataBean(SpanRvDataAdapter.TYPE_CONTENT_ITEM, "开心果");
        strings.add(bean12);
        strings.add(bean12);
        strings.add(bean12);
        strings.add(bean12);
        strings.add(bean12);
        strings.add(bean12);
        strings.add(bean6);
        strings.add(bean6);

        mSpanRvDataAdapter = new SpanRvDataAdapter(strings);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 6));
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(10));
        mSpanRvDataAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                if (mSpanRvDataAdapter.getData().get(position).getItemType() == 1) {
                    return 6;
                } else if (mSpanRvDataAdapter.getData().get(position).getItemType() == 2) {
                    return 3;
                } else if (mSpanRvDataAdapter.getData().get(position).getItemType() == 6) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });
        mRecyclerView.setAdapter(mSpanRvDataAdapter);
    }
}
