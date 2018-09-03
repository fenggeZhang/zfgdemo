package com.zfg.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zfg.test.R;
import com.zfg.test.utils.LogUtil;

public class IntentAActivity extends AppCompatActivity {
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_a);
        mEditText = findViewById(R.id.data_et);
        LogUtil.e("A：：onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.e("A：：onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.e("A：：onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.e("A：：onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e("A：：onDestroy");
    }

    public void start(View view) {
        Intent intent = new Intent(this, IntentBActivity.class);
        startActivityForResult(intent, 111);
    }

    public void back(View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == 100) {
            mEditText.setText(data.getStringExtra("data"));
        }
    }
}
