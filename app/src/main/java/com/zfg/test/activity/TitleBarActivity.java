package com.zfg.test.activity;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

import com.zfg.test.R;

public class TitleBarActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_bar);
        initView();
        initData();
    }

    private void initData() {
//        toolbar.setNavigationIcon(R.drawable.icon_back_pressed);
        /*//Palette用来更漂亮地展示配色

        */
        Palette.from(BitmapFactory.decodeResource(getResources(), R.drawable.title_bg)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@NonNull Palette palette) {
                int color = palette.getVibrantColor(getResources().getColor(R.color.title_top));
                collapsingToolbarLayout.setContentScrimColor(color);
                //因为我暂时没有找到比较好的透明状态栏来适配这一套效果布局。
                // 因此就直接替换掉StatusBar的颜色，这样其实也蛮好看的。
//                getWindow().setStatusBarColor(color);
            }
        });
        collapsingToolbarLayout.setTitle("我是一个标题啊哈哈哈");
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
        mCoordinatorLayout = findViewById(R.id.my_CoordinatorLayout);
    }
}
