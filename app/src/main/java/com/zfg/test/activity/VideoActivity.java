package com.zfg.test.activity;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import chuangyuan.ycj.videolibrary.listener.VideoInfoListener;
import chuangyuan.ycj.videolibrary.listener.VideoWindowListener;
import chuangyuan.ycj.videolibrary.video.ExoUserPlayer;
import chuangyuan.ycj.videolibrary.video.VideoPlayerManager;
import chuangyuan.ycj.videolibrary.widget.VideoPlayerView;

/**
 * 视频播放器
 */
public class VideoActivity extends BaseActivity {
    private VideoPlayerView mPlayerView;
    ExoUserPlayer exoPlayerManager;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    protected void setupView() {
        mPlayerView = findViewById(R.id.exo_play_context_id);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {
        //实例化
         exoPlayerManager = new VideoPlayerManager.Builder(VideoPlayerManager.TYPE_PLAY_USER, mPlayerView)
//                .setDataSource(new DataSource(this))
                //加载rtmp 协议视频
//                .setPlayUri("rtmp://live.hkstv.hk.lxdns.com/live/hks")
                //加载m3u8
                .setPlayUri("http://dlhls.cdn.zhanqi.tv/zqlive/35180_KUDhx.m3u8")
                //加载ts.文件
//                .setPlayUri("http://185.73.239.15:25461/live/1/1/924.ts")
                //播放本地视频
//                .setPlayUri("/storage/emulated/0/DCIM/Camera/VID_20170717_011150.mp4")
                //播放列表视频
//                .setPlayUri(listss)
                //设置开始播放进度
                .setPosition(1000)
                //示例本地路径 或者 /storage/emulated/0/DCIM/Camera/VID_20180215_131926.mp4
//                .setPlayUri(Environment.getExternalStorageDirectory().getAbsolutePath() + "/VID_20170925_154925.mp4")
                //开启线路设置
//                .setShowVideoSwitch(true)
//                .setPlaySwitchUri(0, test, name)
//                .setPlaySwitchUri(0, 0, getString(R.string.uri_test_11), Arrays.asList(test), Arrays.asList(name))
                //设置播放视频倍数  快进播放和慢放播放
//                .setPlaybackParameters(0.5f, 0.5f)
                //是否屏蔽进度控件拖拽快进视频（例如广告视频，（不允许用户））
//                .setSeekBarSeek(false)
                //设置视循环播放
//                .setLooping(10)
                //视频进度回调
                .addOnWindowListener(new VideoWindowListener() {
                    @Override
                    public void onCurrentIndex(int currentIndex, int windowCount) {
                        Toast.makeText(getApplication(), currentIndex + "windowCount:" + windowCount, Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnWindowListener(new VideoWindowListener() {
                    @Override
                    public void onCurrentIndex(int currentIndex, int windowCount) {
                        Toast.makeText(getApplication(), currentIndex + "windowCount:" + windowCount, Toast.LENGTH_SHORT).show();
                    }
                })
                .addVideoInfoListener(new VideoInfoListener() {

                    @Override
                    public void onPlayStart(long currPosition) {

                    }

                    @Override
                    public void onLoadingChanged() {

                    }

                    @Override
                    public void onPlayerError(@Nullable ExoPlaybackException e) {

                    }

                    @Override
                    public void onPlayEnd() {

                    }

                    @Override
                    public void isPlaying(boolean playWhenReady) {

                    }
                })
                //创建
                .create()
                //播放视频
                .startPlayer();
    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_video_title;
    }

    @Override
    protected void onResume() {
        super.onResume();
        exoPlayerManager.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        exoPlayerManager.onPause();
    }


    @Override
    protected void onDestroy() {
        exoPlayerManager.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        exoPlayerManager.onConfigurationChanged(newConfig);//横竖屏切换
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        //使用播放返回键监听
        if (exoPlayerManager.onBackPressed()) {
            finish();
        }
    }
}
