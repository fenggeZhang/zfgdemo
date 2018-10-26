package com.zfg.test.kotlintest.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.zfg.test.R
import com.zfg.test.adapter.FragmentAdapter
import com.zfg.test.fragment.AFragment
import com.zfg.test.weigt.NoScrollViewPager
import okhttp3.internal.Internal
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * Created by zfg on 2018/6/20
 */
class FragmentsKotlin : AppCompatActivity() {
    lateinit var mTabLayout: TabLayout
    lateinit var mViewPager: NoScrollViewPager
    lateinit var titlelist: ArrayList<String>
    lateinit var fragments: ArrayList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)
        initView()
        initData()
    }

    private fun initData() {
        titlelist= ArrayList()
        titlelist.add("页面A")
        titlelist.add("页面B")
        mTabLayout.addTab(mTabLayout.newTab().setText("页面A"))
        mTabLayout.addTab(mTabLayout.newTab().setText("页面B"))
         var aFragment: AFragment= AFragment()
         var bFragment: AFragment=AFragment()
        fragments=ArrayList()
        fragments.add(aFragment)
        fragments.add(bFragment)
        var mFragmentAdapter:FragmentAdapter= FragmentAdapter(this.supportFragmentManager,
                fragments,titlelist)
        mViewPager.adapter=mFragmentAdapter
        mTabLayout.setupWithViewPager(mViewPager)
//        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter)
    }

    private fun initView() {
        mTabLayout = findViewById(R.id.my_tablayout)
        mViewPager = findViewById(R.id.view_pager)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}