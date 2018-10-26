package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

/**
 * @author zfg
 * @create 2018/10/19
 * @Describe 加载超长大图
 */
public class LongPhotoActivity extends BaseActivity {
    SubsamplingScaleImageView mImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_long_photo;
    }

    @Override
    protected void setupView() {
        mImageView = findViewById(R.id.imageView);
    }

    @Override
    protected void initData() {
        mImageView.setImage(ImageSource.resource(R.drawable.img_back));
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_long_photo_title;
    }
}
