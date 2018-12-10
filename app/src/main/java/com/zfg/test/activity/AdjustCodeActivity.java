package com.zfg.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.zfg.test.R;
import com.zfg.test.utils.CodeUtils;

/**
 * 验证码
 */
public class AdjustCodeActivity extends AppCompatActivity {

    private ImageView mVerifyCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_code);
        mVerifyCode = findViewById(R.id.verify_codeview);
        mVerifyCode.setImageBitmap(CodeUtils.getInstance().createBitmap());
        mVerifyCode.setOnClickListener(v -> mVerifyCode.setImageBitmap(CodeUtils.getInstance().createBitmap()));
    }
}
