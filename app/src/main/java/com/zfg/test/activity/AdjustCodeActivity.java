package com.zfg.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zfg.test.R;
import com.zfg.test.utils.CodeUtils;
import com.zfg.test.weigt.VerifyCode;

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
        mVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVerifyCode.setImageBitmap(CodeUtils.getInstance().createBitmap());
            }
        });
    }
}
