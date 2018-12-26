package com.zfg.test.activity.anim;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

/**
 * @author zfg
 * @create 2018/12/25
 * @Describe 帧动画页面
 */
public class ZhenAnimActivity extends BaseActivity {
    private ImageView mImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhen_anim;
    }

    @Override
    protected void setupView() {
        mImageView = findViewById(R.id.anim_tv);
    }

    @Override
    protected void initData() {
//        xml方式
       /* mImageView.setImageResource(R.drawable.anim_zhen_test);
        AnimationDrawable animationDrawable = (AnimationDrawable) mImageView.getDrawable();
        animationDrawable.start();*/
//        代码方式
        AnimationDrawable animationDrawable1 = new AnimationDrawable();

        for (int i = 1; i < 9; i++) {
            int id = getResources().getIdentifier("im_dialog_progress" + i, "drawable", getPackageName());
            Drawable da = getResources().getDrawable(id);
            animationDrawable1.addFrame(da, 200);
        }
        mImageView.setBackground(animationDrawable1);
        animationDrawable1.setOneShot(false);
//获取对象实例，用来控制播放与停止
        AnimationDrawable rocketAnimation = (AnimationDrawable) mImageView.getBackground();
        rocketAnimation.start();    // 开启帧动画
//        rocketAnimation.stop();     // 停止动画
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
