package com.zfg.test.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/11.
 */

public class ToastUtil {

    /**
     * 可以在多线程里运行的toast
     */
    private static volatile Toast mToast;
    private static final Object lock = new Object();
    private static Context context;

    public static void init(Context con) {
        context = con;
    }

    /**
     * 默认位置方法。
     * @param msg 需要吐司展示的内容。
     */
    public static void show(String msg) {
        initToast(msg, context, true, 0);
    }

    /**
     * 根据需求设置吐司位置。
     * @param msg 需要吐司展示的内容。
     * @param toastGravity 吐司位置设置。Gravity.BOTTOM、Gravity.CENTER等。
     */
    public static void initToast(String msg, int toastGravity) {
        initToast(msg, context, true, toastGravity);
    }

    /**
     * 默认位置方法
     * @param resId 需要吐司展示的资源ID。
     */
    public static void initToast(int resId) {
        initToast(context.getString(resId), context, true, 0);
    }

    /**
     * 根据需求设置吐司位置。
     * @param resId 需要吐司展示的内容。
     * @param toastGravity 吐司位置设置。Gravity.BOTTOM、Gravity.CENTER等。
     */
    public static void initToast(int resId ,int toastGravity) {
        initToast(context.getString(resId), context, true, toastGravity);
    }

    public static void initToast(String msg, Context context, boolean isSingleton, int toastGravity) {
        if (mToast != null && isSingleton) {
            mToast.setText(msg);
        } else {
            synchronized (lock) {
                mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
            }
        }

        if (toastGravity != 0 && Gravity.BOTTOM != toastGravity) {

            mToast.setGravity(toastGravity, 0, 0);
        } else {
            mToast.setGravity(Gravity.BOTTOM, 0, 90);//默认显示位置

        }
        mToast.show();
    }

    //可以设置toast的位置
    public static void setGravity(int gravity, int xOffset, int yOffset) {
        mToast.setGravity(gravity, xOffset, yOffset);
    }

    //可以自定义toast的view
    public void setView(View view) {
        mToast.setView(view);
    }


    /**
     * 当你在线程中使用toast时，请使用这个方法(可以控制显示多长时间)
     */
    public static void showInThread(@NonNull final Context context, final String msg, final int length) {
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();//先移除
                Toast.makeText(context, msg, length).show();
                Looper.loop();// 进入loop中的循环，查看消息队列
            }
        }.start();
    }

    /**
     * 以下全部代码为一个整体，可以控制显示时间的Toast
     */
    private static Handler mHandler = null;
    private static int duration = 0;
    private static int currDuration = 0;
    private static final int DEFAULT = 2000;

    public static void showByDuration(Context context, String msg, int duration) {
        duration = duration;
        currDuration = DEFAULT;
        mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        mHandler = new Handler(context.getMainLooper());
        mHandler.post(mToastThread);
    }

    private static Runnable mToastThread = new Runnable() {

        public void run() {
            mToast.show();
            mHandler.postDelayed(mToastThread, DEFAULT);// 每隔2秒显示一次
            if (duration != 0) {
                if (currDuration <= duration) {
                    currDuration += DEFAULT;
                } else {
                    cancel();
                }
            }
        }
    };

    private static void cancel() {
        mHandler.removeCallbacks(mToastThread);// 先把显示线程删除
        mToast.cancel();// 把最后一个线程的显示效果cancel掉，就一了百了了
        currDuration = DEFAULT;
    }


}
