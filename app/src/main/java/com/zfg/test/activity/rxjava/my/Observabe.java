package com.zfg.test.activity.rxjava.my;


import android.os.Handler;

import com.zfg.test.R;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by zfg on 2019/5/21
 */
abstract class Observable<T> {
    public abstract void subscribe(Observer<T> observer);

    public static <T> Observable<T> create(Observable<T> observable) {
        return observable;
    }

    /**
     * 改变上个节点运行的线程
     *
     * @return
     */
    public Observable<T> subscribeOn() {
        return new Observable<T>() {
            @Override
            public void subscribe(final Observer<T> observer) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        Observable.this.subscribe(observer);
                    }
                }.start();
            }
        };
    }

    /**
     * 改变下一个节点运行的线程，在新的线程里
     *
     * @return
     */
    public Observable<T> observeOn() {
        return new Observable<T>() {
            @Override
            public void subscribe(Observer<T> observer) {
                Observable.this.subscribe(new Observer<T>() {

                    @Override
                    public void onNext(T t) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                observer.onNext(t);
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        };
    }


    public <R> Observable<R> flatMap(final Function<T, Observable<R>> function) {
        return new Observable<R>() {
            @Override
            public void subscribe(Observer<R> observer) {
                Observable.this.subscribe(new Observer<T>() {
                    @Override
                    public void onNext(T t) {
                        try {
                            Observable<R> observable = function.apply(t);
                            observable.subscribe(observer);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });
            }
        };
    }

    public <R> Observable<R> map(final Function<T, R> function) {
        return new Observable<R>() {
            @Override
            public void subscribe(Observer<R> observer) {
                Observable.this.subscribe(new Observer<T>() {
                    @Override
                    public void onNext(T t) {
                        try {
                            R r = function.apply(t);
                            observer.onNext(r);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onComplete() {
                        observer.onComplete();
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });
            }
        };
    }

    Handler handler = new Handler();
}
