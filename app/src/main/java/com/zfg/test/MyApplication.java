package com.zfg.test;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.billy.cc.core.component.CC;
import com.didi.virtualapk.PluginManager;
import com.facebook.stetho.Stetho;
import com.tencent.bugly.crashreport.CrashReport;
import com.zhouyou.http.EasyHttp;

import cn.ljuns.logcollector.LogCollector;
import skin.support.SkinCompatManager;

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
        initSkin();
        initFitXY();
        initLog();
        initCc();
        initRxEasy();
    }

    private void initRxEasy() {
        EasyHttp.init(this);//默认初始化
    }

    private void initCc() {
        CC.enableVerboseLog(true);//上线要设置为false  默认也是false
        CC.enableDebug(true);
        CC.enableRemoteCC(true);
    }

    /**
     * 初始化收集日志
     */
    private void initLog() {
        LogCollector.getInstance(this).start();
    }

    private void initFitXY() {
        /**
         * 以下是 AndroidAutoSize 可以自定义的参数, {@link AutoSizeConfig} 的每个方法的注释都写的很详细
         * 使用前请一定记得跳进源码，查看方法的注释, 下面的注释只是简单描述!!!
         */
      /*  AutoSizeConfig.getInstance()

                //是否打印 AutoSize 的内部日志, 默认为 true, 如果您不想 AutoSize 打印日志, 则请设置为 false
                .setLog(false)

                //是否使用设备的实际尺寸做适配, 默认为 false, 如果设置为 false, 在以屏幕高度为基准进行适配时
                //AutoSize 会将屏幕总高度减去状态栏高度来做适配, 如果设备上有导航栏还会减去导航栏的高度
                //设置为 true 则使用设备的实际屏幕高度, 不会减去状态栏以及导航栏高度
                .setUseDeviceSize(true)

                //是否全局按照宽度进行等比例适配, 默认为 true, 如果设置为 false, AutoSize 会全局按照高度进行适配
                .setBaseOnWidth(false);*/

        //设置屏幕适配逻辑策略类, 一般不用设置, 使用框架默认的就好
//                .setAutoAdaptStrategy(new AutoAdaptStrategy());
    }

    /**
     * 换肤 初始化
     */
    private void initSkin() {
        SkinCompatManager.withoutActivity(this)                         // 基础控件换肤初始化
//                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
//                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
//                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(true)                     // 关闭状态栏换肤，默认打开[可选]
                .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
    }
}
