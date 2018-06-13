package com.zfg.test;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.didi.virtualapk.PluginManager;
import com.facebook.stetho.Stetho;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by zfg on 2018/5/7
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        bug收集
//        CrashReport.initCrashReport(getApplicationContext(), "5ba10b0624", false);
//        测试
        Stetho.initializeWithDefaults(this);
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();
            // 打印日志
            ARouter.openDebug();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
    }
}
