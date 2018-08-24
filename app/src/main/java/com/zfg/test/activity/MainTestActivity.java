package com.zfg.test.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.zfg.test.R;
import com.zfg.test.fragment.AFragment;
import com.zfg.test.fragment.BFragment;
import com.zfg.test.utils.ToastUtils;
import com.zfg.test.weigt.helper.BottomNavigationViewHelper;

import java.lang.annotation.Retention;

public class MainTestActivity extends AppCompatActivity {
    private int FRAGMENT_ONE = 1;
    private int FRAGMENT_TWO = 2;
    private int FRAGMENT_THREE = 3;

    private Toolbar mToolbar;
    private AFragment mAFragment;
    private BFragment mBFragment;
    private NavigationView mNavView;
    private DrawerLayout mDrawerLayout;
    private BottomNavigationView mBottomNavigationView;
    private CoordinatorLayout my_CoordinatorLayout;

    private int mIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        initView();
        initDrawerLayout();

    }

    private void initDrawerLayout() {
//        内容和侧滑布局同时向右滑动
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                my_CoordinatorLayout.layout(mNavView.getRight(), 0, mNavView.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        mNavView = findViewById(R.id.nav_view);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        my_CoordinatorLayout = findViewById(R.id.my_CoordinatorLayout);
        mToolbar.setTitle(getString(R.string.app_name));//设置标题
//        mToolbar.setNavigationIcon(); //设置左侧的图标
        setSupportActionBar(mToolbar);

        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        showFragment(FRAGMENT_ONE);
                        return true;
                    case R.id.action_knowledge_system:
                        showFragment(FRAGMENT_TWO);
                        return true;
                    case R.id.action_navigation:
                        return true;
                    case R.id.action_project:
                        return true;
                    default:
                        return false;
                }
            }
        });
        showFragment(mIndex);
       /* mBottomNavigationView.getSelectedItemId() = R.id.action_home;
        selectedItemId = R.id.action_home*/
    }

    private void showFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        mIndex = index;
        switch (index) {
            case 1: {
                mToolbar.setTitle(getString(R.string.app_name));
                if (mAFragment == null) {
                    mAFragment = new AFragment();
                    transaction.add(R.id.container, mAFragment, "one");
                } else {
                    transaction.show(mAFragment);
                }
            }
            break;
            case 2: {
                mToolbar.setTitle(getString(R.string.app_name));
                if (mBFragment == null) {
                    mBFragment = new BFragment();
                    transaction.add(R.id.container, mBFragment, "two");
                } else {
                    transaction.show(mBFragment);
                }
            }
            break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mAFragment != null) {
            transaction.hide(mAFragment);
        }
        if (mBFragment != null) {
            transaction.hide(mBFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                ToastUtils.show(this, "搜索");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
