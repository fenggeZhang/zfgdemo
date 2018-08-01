package com.zfg.test.activity;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zfg.test.R;

import java.lang.ref.WeakReference;

/**
 * 弱引用，例子
 */
public class WeakSefActivity extends AppCompatActivity {
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weak_sef);

//        mHandler=new GestureHandler(bitmap);
        use();
    }

    private void use() {
        boolean hadTapMessage = mHandler.hasMessages(11);
        if (hadTapMessage) {
            mHandler.removeMessages(11);
//            结果处理
        } else {
            mHandler.sendEmptyMessageDelayed(11, 350);
        }
    }

    private class GestureHandler extends Handler {
        WeakReference<Bitmap> mWeakReference;

        GestureHandler(Bitmap weakReference) {
            mWeakReference = new WeakReference<>(weakReference);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mWeakReference.get() != null) {
                Bitmap bitmap = mWeakReference.get();
                switch (msg.what) {
                    case 11:
//                       相应的操作
                        break;
                    default:
                        throw new RuntimeException("Unknown message " + msg); //never
                }
            }
        }
    }
}
