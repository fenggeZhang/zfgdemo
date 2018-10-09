package com.zfg.test.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zfg.test.R;

/**
 * 悬浮按钮
 * 根布局采用 CoordinatorLayout 代frameLayout 解决悬浮按钮被覆盖的问题
 * 使用coordian 可以自动向上移动
 */
public class FloatingActivity extends AppCompatActivity {
    private CoordinatorLayout mCoordinatorLayout;

    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating);
        initView();
        initTest();
        addListener();
    }

    private void addListener() {

    }

    private void initTest() {
    }

    private void initView() {
        mCoordinatorLayout = findViewById(R.id.content_layout);
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
