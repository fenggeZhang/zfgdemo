package com.zfg.test.activity.rxjava;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zfg on 2019/4/19
 * 线程调度  Scheduler
 */
@SuppressLint("CheckResult")
public class RxjavaSchedulerTest {
    public static void main(String[] args) {
//        observableCreate();
//        observableJust();
//        observableCreate1();
//        observableMap();
        observableFilterMap();
    }

    /**
     * 将一个发射数据的Observable变换为多个Observable，然后将他们发射的数据合并之后放进一个单独的Observable
     * 适用于嵌套请求
     */
    private static void observableFilterMap() {
        User user = new User();
        user.userName = "lisa";
        user.addresses = new ArrayList<>();


        User.Address address = new User.Address();
        address.street = "ren min road";
        address.city = "zheng zhou";
        user.addresses.add(address);

        User.Address address1 = new User.Address();
        address1.street = "nan yang road";
        address1.city = "zheng zhou";
        user.addresses.add(address1);

        Observable.just(user).
                flatMap(new Function<User, ObservableSource<User.Address>>() {
                    @Override
                    public ObservableSource<User.Address> apply(User user) throws Exception {
                        return Observable.fromIterable(user.addresses);
                    }
                }).
                subscribe(new Consumer<User.Address>() {
                    @Override
                    public void accept(User.Address address) throws Exception {
                        System.out.println(address.street);
                    }
                });
    }

    /**
     * map操作符 对原始Observable发射的每一项数据应用一个你选择的函数，然后返回一个发射这些结果的Observable
     * <p>
     * 做了两次转换 第一次把“HEELO”转换为“hello”,第二次转换是在字符串“hello”的后面增加新的字符串“ world”
     */
    private static void observableMap() {
        Observable.just("HELLO").
                map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
//                将大写字母转换为小写
                        return s.toLowerCase();
                    }
                }).
                map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s + " world";
                    }
                }).
                subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }

    private static void observableCreate1() {
        Observable.
                create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext("hello");
                        emitter.onNext("world");
                    }
                }).
                subscribeOn(Schedulers.newThread()).
                subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }

    private static void observableJust() {
        Observable.just("aaa", "bbb").observeOn(Schedulers.newThread()).
                map(new Function<String, String>() {
                    @Override
                    public String apply(String s) throws Exception {
                        return s.toUpperCase();
                    }
                }).
                subscribeOn(Schedulers.single()).
                observeOn(Schedulers.io()).
                subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }


    private static void observableCreate() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("hello");
                emitter.onNext("world");
            }
        }).observeOn(Schedulers.io())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("S:" + s);
                    }
                });
    }

    static class User {
        public String userName;
        public List<Address> addresses;

        public static class Address {
            public String street;
            public String city;
        }
    }
}
