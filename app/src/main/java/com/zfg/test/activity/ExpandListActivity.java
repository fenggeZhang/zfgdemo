package com.zfg.test.activity;

import android.widget.ExpandableListView;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.MyExpandAdapter;
import com.zfg.test.entity.ExpandGroupBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zfg
 * @create 2018/10/12
 * @Describe 测试
 */
public class ExpandListActivity extends BaseActivity {

    private ExpandableListView mExpandableListView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_expand_list;
    }

    @Override
    protected void setupView() {
        mExpandableListView = findViewById(R.id.test_expand_listview);
    }

    @Override
    protected void initData() {
        List<ExpandGroupBean> groupBeanList = new ArrayList<>();
        ArrayList<ExpandGroupBean.ExpandChildBean> expandChildBeans = new ArrayList<>();
        for (int j = 0;j < 5; j++) {
            ExpandGroupBean.ExpandChildBean expandChildBean=new ExpandGroupBean.ExpandChildBean();
            expandChildBean.setChildName("内容"+j);
            expandChildBeans.add(expandChildBean);
        }
        for (int i = 0; i < 10; i++) {
            ExpandGroupBean expandGroupBean = new ExpandGroupBean();
            expandGroupBean.setGroupName("分组" + i);
            expandGroupBean.setChildBeans(expandChildBeans);
            groupBeanList.add(expandGroupBean);
        }
        MyExpandAdapter myExpandAdapter = new MyExpandAdapter(groupBeanList, this);
        mExpandableListView.setAdapter(myExpandAdapter);
    }

    @Override
    protected void addListener() {
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
