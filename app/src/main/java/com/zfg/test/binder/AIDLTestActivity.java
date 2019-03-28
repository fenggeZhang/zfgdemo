package com.zfg.test.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.LogUtil;
import com.zfg.test.utils.ToastUtil;
import com.zfg.test.utils.ToastUtils;

import java.util.List;

public class AIDLTestActivity extends BaseActivity {
    private BookManager mBookManager;
    private List<Book> mBooks;
    //    标志当前与服务器连接状况得布尔值，false为未连接 true为连接中
    private boolean mBound = false;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_aidltest;
    }

    @Override
    protected void setupView() {
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBound) {
//            没有连接  尝试连接
                    attempToBindService();
                    ToastUtils.show(AIDLTestActivity.this, "当前服务器处于未连接状态，正在尝试重连，请稍后重试！");
                }
                if (mBookManager == null)
                    return;

                Book book = new Book();
                book.setBookId(11);
                book.setBookName("《JVM深入学习》");
                try {
                    mBookManager.addBook(book);
                    LogUtil.e(book.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
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

   /* public void addBook(View view) {
        if (!mBound) {
//            没有连接  尝试连接
            attempToBindService();
            ToastUtils.show(this, "当前服务器处于未连接状态，正在尝试重连，请稍后重试！");
        }
        if (mBookManager == null)
            return;

        Book book = new Book();
        book.setBookId(11);
        book.setBookName("《JVM深入学习》");
        try {
            mBookManager.addBook(book);
            LogUtil.e(book.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 尝试与服务器建立连接
     */
    private void attempToBindService() {
        Intent intent = new Intent();
        intent.setAction("com.zfg.test.binder");
        intent.setPackage("com.zfg.test");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBookManager = BookManager.Stub.asInterface(service);
            mBound = true;
            if (mBookManager == null) {
                try {
                    mBooks = mBookManager.getBookList();
                    LogUtil.e("连接：：" + mBooks.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        if (!mBound) {
            attempToBindService();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mServiceConnection);
            mBound = false;
        }
    }
}
