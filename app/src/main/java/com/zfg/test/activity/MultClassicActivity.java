package com.zfg.test.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.adapter.MyClassicAdapter;
import com.zfg.test.entity.LevelOne;

import java.util.ArrayList;

public class MultClassicActivity extends AppCompatActivity {
    private Context mContext;
    private RecyclerView rvMain;
    private ArrayList<MultiItemEntity> multiList = new ArrayList<>();
    private MyClassicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_classic);
        mContext = this;

        initView();
        initData();

    }

    private void initView() {
        rvMain = (RecyclerView) findViewById(R.id.rv_main);
    }

    private void initData() {

        multiList = generateData();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new MyClassicAdapter(this, multiList);
        rvMain.setLayoutManager(manager);
        rvMain.setAdapter(adapter);

        // 使一级列表默认展开
        for (int i = multiList.size() - 1; i >= 0; i--) {
            adapter.expand(i, false, false);
        }
    }


    private ArrayList<MultiItemEntity> generateData() {

        int levelOne = 10;
        int levelTwo = 3;

        ArrayList<MultiItemEntity> res = new ArrayList<>();

        for (int i = 0; i < levelOne; i++) {

            LevelOne lv1 = new LevelOne("一级列表" + i, 0);

            for (int j = 0; j < levelTwo; j++) {

                LevelOne lv20 = new LevelOne("二级列表", 1);
                LevelOne lv21 = new LevelOne("二级列表", 1);
                LevelOne lv22 = new LevelOne("二级列表", 1);
                LevelOne lv3 = new LevelOne("三级列表" + j, 2);
                lv20.addSubItem(lv3);
                lv1.addSubItem(lv20);
                lv1.addSubItem(lv21);
                lv1.addSubItem(lv22);
            }
            res.add(lv1);
        }
        return res;
    }
}
