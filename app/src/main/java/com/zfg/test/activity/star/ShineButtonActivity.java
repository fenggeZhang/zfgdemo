package com.zfg.test.activity.star;

import android.view.View;
import android.widget.Button;

import com.wx.goodview.GoodView;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

/**
 * 点赞
 */
public class ShineButtonActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shine_button;
    }

    @Override
    protected void setupView() {
        final GoodView goodView = new GoodView(this);
        Button button = findViewById(R.id.star_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodView.setTextInfo("收藏成功", R.color.bg_main, 14);
                goodView.show(v);
            }
        });

        Button button1 = findViewById(R.id.like_btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodView.setImage(R.drawable.ic_like);
                goodView.show(v);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
