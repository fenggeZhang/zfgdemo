package com.zfg.test.kotlintest

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Switch
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import com.zfg.test.R
import com.zfg.test.activity.*
import com.zfg.test.activity.anim.BujianAnimActivity
import com.zfg.test.activity.anim.ValueAnimActivity
import com.zfg.test.activity.anim.ZhenAnimActivity
import com.zfg.test.activity.chart.*
import com.zfg.test.activity.data.GreenDaoTestActivity
import com.zfg.test.activity.ehks.OrderActivity
import com.zfg.test.activity.image.GifActivity
import com.zfg.test.activity.loaddata.LoadMoreDataActivity
import com.zfg.test.activity.rxjava.Rxjava2TestActivity
import com.zfg.test.activity.rxjava.RxjavaTestActivity
import com.zfg.test.activity.star.ShineButtonActivity
import com.zfg.test.activity.ui.ViewStubActivity
import com.zfg.test.adapter.DividerGridItemDecoration
import com.zfg.test.binder.AIDLTestActivity
import com.zfg.test.kotlintest.activity.BaseWebKotlin
import com.zfg.test.kotlintest.activity.FragmentsKotlin
import com.zfg.test.utils.ToastUtils
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by zfg on 2018/6/15
 * demo主页
 */

class MainKotlin : AppCompatActivity() {

    private lateinit var floating_action_btn: FloatingActionButton

    var list: ArrayList<String> = arrayListOf("网页", "排序", "分隔符", "搜索",
            "注解", "注解2", "event数据", "event数据1", "动画", "视觉图", "测量高度"
            , "三级分类", "头部Visible", "图形验证码", "签名", "请求", "换肤"
            , "新控件", "引导层", "多种状态", "侧滑首页", "适配", "横屏-竖屏"
            , "悬浮按钮", "分组+多分类", "二级分类", "拖拽分组", "伸缩text", "雷达扫描动画"
            , "自定义view", "expand分组", "加载大图", "组件化测试", "弧布局", "点赞"
            , "网络请求", "权限", "手势", "视频播放器", "视频列表", "折线图表", "条形图"
            , "折线图1", "多折线图", "饼状图", "滚动文字", "加载刷新", "数据", "Rxjava", "Rxjava2"
            , "多条形图", "弹出框", "时间选择器", "生成二维码", "ck主页", "权限申请"
            , "帧动画", "补间动画", "属性动画", "measure", "分发", "联系人", "汽车分类",
            "spannableString", "gif", "socket", "aidl通信", "横向", "订单", "edit", "选择照片"
    )

    internal var activityList: ArrayList<Class<*>> = java.util.ArrayList()
    val myAdapter: MianAdapter = MianAdapter(R.layout.my_test_item, list);
    lateinit var recyclerView: RecyclerView
    lateinit var toolbar: Toolbar
    lateinit var skeletonScreen: RecyclerViewSkeletonScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
        addListener()
    }

    private fun addListener() {
        myAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            startActivity(Intent(this@MainKotlin, activityList.get(position)))
        }
        floating_action_btn.setOnClickListener { v: View? ->
            recyclerView.scrollToPosition(0)//滑动到顶部 fragment就是 scrolltotop
        }
        toolbar.setOnMenuItemClickListener({ item ->
            run {
                if (item.itemId == R.id.nav_setting)
                    ToastUtils.show(this, "关于我")
            }
            true
        })
    }

    private fun initView() {
        recyclerView = findViewById(R.id.my_recycler)
        toolbar = findViewById(R.id.toolbar)
        floating_action_btn = findViewById(R.id.floating_action_btn)
        recyclerView.setLayoutManager(GridLayoutManager(this, 4))
        recyclerView.addItemDecoration(DividerGridItemDecoration(this))
        recyclerView.adapter = myAdapter
        setSupportActionBar(toolbar)
        /*   skeletonScreen = Skeleton.bind(recyclerView)
                   .adapter(myAdapter)
                   .load(R.layout.layout_default_item_skeleton)
                   .show()
           skeletonScreen.hide()
   */
    }

    private fun initData() {
        activityList.add(BaseWebViewActivity::class.java)
        activityList.add(AcmTestActivity::class.java)
        activityList.add(LinearLayoutActivity::class.java)
        activityList.add(SearchActivity::class.java)
        activityList.add(Dagger2TestActivity::class.java)
        activityList.add(Dagger2Test1Activity::class.java)
        activityList.add(AActivity::class.java)
        activityList.add(BActivity::class.java)
        activityList.add(AnimActivity::class.java)
        activityList.add(RetrofitTestActivity::class.java)
        activityList.add(FragmentsKotlin::class.java)
        activityList.add(MultClassicActivity::class.java)
        activityList.add(TitleBarActivity::class.java)
        activityList.add(AdjustCodeActivity::class.java)
        activityList.add(DrawTextActivity::class.java)
        activityList.add(RequestActivity::class.java)
        activityList.add(SkinTestActivity::class.java)
        activityList.add(FragmentActivity::class.java)
        activityList.add(GuideActivity::class.java)
        activityList.add(MutlViewActivity::class.java)
        activityList.add(MainTestActivity::class.java)
        activityList.add(FitXYActivity::class.java)
        activityList.add(IntentAActivity::class.java)
        activityList.add(FloatingActivity::class.java)
        activityList.add(ExpandableRecyclerActivity::class.java)
        activityList.add(ExpandableClassicRecyclerActivity::class.java)
        activityList.add(DragGoupActivity::class.java)
        activityList.add(ExpandableTextViewActivity::class.java)
        activityList.add(RadarScanActivity::class.java)
        activityList.add(TestViewActivity::class.java)
        activityList.add(ExpandListActivity::class.java)
        activityList.add(LongPhotoActivity::class.java)
        activityList.add(CcTestActivity::class.java)
        activityList.add(ArcLayoutActivity::class.java)
        activityList.add(ShineButtonActivity::class.java)
        activityList.add(RxEasyHttpActivity::class.java)
        activityList.add(PermissionsActivity::class.java)
        activityList.add(GestureActivity::class.java)
        activityList.add(VideoActivity::class.java)
        activityList.add(VideoListActivity::class.java)
        activityList.add(ChartsActivity::class.java)
        activityList.add(BarChartsActivity::class.java)
        activityList.add(LineChartActivity::class.java)
        activityList.add(MultLineChartActivity::class.java)
        activityList.add(PieChartActivity::class.java)
        activityList.add(TextSwitcherActivity::class.java)
        activityList.add(LoadMoreDataActivity::class.java)
        activityList.add(GreenDaoTestActivity::class.java)
        activityList.add(RxjavaTestActivity::class.java)
        activityList.add(Rxjava2TestActivity::class.java)
        activityList.add(MultBarChartsActivity::class.java)
        activityList.add(MyPopuWindowActivity::class.java)
        activityList.add(SelectTimeActivity::class.java)
        activityList.add(QrCodeActivity::class.java)
        activityList.add(CkMainActivity::class.java)
        activityList.add(PermissionTestActivity::class.java)
        activityList.add(ZhenAnimActivity::class.java)
        activityList.add(BujianAnimActivity::class.java)
        activityList.add(ValueAnimActivity::class.java)
        activityList.add(MeasureUiActivity::class.java)
        activityList.add(ViewDispatchEventActivity::class.java)
        activityList.add(ContactListActivity::class.java)
        activityList.add(CarListActivity::class.java)
        activityList.add(SpannableStringActivity::class.java)
        activityList.add(GifActivity::class.java)
        activityList.add(SocketTestActivity::class.java)
        activityList.add(AIDLTestActivity::class.java)
        activityList.add(TimeLineRvActivity::class.java)
        activityList.add(OrderActivity::class.java)
        activityList.add(MyEditTextActivity::class.java)
        activityList.add(SelectImageActivity::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_nav_menu, menu)
        return true
    }
}