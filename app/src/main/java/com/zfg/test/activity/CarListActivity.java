package com.zfg.test.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.reflect.TypeToken;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.CarListAdapter;
import com.zfg.test.common.Contants;
import com.zfg.test.entity.CarBean;
import com.zfg.test.entity.CarItemBean;
import com.zfg.test.utils.GsonUtils;

import java.util.ArrayList;
import java.util.List;

public class CarListActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private CarListAdapter mCarListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_car_list;
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.my_rv);
    }

    @Override
    protected void initData() {
        List<MultiItemEntity> res = new ArrayList<>();

        String gson = Contants.gson;
        List<CarItemBean> carItemBeans = GsonUtils.fromJson(gson, new TypeToken<List<CarItemBean>>() {
        }.getType());

        for (int i = 0; i < carItemBeans.size(); i++) {
            boolean isInclude = false;
            for (int j = 0; j < res.size(); j++) {
                CarBean carBean = (CarBean) res.get(j);
                if (carBean.getTitle().equals(carItemBeans.get(i).getMakename())) {
                    carBean.addSubItem(carItemBeans.get(i));
                    isInclude = true;
                    break;
                }
            }
            if (!isInclude) {
                CarBean carBean = new CarBean();
                carBean.setTitle(carItemBeans.get(i).getMakename());
                carBean.addSubItem(carItemBeans.get(i));
                res.add(carBean);
            }
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mCarListAdapter = new CarListAdapter(res);
        mRecyclerView.setAdapter(mCarListAdapter);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
