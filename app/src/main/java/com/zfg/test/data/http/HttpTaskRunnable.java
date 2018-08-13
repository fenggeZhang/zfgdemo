package com.zfg.test.data.http;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.zfg.test.data.http.bean.BaseEntity;


/**
 * Created by xiaote on 2017/1/13.
 */

public class HttpTaskRunnable implements Runnable {
    private int taskId;
    private HttpCallback callback;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (callback != null) {
                callback.onTaskComplete(msg.what, (BaseEntity<?>) msg.obj);
            }
        }
    };

    public HttpTaskRunnable(int taskId, HttpCallback callback) {
        this.taskId = taskId;
        this.callback = callback;
        this.callback.onTaskStart(taskId);
    }

    @Override
    public void run() {
        if (!Thread.interrupted()) {
            BaseEntity<?> result = callback.onTaskInBackground(taskId, null);
            if (Thread.interrupted()) {
                return;
            }
            handler.removeMessages(taskId);
            Message msg = handler.obtainMessage(taskId);
            msg.obj = result;
            msg.sendToTarget();
        }
    }
}
