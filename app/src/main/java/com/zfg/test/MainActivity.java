package com.zfg.test;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.stetho.common.LogUtil;
import com.zfg.test.activity.AActivity;
import com.zfg.test.activity.AcmTestActivity;
import com.zfg.test.activity.AnimActivity;
import com.zfg.test.activity.BActivity;
import com.zfg.test.activity.BaseWebViewActivity;
import com.zfg.test.activity.Dagger2Test1Activity;
import com.zfg.test.activity.Dagger2TestActivity;
import com.zfg.test.activity.FragmentsActivity;
import com.zfg.test.activity.LinearLayoutActivity;
import com.zfg.test.activity.RetrofitTestActivity;
import com.zfg.test.activity.SearchActivity;
import com.zfg.test.adapter.DividerGridItemDecoration;
import com.zfg.test.adapter.MyAdapter;
import com.zfg.test.common.Contants;
import com.zfg.test.entitiy.TestBean;
import com.zfg.test.kotlintest.MainKotlin;
import com.zfg.test.utils.SizeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {
    private List<TestBean> mTestBeans;
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private Button mBtn, mApl;
    //剪切板管理工具类
    private ClipboardManager mClipboardManager;
    //剪切板Data对象
    private ClipData mClipData;
    HashMap<String, String> map = new HashMap<>();
    LinearLayout my_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        initData();
        initView();
        addListener();
    }

    private void addListener() {
        mMyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.e("zfg", "点击：" + position);
//                LogUtil.e("高度：" + mRecyclerView.getMeasuredHeight());
                switch (position) {
                    case 14:
                        startActivity(new Intent(MainActivity.this, MainKotlin.class));
                        break;
                    case 13:
                        ARouter.getInstance().build(Contants.START_AROUTER_ACTIVITY)
                                .withString("name","aa")
                                .navigation();
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this, FragmentsActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, RetrofitTestActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, AnimActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, BActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, AActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, Dagger2Test1Activity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, Dagger2TestActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, SearchActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, AcmTestActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, BaseWebViewActivity.class));
                        break;
                    case 1:
                        Log.e("zfg", "zzzz");
                        break;
                    case 0:
                        //GET贴板是否有内容
                        mClipData = mClipboardManager.getPrimaryClip();
                        //获取到内容
                        ClipData.Item item = mClipData.getItemAt(0);
                        String text = item.getText().toString();
                        Log.e("zfg", "剪切板::" + text);
                        Toast.makeText(getApplicationContext(), "粘贴成功！",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void initData() {
        map.put("1", "111");
        LogUtil.e("第一次：" + map.get("1"));
        map.put("1", "888");
        LogUtil.e("第二次：" + map.get("1"));
        mTestBeans = new ArrayList<>();
        mTestBeans.add(new TestBean("旋转"));
        mTestBeans.add(new TestBean("渐变"));
        mTestBeans.add(new TestBean("网页"));
        mTestBeans.add(new TestBean("排序"));
        mTestBeans.add(new TestBean("分隔符"));
        mTestBeans.add(new TestBean("搜索"));
        mTestBeans.add(new TestBean("注解"));
        mTestBeans.add(new TestBean("注解2"));
        mTestBeans.add(new TestBean("event数据"));
        mTestBeans.add(new TestBean("event数据1"));
        mTestBeans.add(new TestBean("动画"));
        mTestBeans.add(new TestBean("视觉图"));
        mTestBeans.add(new TestBean("测量高度"));
        mTestBeans.add(new TestBean("跳转"));
        mTestBeans.add(new TestBean("kotlin"));
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.my_recycler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(MainActivity.this));
        mMyAdapter = new MyAdapter(R.layout.my_test_item, mTestBeans);
        mRecyclerView.setAdapter(mMyAdapter);
        mBtn = findViewById(R.id.rotation_btn);
        mApl = findViewById(R.id.alpha_btn);
        my_layout=findViewById(R.id.my_layout);

//        LogUtil.e("高度：" +  SizeUtils.getMeasuredHeight(mRecyclerView));
//        LogUtil.e("高度：" +  SizeUtils.getMeasuredHeight(my_layout));
    }

    private void siglelon() {
//        单例
        Singleton.getinstence();
//        builder模式
        BuiderTest.Builder builder = new BuiderTest.Builder(this)
                .setMaxNum(10);

    }

    private void getheight() {
        Log.e("zfg", mApl.getMeasuredHeight() + "::" + mApl.getHeight());
    }

    private void animator() {
//        旋转 动画的目标控件 动画效果 动画的变化值
        ObjectAnimator animator = ObjectAnimator.ofFloat(mBtn, "rotation", 0, 360);
        animator.setDuration(3000);
        //2、设置动画的持续时间、是否重复及重复次数属性；
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(5);
        animator.start();
//        渐变
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mApl, "alpha", 1, 0, 1);
        animator1.setDuration(3000);
        animator1.start();

//
        AnimatorSet animatorSet = new AnimatorSet();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 30) {
            if (resultCode == RESULT_OK) {
                String result = data.getDataString();
                Log.e("main", "结果" + result);
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }
}
