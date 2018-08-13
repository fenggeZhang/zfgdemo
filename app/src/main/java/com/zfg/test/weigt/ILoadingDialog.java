package com.zfg.test.weigt;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zfg.test.R;


public class ILoadingDialog extends Dialog {

    private Context context;

    private Animation loadingAnimation;

    public ILoadingDialog(Context context) {
        super(context);
        this.context = context;
    }

    public ILoadingDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    private ImageView mLoadingIv;

    public static class Builder {
        private Context context;
        private String message;
        private View contentView;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * Set the Dialog message from resource
         *
         * @param message
         * @return
         */
        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        public ILoadingDialog create() {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final ILoadingDialog dialog = new ILoadingDialog(context, R.style.loading_dialog_style);
            // 初始化加载动画
            dialog.loadingAnimation = AnimationUtils.loadAnimation(context, R.anim.loading_animation);
            //初始化加载界面
            View rootView = inflater.inflate(R.layout.dialog_loading, null);
            //初始化加载ImageView
            dialog.mLoadingIv = rootView.findViewById(R.id.loading_iv);
            dialog.addContentView(rootView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            // 设置消息Message
            if (message != null) {
                TextView textView = rootView.findViewById(R.id.loading_message_tv);
                textView.setText(message);
            } else if (contentView != null) {
                LinearLayout linearLayout = rootView.findViewById(R.id.dialog_layout);
                linearLayout.removeAllViews();
                linearLayout.addView(contentView,
                        new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            }
            return dialog;
        }

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (mLoadingIv == null || loadingAnimation == null) {
            return;
        }
        if (hasFocus) {
            // 使用ImageView显示动画
            mLoadingIv.startAnimation(loadingAnimation);
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (loadingAnimation != null) {
            mLoadingIv.clearAnimation();
        }
    }

    public void release() {
        if (mLoadingIv != null) {
            mLoadingIv = null;
        }
        if (loadingAnimation != null) {
            loadingAnimation.cancel();
            loadingAnimation = null;
        }
    }
}