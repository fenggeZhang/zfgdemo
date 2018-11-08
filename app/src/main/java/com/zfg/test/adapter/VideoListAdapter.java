package com.zfg.test.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;

import java.util.List;

import chuangyuan.ycj.videolibrary.video.ExoUserPlayer;
import chuangyuan.ycj.videolibrary.video.ManualPlayer;
import chuangyuan.ycj.videolibrary.widget.VideoPlayerView;

/**
 * Created by zfg on 2018/11/2
 */
public class VideoListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public VideoListAdapter(@Nullable List<String> data) {
        super(R.layout.item_videolist, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ExoUserPlayer userPlayer;
        VideoPlayerView playerView = helper.getView(R.id.item_exo_play_context_id);
        userPlayer = new ManualPlayer((Activity) mContext, playerView);
//        userPlayer.setTitles("" + getAdapterPosition());
        userPlayer.setPlayUri(item);
        //设置列表item播放当前视频播放进度.不然不会保存视频播放进度
        userPlayer.setTag(helper.getAdapterPosition());
        Glide.with(mContext).load("....").into(playerView.getPreviewImage());
    }
}
