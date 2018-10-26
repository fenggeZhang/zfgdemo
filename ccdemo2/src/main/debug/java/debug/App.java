package debug;

import android.app.Application;

import com.billy.cc.core.component.CC;

/**
 * Created by zfg on 2018/10/26
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CC.enableVerboseLog(true);//上线要设置为false  默认也是false
        CC.enableDebug(true);
        CC.enableRemoteCC(true);
    }
}
