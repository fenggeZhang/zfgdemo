package com.zfg.test.weigt;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.zfg.test.R;

/**
 * Created by zfg on 2018/11/27
 */
public class MyPopuWindow {
    private View mView;
    private View mBelowView;
    private Context mContext;
    PopupWindow mPopupWindow;
    private View mEmptyView;

    public MyPopuWindow(Context context, View view, View belowView) {
        this.mContext = context;
        this.mView = view;
        this.mBelowView = belowView;
        initPopupWindow();
    }

    private void initPopupWindow() {
        mPopupWindow = new PopupWindow(mView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
        mEmptyView = mView.findViewById(R.id.emptyView);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
//        mPopupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        mEmptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
    }

    public void show() {
        if (Build.VERSION.SDK_INT > 24) {
            Rect rect = new Rect();
            mBelowView.getGlobalVisibleRect(rect);
            int h = mBelowView.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            mPopupWindow.setHeight(h);
        }
        mPopupWindow.showAsDropDown(mBelowView);
    }
}
