package com.zfg.test.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.CkAdapter;
import com.zfg.test.entity.CkBean;

import java.util.ArrayList;
import java.util.List;

public class CkMainActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private CkAdapter mCkAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ck_main;
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.content_rv);
    }

    @Override
    protected void initData() {
        List<CkBean> ckBeanList = new ArrayList<>();
        mCkAdapter = new CkAdapter(ckBeanList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerView.setAdapter(mCkAdapter);

        ckBeanList.add(new CkBean("别让你的青春编程更年期！"));
        ckBeanList.add(new CkBean("对不起，我的青春撞疼了你"));
        ckBeanList.add(new CkBean("工人安全教育不到位"));
        ckBeanList.add(new CkBean("工人安全教育不到位"));
        ckBeanList.add(new CkBean("工人安全教育不到位"));
        ckBeanList.add(new CkBean("工人安全教育不到位"));
        ckBeanList.add(new CkBean("工人安全教育不到位"));
        ckBeanList.add(new CkBean("工人安全教育不到位"));
        mCkAdapter.setNewData(ckBeanList);
    }

    @Override
    protected void addListener() {
        mCkAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ToastUtil.showMsg(mCkAdapter.getData().get(position).getTitle());
                showToast(mCkAdapter.getData().get(position).getTitle());
            }
        });
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
