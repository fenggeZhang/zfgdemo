package com.zfg.test.activity.image;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GifActivity extends BaseActivity {


    @BindView(R.id.gif1_iv)
    ImageView mGif1Iv;
    @BindView(R.id.gif2_iv)
    ImageView mGif2Iv;
    @BindView(R.id.gif3_iv)
    ImageView mGif3Iv;
    @BindView(R.id.gif4_iv)
    ImageView mGif4Iv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gif;
    }

    @Override
    protected void setupView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

        Glide.with(mContext)
                .load(R.drawable.icon_test)
                .into(new GlideDrawableImageViewTarget(mGif1Iv, 3));

        Glide.with(this).load(R.drawable.icon_test)
                .asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(mGif2Iv);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }

}
