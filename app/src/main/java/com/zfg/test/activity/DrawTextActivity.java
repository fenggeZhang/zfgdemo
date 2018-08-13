package com.zfg.test.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.zfg.test.R;
import com.zfg.test.weigt.DrawTextView;

public class DrawTextActivity extends AppCompatActivity {
    private DrawTextView mDrawTextView;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_text);
        mDrawTextView = findViewById(R.id.draw_view);
        mImageView = findViewById(R.id.rresult_iv);
    }

    public void clear(View view) {
//        清空
        mDrawTextView.clearPath();
    }

    public void save(View view) {
        Bitmap bitmap = mDrawTextView.getImage();
        if (bitmap != null) {
            mImageView.setImageBitmap(mDrawTextView.getImage());
        }
    }
}
