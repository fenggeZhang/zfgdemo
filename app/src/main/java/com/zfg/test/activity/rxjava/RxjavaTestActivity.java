package com.zfg.test.activity.rxjava;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.text.format.Time;
import android.view.View;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.LogUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxjavaTestActivity extends BaseActivity {
    private TextView mTextView;
    private int sencond = 60;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava_test;
    }

    @Override
    protected void setupView() {
        mTextView = findViewById(R.id.timer_tv);
    }

    @Override
    protected void initData() {
//        test1();
//        test2();
//        test3();
//        testFrom();
        testJust();
//        testInterval();

        testJust1();
    }

    private void testJust1() {
//判断是否 ok
        Maybe.just(isOk())
//                可能涉及到IO操作 放在子线程
                .subscribeOn(Schedulers.newThread())
//                取回结果传到主进程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Boolean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        if (aBoolean) {
                            LogUtil.e("ok");
                        } else {
                            LogUtil.e("no");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private boolean isOk() {

        Random random = new Random();
        int x = random.nextInt();
        if (x / 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 无限次循环  每隔10秒执行一次
     * 加上take（5）  就会限制次数 执行5次
     */
    private void testInterval() {
      /*  Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(60)
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.e("完成了");
                        sencond = 60;
                        mTextView.setText("重新开始");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("Error" + e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        sencond--;
                        mTextView.setText(sencond + "s");
                        LogUtil.e("Next" + aLong);
                    }
                });*/
    }

    /**
     * 11-22 13:44:18.209 3842-3842/com.zfg.test.debug E/LogUtil:  数据：1
     * 11-22 13:44:18.209 3842-3842/com.zfg.test.debug E/LogUtil: 数据：2
     * 11-22 13:44:18.209 3842-3842/com.zfg.test.debug E/LogUtil: 数据：3
     * 11-22 13:44:18.219 3842-3842/com.zfg.test.debug E/LogUtil: onCompleted
     */
    private void testJust() {
        Observable.just(1, 2, 3)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.e("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("Error:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        LogUtil.e("数据：" + integer);
                    }
                });
    }

    /**
     * 输出结果  循环输出items 得值 然后 输出完成！
     */
    private void testFrom() {
        Integer[] items = {11, 5, 7, 80, 44};
        Observable observable = Observable.from(items);
        observable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer item) {
                LogUtil.e("zfg::" + item);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                LogUtil.e("error:" + throwable.getMessage());
            }
        }, new Action0() {
            @Override
            public void call() {
                LogUtil.e("完成！");
            }
        });

    }

/*    private void test3() {

        Observable.just(getFilePath())
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
//                使用map操作符 实现数据类型转换
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
//                        显然这个方法是非常耗时得操作
                        return createBitmapFromPath(s);
                    }
                })
                .filter(new Func1<Bitmap, Boolean>() {
                    @Override
                    public Boolean call(Bitmap bitmap) {
                        return bitmap != null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bitmap>() {
//                    创建观察者 作为事件传递得处理事件
                    @Override
                    public void onCompleted() {
                        LogUtil.e("结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        //出现错误就会调用这个方法
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
//                        处理事件
                        showData();
                    }
                });

    }*/

    @SuppressLint("CheckResult")
    private void test2() {
      /*  Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("Hello World!");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                LogUtil.e("输出结果" + s);
            }
        });*/

    }

    private void test1() {
      /*  Observable.fromIterable(getHotel())
                .flatMap(new Function<Hotel, ObservableSource<Room>>() {
                    @Override
                    public ObservableSource<Room> apply(Hotel hotel) throws Exception {
                        return Observable.fromIterable(hotel.rooms);
                    }
                })
                .filter(new Predicate<Room>() {
                    @Override
                    public boolean test(Room r) throws Exception {
                        return r.price >= 500;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<Room>) room -> showRoomUI(room));*/
    }

    private Object getHotel() {
        return new Object();
    }

    private void showRoomUI(Room room) {

    }

    @Override
    protected void addListener() {
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sencond >= 60) {
                    testInterval();
                }
            }
        });
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
