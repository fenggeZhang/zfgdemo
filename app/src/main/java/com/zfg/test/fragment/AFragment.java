package com.zfg.test.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.stetho.common.LogUtil;
import com.zfg.test.R;
import com.zfg.test.adapter.DividerGridItemDecoration;
import com.zfg.test.adapter.MyAdapter;
import com.zfg.test.entity.TestBean;
import com.zfg.test.utils.SizeUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfg on 2018/6/11
 */
public class AFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private List<TestBean> mTestBeans;
    private ScrollView a_scrollview;
    View mRootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.a_fragment, null);
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        initData();
        initView();
        getHeigth();
        return mRootView;
    }

    private void getHeigth() {
//        LogUtil.e("scrollview:"+SizeUtils.getMeasuredHeight(a_scrollview));
        LogUtil.e("recyclerview:"+SizeUtils.getMeasuredHeight(mRecyclerView));
        EventBus.getDefault().post(""+SizeUtils.getMeasuredHeight(a_scrollview));
    }

    private void initData() {
        mTestBeans = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mTestBeans.add(new TestBean("数据"+i));
        }
    }

    private void initView() {
        mRecyclerView = mRootView.findViewById(R.id.a_recycler);
        a_scrollview=mRootView.findViewById(R.id.a_scrollview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        mMyAdapter = new MyAdapter(R.layout.my_test_item, mTestBeans);
        mRecyclerView.setAdapter(mMyAdapter);

    }
}
