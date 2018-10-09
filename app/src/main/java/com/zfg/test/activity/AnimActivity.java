package com.zfg.test.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.zfg.test.R;


public class AnimActivity extends AppCompatActivity {

    private LottieAnimationView mAnimationView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        mAnimationView = findViewById(R.id.animation_view);
    }
}
