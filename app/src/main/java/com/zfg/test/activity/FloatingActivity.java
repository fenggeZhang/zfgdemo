package com.zfg.test.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zfg.test.MainActivity;
import com.zfg.test.R;

/**
 * 悬浮按钮
 */
public class FloatingActivity extends AppCompatActivity {
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating);
        initView();

    }

    private void initView() {
        mFloatingActionButton = findViewById(R.id.float_btn);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                悬浮得点击事件
                /**
                 Snackbar.LENGTH_SHORT// 短时间显示，然后自动取消
                 Snackbar.LENGTH_LONG// 长时间显示，然后自动取消
                 Snackbar.LENGTH_INDEFINITE// 不消失显示，除非手动取消
                 当然我们也可以去更改SnackBar的布局，只不过我个人认为没必要，毕竟这只是一个轻量级的提示控件，
                 如果想实现更复杂的效果，dialog和popupwindow是不错的选择~~
                 */
                Snackbar.make(v, "要进行操作", Snackbar.LENGTH_SHORT)
                        .setAction("撤销", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(FloatingActivity.this, "撤销了", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
