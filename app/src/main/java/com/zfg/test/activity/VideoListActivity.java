package com.zfg.test.activity;

import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.VideoListAdapter;

import java.util.ArrayList;
import java.util.List;

import chuangyuan.ycj.videolibrary.video.VideoPlayerManager;

public class VideoListActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private VideoListAdapter mVideoListAdapter;
    private List<String> mList;

    private boolean isReset = true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_list;
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.content_recycler);
    }

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        mList.add("/storage/emulted/0/DCIM/Camera/VID_20180811_084545.mp4");
        mList.add("http://dlhls.cdn.zhanqi.tv/zqlive/35180_KUDhx.m3u8");
        mList.add("http://dlhls.cdn.zhanqi.tv/zqlive/35180_KUDhx.m3u8");
        mList.add("http://dlhls.cdn.zhanqi.tv/zqlive/35180_KUDhx.m3u8");
        mList.add("/storage/sdcard0/DCIM/Camera/VID_20180829_100348.mp4");
        mVideoListAdapter = new VideoListAdapter(mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
//        mRecyclerView.setAdapter(mVideoListAdapter);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_video_list_title;
    }

    @Override
    protected void onPause() {
        super.onPause();
        VideoPlayerManager.getInstance().onPause(isReset);
    }

    @Override
    protected void onResume() {
        super.onResume();
        VideoPlayerManager.getInstance().onResume();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //横竖屏切换
        VideoPlayerManager.getInstance().onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VideoPlayerManager.getInstance().onDestroy();
    }

    @Override
    public void onBackPressed() {
        //返回监听类
        if (VideoPlayerManager.getInstance().onBackPressed()) {
            finish();
        }
    }
}
