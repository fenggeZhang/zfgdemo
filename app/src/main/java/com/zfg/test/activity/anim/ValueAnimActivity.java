package com.zfg.test.activity.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.Button;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

/**
 * @author zfg
 * @create 2018/12/26
 * @Describe 属性动画
 * ValueAnimator 类 & ObjectAnimator 类
 * <p>
 * 估值器 TypeEvaluator
 */
public class ValueAnimActivity extends BaseActivity {
    private Button mButton;
    AnimatorSet animatorSet;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_value_anim;
    }

    @Override
    protected void setupView() {
        mButton = findViewById(R.id.anim_btn);
    }

    @Override
    protected void initData() {
//        xml形式
/*        Animator animationSet = AnimatorInflater.loadAnimator(this, R.animator.anim_value);
        animationSet.setTarget(mButton);
        animationSet.start();*/
//        代码形式
//        平移动画
        ObjectAnimator translate = ObjectAnimator.ofFloat(mButton, "translationX", 0, 300, 0);
//        旋转动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(mButton, "rotation", 0f, 300f);
//        透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mButton, "alpha", 1f, 0f, 1f);
//        根据需求组合动画
         animatorSet=new AnimatorSet();
        /*animatorSet.play(Animator anim)//播放当前动画
        .after(long delay)//现有动画延迟X毫秒后执行
        .with(Animator anim)//将现有动画和传入动画同时执行
        .after(Animator anim)//将现有动画插入到传入得动画后执行
        .before(Animator anim);//将现有动画插入到传入得动画之前执行*/

        animatorSet.play(translate).with(rotate).before(alpha);
        animatorSet.setDuration(5000);
        animatorSet.start();



    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(animatorSet.isRunning()){
            animatorSet.end();
        }
    }
}
