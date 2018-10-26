package com.zfg.mvparmstest.ccdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponent;

/**
 * Created by zfg on 2018/10/24
 */
public class MainComponent implements IComponent {
    @Override
    public String getName() {
        return "MainComponent";
    }

    @Override
    public boolean onCall(CC cc) {
        String actionName = cc.getActionName();
        switch (actionName) {
            case "showActivityA":
                openActivity(cc);
                break;
            default:
                //这个逻辑分支上没有调用CC.sendCCResult(...),是一种错误的示例
                //并且方法的返回值为false，代表不会异步调用CC.sendCCResult(...)
                //在LocalCCInterceptor中将会返回错误码为-10的CCResult
                break;
        }
        return false;
    }

    private void openActivity(CC cc) {
        Context context = cc.getContext();
        Intent intent = new Intent(context, MainActivity.class);
        if (!(context instanceof Activity)) {
            //调用方没有设置context或app间组件跳转，context为application
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
        //发送组件调用的结果（返回信息）
        CC.sendCCResult(cc.getCallId(), CCResult.success());
        //返回值说明
        // false: 组件同步实现（onCall方法执行完之前会将执行结果CCResult发送给CC）
        // true: 组件异步实现（onCall方法执行完之后再将CCResult发送给CC，CC会持续等待组件调用CC.sendCCResult发送的结果，直至超时）
      /*
        CCUtil.navigateTo(cc, MainActivity.class);
        CC.sendCCResult(cc.getCallId(), CCResult.success());*/
    }
}
