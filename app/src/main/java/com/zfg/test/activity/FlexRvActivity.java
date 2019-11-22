package com.zfg.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.zfg.test.R;
import com.zfg.test.adapter.FlexAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlexRvActivity extends AppCompatActivity {

    @BindView(R.id.content_rv)
    RecyclerView mContentRv;
    FlexAdapter mFlexAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex_rv);
        ButterKnife.bind(this);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            list.add(String.valueOf(i));
        }

        mFlexAdapter = new FlexAdapter(list);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this, FlexDirection.ROW, FlexWrap.WRAP);
        flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);
        mContentRv.setLayoutManager(flexboxLayoutManager);
        mContentRv.setAdapter(mFlexAdapter);
    }
}
