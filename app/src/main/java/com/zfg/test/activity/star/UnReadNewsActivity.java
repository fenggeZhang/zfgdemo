package com.zfg.test.activity.star;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import me.leolin.shortcutbadger.ShortcutBadger;

public class UnReadNewsActivity extends BaseActivity {

    EditText mCountEt;
    Button mSetBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_un_read_news;
    }

    @Override
    protected void setupView() {
        mCountEt = findViewById(R.id.count_et);
        mSetBtn = findViewById(R.id.set_btn);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {
        mSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int badgeCount = Integer.valueOf(mCountEt.getText().toString().trim());
                ShortcutBadger.applyCount(UnReadNewsActivity.this, badgeCount); //for 1.1.4+
            }
        });
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
