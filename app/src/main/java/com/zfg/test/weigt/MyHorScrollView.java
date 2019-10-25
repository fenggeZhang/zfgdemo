package com.zfg.test.weigt;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;

/**
 * @author ：张 奎
 * @date ：2019-09-12 08：51
 * 邮箱   ：JiaYang627@163.com / zhang_k@hks360.com
 */
public class MyHorScrollView extends HorizontalScrollView {

    private int downX;
    private int downY;
    private int mTouchSlop;

    public MyHorScrollView(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyHorScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyHorScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyHorScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (mScrollViewListener != null) {
            mScrollViewListener.onScrollChange(l, t, oldl, oldt);
        }
    }

    private onScrollViewListener mScrollViewListener;

    public void setOnScrollViewListener(onScrollViewListener listener) {
        this.mScrollViewListener = listener;
    }

    public interface onScrollViewListener {
        void onScrollChange(int x, int y, int oldx, int oldy);

    }



}
