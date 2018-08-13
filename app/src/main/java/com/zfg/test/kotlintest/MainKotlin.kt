package com.zfg.test.kotlintest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.zfg.test.R
import com.zfg.test.activity.*
import com.zfg.test.adapter.DividerGridItemDecoration
import com.zfg.test.kotlintest.activity.BaseWebKotlin
import com.zfg.test.kotlintest.activity.FragmentsKotlin

/**
 * Created by zfg on 2018/6/15
 */

class MainKotlin : AppCompatActivity() {

    var list: ArrayList<String> = arrayListOf("网页", "排序", "分隔符", "搜索",
            "注解", "注解2", "event数据", "event数据1", "动画", "视觉图", "测量高度"
            , "三级分类", "头部Visible", "图形验证码", "签名", "请求", "换肤"
            , "新控件", "三级分类", "三级分类", "三级分类", "三级分类", "三级分类"
            , "三级分类", "三级分类", "三级分类", "三级分类", "三级分类", "三级分类"
            , "三级分类", "三级分类", "三级分类", "三级分类", "三级分类", "三级分类"
            , "三级分类", "三级分类", "三级分类", "三级分类", "三级分类", "三级分类"
            , "三级分类", "三级分类", "三级分类", "三级分类", "三级分类", "三级分类"
            , "三级分类", "三级分类", "三级分类", "三级分类", "三级分类", "三级分类"
            , "三级分类", "三级分类", "三级分类", "三级分类", "三级分类", "三级分类"
    )

    internal var activityList: ArrayList<Class<*>> = java.util.ArrayList()
    val myAdapter: MianAdapter = MianAdapter(R.layout.my_test_item, list);
    lateinit var recyclerView: RecyclerView

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
    }

    private fun initView() {
        recyclerView = findViewById(R.id.my_recycler)
        recyclerView.setLayoutManager(GridLayoutManager(this, 4))
        recyclerView.addItemDecoration(DividerGridItemDecoration(this))
        recyclerView.adapter = myAdapter
    }

    private fun initData() {
        activityList.add(BaseWebKotlin::class.java)
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
    }
}