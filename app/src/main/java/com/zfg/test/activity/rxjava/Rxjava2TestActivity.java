package com.zfg.test.activity.rxjava;

import android.Manifest;
import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zhouyou.http.EasyHttp;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class Rxjava2TestActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava2_test;
    }

    @Override
    protected void setupView() {
    }

    @Override
    protected void initData() {
//        observabletest();
//        observableHello();
//        flowableTest();

//        do 操作符
//        doTest();
        System.out.println("---------------------------");
//        completable 结合 andthen操作符
//        andThen();

        schedulerstest();

//        源码分析
        mapYuanMa();
    }

    /**
     * map源码
     */
    private void mapYuanMa() {

    }

    /**
     * 05-21 17:17:21.166 4893-11956/com.zfg.test D/wyz: doOnSubscribe2:RxCachedThreadScheduler-5
     * 05-21 17:17:21.166 4893-4893/com.zfg.test D/wyz: doOnSubscribe1:main
     * 05-21 17:17:21.166 4893-11956/com.zfg.test D/wyz: create:RxCachedThreadScheduler-5
     * 05-21 17:17:21.166 4893-11956/com.zfg.test D/wyz: map1:RxCachedThreadScheduler-5
     * 05-21 17:17:21.176 4893-11957/com.zfg.test D/wyz: flatMap:RxCachedThreadScheduler-6
     * 05-21 17:17:21.196 4893-4893/com.zfg.test D/wyz: 执行完毕:main
     */
    private void schedulerstest() {
        Observable
                .create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                        Log.d("wyz", "create:" + Thread.currentThread().getName());
                        e.onNext(1);
                    }
                })
                .subscribeOn(Schedulers.io())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        Log.d("wyz", "map1:" + Thread.currentThread().getName());
                        return integer;
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.d("wyz", "doOnSubscribe1:" + Thread.currentThread().getName());
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        Log.d("wyz", "doOnSubscribe2:" + Thread.currentThread().getName());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
                        Log.d("wyz", "flatMap:" + Thread.currentThread().getName());
                        return Observable.fromArray(integer);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.d("wyz", "执行完毕:" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @SuppressLint("CheckResult")
    private void andThen() {
        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(CompletableEmitter emitter) throws Exception {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    emitter.onComplete();
                } catch (InterruptedException e) {
                    emitter.onError(e);
                }
            }
        }).andThen(Observable.range(1, 10)).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
    }

    /**
     * rxjava得内部数据流向
     * <p>
     * <p>
     * *
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doOnSubscribe
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doOnLifecycle accept
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doOnNextHello
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doOnEach
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: subscribe 收到消息Hello
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doAfterNextHello
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doOnComplete
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doOnEach
     * 04-18 16:03:38.049 2943-2943/com.zfg.test I/System.out: doFinally
     */
    @SuppressLint("CheckResult")
    private void doTest() {
        Observable.just("Hello").
                doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("doOnNext" + s);
                    }
                })
                .doAfterNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("doAfterNext" + s);
                    }
                }).
                doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doOnComplete");
                    }
                }).
                doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnSubscribe");
                    }
                }).
                doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doAfterTerminate");
                    }
                }).
                doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doFinally");
                    }
                }).
                doOnEach(new Consumer<Notification<String>>() {
                    @Override
                    public void accept(Notification<String> stringNotification) throws Exception {
                        System.out.println("doOnEach");
                    }
                }).
                doOnLifecycle(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnLifecycle accept");
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doOnLifecycle Action ");
                    }
                }).
                subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("subscribe 收到消息" + s);
                    }
                });
    }

    @SuppressLint("CheckResult")
    private void observableHello() {
        Observable.create((ObservableOnSubscribe<String>) emitter -> emitter.onNext("hello world")).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
        Observable.just("hello world").subscribe(System.out::println);
    }

    private void observabletest() {
     /*   Observable.fromIterable(getHotelsFromServer()).
                flatMap((Function<HotelData, ObservableSource<RoomData>>) objects -> Observable.fromIterable(objects.mRoomData)).
                filter(new Predicate<RoomData>() {
                    @Override
                    public boolean test(RoomData r) throws Exception {
                        return false;
                    }
                }).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe((Consumer<RoomData>) room -> {

                });*/
    }

    private HotelData getHotelsFromServer() {
        HotelData hotel = new HotelData();
        List<RoomData> rooms = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RoomData room = new RoomData();
            room.price = i;
            rooms.add(room);
        }
        hotel.mRoomData = rooms;
        return hotel;
    }

    private void flowableTest() {
        Flowable.
                create(new FlowableOnSubscribe<String>() {
                    @Override
                    public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                        if (!emitter.isCancelled()) {
                            emitter.onNext("1");
                            emitter.onNext("2");
                            emitter.onComplete();
                        }
                    }
                }, BackpressureStrategy.DROP).
                map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return Integer.parseInt(s);
                    }
                }).
                subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext:" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }

    private class HotelData implements Iterable {
        private List<RoomData> mRoomData;


        @NonNull
        @Override
        public Iterator iterator() {
            return (Iterator) new HotelData();
        }
    }

    private class RoomData {
        private String name;
        private int price;
    }
}
