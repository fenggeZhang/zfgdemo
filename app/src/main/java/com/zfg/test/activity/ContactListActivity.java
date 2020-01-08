package com.zfg.test.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PixelFormat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.ClassicRecyclerAdapter;
import com.zfg.test.entity.ClassicBean;
import com.zfg.test.weigt.LocationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static com.zfg.test.adapter.ClassicRecyclerAdapter.TYPE_LEVEL_0;
import static com.zfg.test.adapter.ClassicRecyclerAdapter.TYPE_LEVEL_1;

public class ContactListActivity extends BaseActivity {
    private LocationBarView mLocationBarView;
    private RecyclerView mRecyclerView;
    private TextView overlay;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    ;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contact_list;
    }

    @Override
    protected void setupView() {
        initOverlay();
        mRecyclerView = findViewById(R.id.content_rv);
        mLocationBarView = findViewById(R.id.bar_view);
    }

    @Override
    protected void initData() {
        List<ClassicBean> classicBeans = new ArrayList<>();
        classicBeans.add(new ClassicBean("一汽奥迪", TYPE_LEVEL_0));
        classicBeans.add(new ClassicBean("A3", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("A4", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("A4L", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("A6", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("Q3", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("Q5", TYPE_LEVEL_1));

        classicBeans.add(new ClassicBean("进口奥迪", TYPE_LEVEL_0));
        classicBeans.add(new ClassicBean("A3", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("A4", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("A4L", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("A6", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("Q3", TYPE_LEVEL_1));
        classicBeans.add(new ClassicBean("Q5", TYPE_LEVEL_1));

        ClassicRecyclerAdapter adapter = new ClassicRecyclerAdapter(classicBeans);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * 初始化拼音首字母弹出提示框
     */
    private void initOverlay() {
        LayoutInflater inflater = LayoutInflater.from(this);
        overlay = (TextView) inflater.inflate(R.layout.overlay_tv_dialog, null);
        overlay.setVisibility(View.INVISIBLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        WindowManager windowManager = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.addView(overlay, lp);
    }

    @Override
    protected void addListener() {
        mLocationBarView.setOnTouchLitterChangedListener(new LocationBarView.OnTouchLetterChangedListener() {
            @Override
            public void touchLetterChanged(String s) {
                if (!TextUtils.isEmpty(s)) {
                    overlay.setText(s);
                    overlay.setVisibility(View.VISIBLE);
                    test();
                }
            }
        });
    }

    @SuppressLint("AutoDispose")
    private void test() {
        DisposableObserver<Long> disposableObserver = getObserver();
        Observable.timer(1000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(disposableObserver);
        mCompositeDisposable.add(disposableObserver);

     /*   mCompositeDisposable.add(Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver()));*/
    }

    private DisposableObserver getObserver() {
        DisposableObserver disposableObserver = new DisposableObserver<Object>() {
            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onComplete() {
                overlay.setVisibility(View.GONE);
            }

            @Override
            public void onError(Throwable e) {

            }
        };

        return disposableObserver;
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
