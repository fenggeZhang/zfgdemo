package com.zfg.test.weigt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zfg.test.R;

/**
 * Created by zfg on 2019/5/22
 */
public class EditLayout extends LinearLayout {
    EditText mEditText;

    public EditLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_edit_layout, this);
        mEditText = findViewById(R.id.content_et);
        ImageView imageView = findViewById(R.id.delete_iv);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(null);
            }
        });
    }

    public String getContent() {
        return mEditText.getText().toString().trim();
    }
}
