package com.zfg.test.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.QrCodeUtil;

public class QrCodeActivity extends BaseActivity {
    private ImageView mImageView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_qr_code;
    }

    @Override
    protected void setupView() {
        mImageView = findViewById(R.id.code_iv);
    }

    @Override
    protected void initData() {
        String content = "这是个有logo的二维码！！";
        Bitmap bitmap = QrCodeUtil.createQRCodeWithLogo(content, 500,
                BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        mImageView.setImageBitmap(bitmap);

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
