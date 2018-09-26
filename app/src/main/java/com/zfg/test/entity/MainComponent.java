package com.zfg.test.entity;

import com.zfg.test.activity.Dagger2Test1Activity;
import com.zfg.test.activity.Dagger2TestActivity;

import dagger.Component;

/**
 * Created by zfg on 2018/5/28
 */
@Component(modules=MainModule.class)
public interface MainComponent {
    void inject(Dagger2TestActivity mainActivity);
    void inject(Dagger2Test1Activity mainActivity);
}
