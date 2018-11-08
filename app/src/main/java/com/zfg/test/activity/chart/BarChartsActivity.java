package com.zfg.test.activity.chart;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zfg
 * @create 2018/11/6
 * @Describe 图表--条形图
 */
public class BarChartsActivity extends BaseActivity {

    private BarChart mBarChart;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bar_charts;
    }

    @Override
    protected void setupView() {
        mBarChart = findViewById(R.id.bar_chart);
    }

    @Override
    protected void initData() {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(entries, "条形图数据");//颜色得说明


        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        mBarChart.setData(data);
//        mBarChart.setDrawBarShadow(true);//填充上方得空白为灰色
//        mBarChart.setFitBars(true); // make the x-axis fit exactly all bars
        mBarChart.invalidate(); // refresh
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
