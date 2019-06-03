package com.zfg.test.activity.ehks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.zfg.test.R;

import java.util.ArrayList;

/**
 * Created by zfg on 2019/5/5
 */
public class OrderFrament extends Fragment {
    private String mTitle;

    public static OrderFrament getInstance(String title) {
        OrderFrament sf = new OrderFrament();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order, null);
        CommonTabLayout commonTabLayout = v.findViewById(R.id.order_tab_layout);
        TextView card_title_tv = (TextView) v.findViewById(R.id.text_tv);
        card_title_tv.setText(mTitle);
        ArrayList<CustomTabEntity> tabEntities = new ArrayList<>();
        tabEntities.add(new TabEntity("全部"));
        tabEntities.add(new TabEntity("待确认"));
        tabEntities.add(new TabEntity("待发货"));
        tabEntities.add(new TabEntity("待收货"));
        tabEntities.add(new TabEntity("已取消"));
        commonTabLayout.setTabData(tabEntities);
        return v;
    }
}
