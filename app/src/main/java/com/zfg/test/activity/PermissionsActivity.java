package com.zfg.test.activity;

import android.content.Intent;
import android.view.View;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

/**
 * 动态权限申请
 */
public class PermissionsActivity extends BaseActivity {

//    final RxPermissions rxPermissions = new RxPermissions(this); // where this is an Activity or Fragment instance

    @Override
    protected int getLayoutId() {
        return R.layout.activity_permissions;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }

    public void cream(View view) {

        Intent intent=new Intent();
        //保证与清单文件中设置的一致即可
        //通过setAction设置需要开启的Activity的动作为“android.media.action.IMAGE_CAPTURE”
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        //通过addCategory设置类别为"android.intent.category.DEFAULT"
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);

      /*  rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_CALENDAR, Manifest.permission.READ_CALL_LOG, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS, Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS
                )
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now
                        showToast("同意了？");
                    } else {
                        // Oups permission denied
                        showToast("拒绝了？");
                    }
                });*/
    }
}
