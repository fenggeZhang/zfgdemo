package com.zfg.test.activity.anim;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

/**
 * @author zfg
 * @create 2018/12/25
 * @Describe 补间动画
 * 两种方式  xml 代码
 */
public class BujianAnimActivity extends BaseActivity {
    TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bujian_anim;
    }

    @Override
    protected void setupView() {
        mTextView = findViewById(R.id.anim_tv);
    }

    @Override
    protected void initData() {
//        透明度
//        setAlpha();
//        伸缩
//        setScale();
//        平移 位移
//        setTranslateAnimation();
//        旋转
        setRotateAnimation();
    }

    private void setRotateAnimation() {
//        mTextView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_bujian_rotate));
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, 80, 80);
//        旋转360度
        rotateAnimation.setDuration(8000);
        rotateAnimation.setFillAfter(true);
        mTextView.setAnimation(rotateAnimation);
    }

    private void setTranslateAnimation() {
// xml形式
//        mTextView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_bujian_translate));
//      代码
        TranslateAnimation translateAnimation = new TranslateAnimation(30, -80, 30, 300);
        translateAnimation.setDuration(5000);
        translateAnimation.setFillAfter(true);
        mTextView.setAnimation(translateAnimation);
    }

    private void setScale() {
//        xml形式
//        mTextView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_bujian_scale));
//        代码形式
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, 0.5f, 0.5f);
        scaleAnimation.setDuration(5000);
        scaleAnimation.setFillAfter(true);
        mTextView.setAnimation(scaleAnimation);
    }

    private void setAlpha() {
        // xml形式
//        mTextView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_bujian_alpha));
//        代码形式

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(6000);
        alphaAnimation.setFillAfter(true);//动画结束之后保持结束后得状态
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        mTextView.setAnimation(alphaAnimation);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
