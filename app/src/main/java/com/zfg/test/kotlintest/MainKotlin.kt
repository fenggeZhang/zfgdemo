package com.zfg.test.kotlintest

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.zfg.test.R
import com.zfg.test.activity.*
import com.zfg.test.activity.anim.Anim3DActivity
import com.zfg.test.activity.anim.BujianAnimActivity
import com.zfg.test.activity.anim.ValueAnimActivity
import com.zfg.test.activity.anim.ZhenAnimActivity
import com.zfg.test.activity.chart.*
import com.zfg.test.activity.data.GreenDaoTestActivity
import com.zfg.test.activity.ehks.OrderActivity
import com.zfg.test.activity.image.GifActivity
import com.zfg.test.activity.loaddata.LoadMoreDataActivity
import com.zfg.test.activity.recyclerview.SpanRecyclerActivity
import com.zfg.test.activity.rxjava.Rxjava2TestActivity
import com.zfg.test.activity.rxjava.RxjavaTestActivity
import com.zfg.test.activity.star.ShineButtonActivity
import com.zfg.test.activity.star.UnReadNewsActivity
import com.zfg.test.adapter.DividerGridItemDecoration
import com.zfg.test.binder.AIDLTestActivity
import com.zfg.test.designstyle.factory.FactoryActivity
import com.zfg.test.kotlintest.activity.FragmentsKotlin
import com.zfg.test.utils.LogUtil
import com.zfg.test.utils.ToastUtils

/**
 * Created by zfg on 2018/6/15
 * demo主页
 */

class MainKotlin : AppCompatActivity() {

    private lateinit var floating_action_btn: FloatingActionButton

//    var titleList: Array<String> = resources.getStringArray(R.array.main_title_list)

    /* var list: ArrayList<String> = arrayListOf("网页", "排序", "分隔符", "搜索",
             "注解", "注解2", "event数据", "event数据1", "动画", "视觉图", "测量高度"
             , "三级分类", "头部Visible", "图形验证码", "签名", "请求", "换肤"
             , "新控件", "引导层", "多种状态", "侧滑首页", "适配", "横屏-竖屏"
             , "悬浮按钮", "分组+多分类", "二级分类", "拖拽分组", "伸缩text", "雷达扫描动画"
             , "自定义view", "expand分组", "加载大图", "组件化测试", "弧布局", "点赞"
             , "网络请求", "权限", "手势", "视频播放器", "视频列表", "折线图表", "条形图"
             , "折线图1", "多折线图", "饼状图", "滚动文字", "加载刷新", "数据", "Rxjava", "Rxjava2"
             , "多条形图", "弹出框", "时间选择器", "生成二维码", "ck主页", "权限申请"
             , "帧动画", "补间动画", "属性动画", "measure", "分发", "联系人", "汽车分类",
             "spannableString", "gif", "socket", "aidl通信", "横向", "订单", "edit", "选择照片")*/

    internal var listData: ArrayList<MainEntity> = java.util.ArrayList();

    internal var activityList: ArrayList<Class<*>> = java.util.ArrayList()
    val myAdapter: MianAdapter = MianAdapter(R.layout.my_test_item, listData);
    lateinit var recyclerView: RecyclerView
    lateinit var toolbar: Toolbar
    lateinit var skeletonScreen: RecyclerViewSkeletonScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
        addListener()
        LogUtil.e("onCreate")
    }

    private fun addListener() {
        myAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            startActivity(Intent(this@MainKotlin, listData.get(position).activity))
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
        additem("网页", BaseWebViewActivity::class.java);
        additem("网页", AcmTestActivity::class.java);
        additem("分隔符", LinearLayoutActivity::class.java);
        additem("搜索", SearchActivity::class.java);
        additem("注解", Dagger2TestActivity::class.java)
        additem("注解2", Dagger2Test1Activity::class.java)
        additem("event数据", AActivity::class.java)
        additem("event数据1", BActivity::class.java)
        additem("动画", AnimActivity::class.java)
        additem("视觉图", RetrofitTestActivity::class.java)
        additem("测量高度", FragmentsKotlin::class.java)
        additem("三级分类", MultClassicActivity::class.java)
        additem("头部Visible", TitleBarActivity::class.java)
        additem("图形验证码", AdjustCodeActivity::class.java)
        additem("签名", DrawTextActivity::class.java)
        additem("请求", RequestActivity::class.java)
        additem("换肤", SkinTestActivity::class.java)
        additem("新控件", FragmentActivity::class.java)
        additem("引导层", GuideActivity::class.java)
        additem("多种状态", MutlViewActivity::class.java)
        additem("侧滑首页", MainTestActivity::class.java)
        additem("适配", FitXYActivity::class.java)
        additem("横屏-竖屏", IntentAActivity::class.java)
        additem("悬浮按钮", FloatingActivity::class.java)
        additem("分组+多分类", ExpandableRecyclerActivity::class.java)
        additem("二级分类", ExpandableClassicRecyclerActivity::class.java)
        additem("拖拽分组", DragGoupActivity::class.java)
        additem("伸缩text", ExpandableTextViewActivity::class.java)
        additem("雷达扫描动画", RadarScanActivity::class.java)
        additem("自定义view", TestViewActivity::class.java)
        additem("expand分组", ExpandListActivity::class.java)
        additem("加载大图", LongPhotoActivity::class.java)
        additem("组件化测试", CcTestActivity::class.java)
        additem("弧布局", ArcLayoutActivity::class.java)
        additem("点赞", ShineButtonActivity::class.java)
        additem("网络请求", RxEasyHttpActivity::class.java)
        additem("权限", PermissionsActivity::class.java)
        additem("手势", GestureActivity::class.java)
//        additem("视频播放器", VideoActivity::class.java)
        additem("视频播放", PlayVideoActivity::class.java)
//        additem("视频列表", VideoListActivity::class.java)
        additem("折线图表", ChartsActivity::class.java)
        additem("条形图", BarChartsActivity::class.java)
        additem("折线图1", LineChartActivity::class.java)
        additem("多折线图", MultLineChartActivity::class.java)
        additem("饼状图", PieChartActivity::class.java)
        additem("滚动文字", TextSwitcherActivity::class.java)
        additem("加载刷新", LoadMoreDataActivity::class.java)
        additem("数据", GreenDaoTestActivity::class.java)
        additem("Rxjava", RxjavaTestActivity::class.java)
        additem("Rxjava2", Rxjava2TestActivity::class.java)
        additem("多条形图", MultBarChartsActivity::class.java)
        additem("弹出框", MyPopuWindowActivity::class.java)
        additem("时间选择器", SelectTimeActivity::class.java)
        additem("生成二维码", QrCodeActivity::class.java)
        additem("ck主页", CkMainActivity::class.java)
        additem("权限申请", PermissionTestActivity::class.java)
        additem("帧动画", ZhenAnimActivity::class.java)
        additem("补间动画", BujianAnimActivity::class.java)
        additem("属性动画", ValueAnimActivity::class.java)
        additem("3D动画", Anim3DActivity::class.java)
        additem("measure", MeasureUiActivity::class.java)
        additem("分发", ViewDispatchEventActivity::class.java)
        additem("联系人", ContactListActivity::class.java)
        additem("汽车分类", CarListActivity::class.java)
        additem("spannableString", SpannableStringActivity::class.java)
        additem("gif", GifActivity::class.java)
        additem("socket", SocketTestActivity::class.java)
        additem("aidl通信", AIDLTestActivity::class.java)
        additem("横向物流进度", TimeLineRvActivity::class.java)
        additem("订单", OrderActivity::class.java)
        additem("edit", MyEditTextActivity::class.java)
        additem("九宫格多选照片", SelectImageActivity::class.java)
        additem("地图", MapSearchActivity::class.java)
        additem("上传图片", UploadImageActivity::class.java)
        additem("标签tag", TagViewActivity::class.java)
        additem("流布局", FlexRvActivity::class.java)
        additem("工厂模式", FactoryActivity::class.java)
        additem("侧滑控件", SwipePanelActivity::class.java)
        additem("List排序", SortListActivity::class.java)
        additem("联动", Recycler2Activity::class.java)
        additem("多列rv", SpanRecyclerActivity::class.java)
        additem("未读消息数", UnReadNewsActivity::class.java)
    }

    private fun additem(title: String, java: Class<*>) {
        listData.add(MainEntity(title, java))

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        LogUtil.e("onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtil.e("onRestoreInstanceState")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        LogUtil.e("onConfigurationChanged")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.e("onDestroy")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_nav_menu, menu)
        return true
    }
}