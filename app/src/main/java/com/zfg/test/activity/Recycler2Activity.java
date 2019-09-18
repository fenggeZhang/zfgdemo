package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zfg.test.R;
import com.zfg.test.adapter.RightRvAdapter;
import com.zfg.test.adapter.StringAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 联动
 */
public class Recycler2Activity extends AppCompatActivity {
    RecyclerView mLeftRecyclerView;
    RecyclerView mRightRecyclerView;
    List<String> mStrings;
    List<String> mStrings1;
    List<List<String>> mLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);
        mLeftRecyclerView = findViewById(R.id.left_rv);
        mRightRecyclerView = findViewById(R.id.right_rv);
        mStrings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mStrings.add("数据" + i);
        }

        mStrings1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mStrings1.add("内容" + i);
        }
        initRecyclerView1();
        initRecyclerView2();


        mLeftRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    mRightRecyclerView.scrollBy(dx, dy);
                }
            }
        });

        mRightRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    mLeftRecyclerView.scrollBy(dx, dy);
                }
            }
        });
    }

    private void initRecyclerView2() {
        mRightRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLists = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            strings.add("数据" + i);
        }
        for (int i = 0; i < 10; i++) {
            mLists.add(strings);
        }
        RightRvAdapter stringAdapter = new RightRvAdapter(mLists);
        mRightRecyclerView.setAdapter(stringAdapter);
    }

    private void initRecyclerView1() {
        mLeftRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        StringAdapter stringAdapter = new StringAdapter(mStrings);
        mLeftRecyclerView.setAdapter(stringAdapter);
    }
}
