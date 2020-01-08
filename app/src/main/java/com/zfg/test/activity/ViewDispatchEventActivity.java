package com.zfg.test.activity;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.LogUtil;

/**
 * 事件分发
 */
public class ViewDispatchEventActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {
    private TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_view_dispatch_event;
    }

    @Override
    protected void setupView() {
        mTextView = findViewById(R.id.my_tv);
    }

    @Override
    protected void initData() {

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void addListener() {
        mTextView.setOnClickListener(this);
        mTextView.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.e("activity dispatchTouchEvent:MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.e("activity dispatchTouchEvent:MotionEvent.ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.e("activity dispatchTouchEvent:MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.e("activity dispatchTouchEvent:MotionEvent.ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.e("activity onTouchEvent:MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.e("activity onTouchEvent:MotionEvent.ACTION_UP");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.e("activity onTouchEvent:MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                LogUtil.e("activity onTouchEvent:MotionEvent.ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.my_tv) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    LogUtil.e("textView onTouch:MotionEvent.ACTION_DOWN");
                    break;
                case MotionEvent.ACTION_MOVE:
                    LogUtil.e("textView onTouch:MotionEvent.ACTION_MOVE");
                    break;
                case MotionEvent.ACTION_UP:
                    LogUtil.e("textView onTouch:MotionEvent.ACTION_UP");
                    break;
            }
        }
// true 将不会往下再传递 也就是onclick
        return false;
    }

    @Override
    public void onClick(View v) {
        LogUtil.e("textView:onclick");
    }
}
