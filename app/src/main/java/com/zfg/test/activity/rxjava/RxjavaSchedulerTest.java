package com.zfg.test.activity.rxjava;

import android.annotation.SuppressLint;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
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
//        observableFilterMap();

//        条件操作符 布尔操作符
//        observableAll();
//        observableContains();
        observableTackUntil();
    }

    /**
     * 当第二个得Observable发射了一项数据或者终止时，丢弃原始Observable发射得任何数据
     * <p>
     * 结果：
     * 1
     * 2
     * 3
     * 4
     * 5
     */
    private static void observableTackUntil() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9).takeUntil(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer == 5;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
    }

    /**
     * 判定一个Observable是否发射了一个特定得值
     */
    private static void observableContains() {
        Observable.just(2, 30, 22, 5, 60, 1).contains(22).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println("结果：" + aBoolean);
            }
        });
        Observable.just(2, 30, 22, 5, 60, 1).isEmpty().subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println("结果：" + aBoolean);
            }
        });
    }

    /**
     * 判断Observable发射得数据是否都满足某个条件
     * <p>
     * 数据是否都满足小于10  返回false
     */
    private static void observableAll() {
        Observable.just(1, 2, 3, 4, 5, 6, 10).all(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer < 10;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                System.out.println("结果：" + aBoolean);
            }
        });
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
