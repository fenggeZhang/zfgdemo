package com.zfg.test.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.Logger;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author zfg
 * @create 2018/11/13
 * @Describe 跑马灯效果
 */
public class TextSwitcherActivity extends BaseActivity {
    TextSwitcher mTextSwitcher;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_text_switcher;
    }

    @Override
    protected void setupView() {
        mTextSwitcher = findViewById(R.id.my_switcher);
        initSwitcher(mTextSwitcher);
    }

    private void initSwitcher(TextSwitcher textSwitcher) {
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                final TextView tv = new TextView(mContext);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
                tv.setSingleLine(true);
                tv.setTextColor(Color.parseColor("#fe9232"));
                tv.setEllipsize(TextUtils.TruncateAt.END);
                tv.setGravity(Gravity.CENTER);
              /*  Drawable img = mContext.getResources().getDrawable(R.drawable.ic_navigation);
                tv.setCompoundDrawables(img, null, null, null); //设置左图标*/
                tv.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.MATCH_PARENT));
                return tv;

            }
        });
        final int[] currentSize = {0};
        ArrayList<String> listWinnerInfo = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            String text = String.format(i + "通知信息通知信息通知信息通知信息通知信息通知信息" + i, i);
            listWinnerInfo.add(text);
        }

        Disposable disposable = Observable.interval(0, 2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        textSwitcher.setText(listWinnerInfo.get(currentSize[0]++ % listWinnerInfo.size()));
                    }
                });
        mDisposable.add(disposable);
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
