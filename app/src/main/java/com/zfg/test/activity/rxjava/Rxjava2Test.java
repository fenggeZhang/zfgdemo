package com.zfg.test.activity.rxjava;

import android.annotation.SuppressLint;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Emitter;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by zfg on 2019/4/19
 */
@SuppressLint("CheckResult")
public class Rxjava2Test {
    public static void main(String[] strings) {
        create();
        just();
        from();
        repeat();
        interval();
        timer();
//        Assert.assertTrue("错误！", true);
    }

    /**
     * 延迟两秒 输出 hello timer
     */
    private static void timer() {
        io.reactivex.Observable.timer(2, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("hello timer");
            }
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个按固定时间间隔发射整数数列的observable  无限递增
     * <p>
     * 每隔1秒打印一个数字直到10秒后结束
     */
    private static void interval() {
        io.reactivex.Observable.interval(1, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println(aLong);
            }
        });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * repeat 创建一个发射特定数据重复多次的Observable
     * s=hello repeat
     * s=hello repeat
     * s=hello repeat
     * <p>
     * <p>
     * 还有两个操作符 repeatWhen repeatUntil  这两个是有条件地重复订阅
     */
    private static void repeat() {
        io.reactivex.Observable.just("hello repeat").repeat(3).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("s=" + s);
            }
        });
        System.out.println();
    }

    /**
     * from 可以将其他种类的对象和数据类型转换为observable
     */
    private static void from() {
        io.reactivex.Observable.fromArray("hello", "from", "zfg").
                subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
        System.out.println();

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            integers.add(i);
        }
        io.reactivex.Observable.fromIterable(integers).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("Error:" + throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("Sequence complete.");
            }
        });
        System.out.println();
    }

    /**
     * just 将一个或者多个对象转换成发射这个或这些对象的一个Observable
     * 单地原样发射 而不是跟from一样取出来逐个发射
     * 不接收 null 会提示空指针  也可以接收参数一个数组
     */

    private static void just() {
        io.reactivex.Observable.just("hello just").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
        System.out.println();
    }


    /**
     * 使用一个函数从开头创建一个observable
     * <p>
     * Next:0
     * Next:1
     * Next:2
     * Next:3
     * Next:4
     * Next:5
     * Next:6
     * Next:7
     * Next:8
     * Next:9
     * Sequence complete
     */
    private static void create() {
        io.reactivex.Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                先判断观察者 的isDisposed状态  发射数据
                try {
                    if (!emitter.isDisposed()) {
                        for (int i = 0; i < 10; i++) {
                            emitter.onNext(i);
                        }
                        emitter.onComplete();
                    }
                } catch (Exception e) {
                    emitter.onError(e);
                }

            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Next:" + integer);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("Error:" + throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                System.out.println("Sequence complete");
            }
        });
        System.out.println();
    }
}
