package com.zfg.test.activity;

import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.LogUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_sort_list;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initData() {
        List<String> strings = new ArrayList<>();
      /*  strings.add("=#");
        strings.add("#");
        strings.add("!#");
        strings.add("%#");
        strings.add("&#");
        strings.add("11#2");
        strings.add("11#1");
        strings.add("11#");
        strings.add("ABC");*/
        strings.add("ac");
        strings.add("~#311");
        strings.add("ac");
        strings.add("!#1");
        strings.add("&#2");
     /*   strings.add("!#3");
        strings.add("=#3");
        strings.add("=#3");
        strings.add("~#3");
        strings.add("#");
        strings.add("!#");
        strings.add("%#");
        strings.add("&#");*/
        // 排序
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.contains("#")) {
                    if (o2.contains("#")) {
                        return o1.compareTo(o2);
                    }
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        LogUtil.e(strings.toString());
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
