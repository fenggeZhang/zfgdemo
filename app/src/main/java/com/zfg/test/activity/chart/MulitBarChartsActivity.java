package com.zfg.test.activity.chart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MulitBarChartsActivity extends BaseActivity {

    private BarChart mBarChart;
    private List<String> mXStrList;//横坐标

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mulit_bar_charts;
    }

    @Override
    protected void setupView() {
        mBarChart = findViewById(R.id.bar_chart);
    }

    @Override
    protected void initData() {
        mXStrList = new ArrayList<>();
        mXStrList.add("全国销售额");
        mXStrList.add("全车件");
        mXStrList.add("标品");
        mXStrList.add("易损件");
        initCharts();
        setData();
    }

    private void setData() {
        float groupSpace = 0.5f;
        float barSpace = 0.1f; // x4 DataSet
        float barWidth = 0.15f; // x4 DataSet
        // (0.2 + 0.03) * 4 + 0.08 = 1.00 -> interval per "group"

        ArrayList<BarEntry> values1 = new ArrayList<>();//全国和本站数据
        ArrayList<BarEntry> values2 = new ArrayList<>();

//        表示4个分组
        for (int i = 0; i < 4; i++) {
            values1.add(new BarEntry(i, (float) (Math.random() * 8000)));
            values2.add(new BarEntry(i, (float) (Math.random() * 8000)));
        }

        BarDataSet set1, set2;

        // create 4 DataSets
        set1 = new BarDataSet(values1, "全国平均");
        set1.setColor(Color.rgb(255, 220, 113));
        set2 = new BarDataSet(values2, "本站");
        set2.setColor(Color.rgb(113, 177, 228));

        BarData data = new BarData(set1, set2);

        mBarChart.setData(data);

        // specify the width each bar should have
        mBarChart.getBarData().setBarWidth(barWidth);

        // restrict the x-axis range
        mBarChart.getXAxis().setAxisMinimum(0);

        // barData.getGroupWith(...) is a helper that calculates the width each group needs based on the provided parameters
        mBarChart.getXAxis().setAxisMaximum(0 + mBarChart.getBarData().getGroupWidth(groupSpace, barSpace) * 4);
        mBarChart.groupBars(0, groupSpace, barSpace);
        mBarChart.invalidate();
    }

    private void initCharts() {
        mBarChart.getDescription().setEnabled(false);
        // scaling can now only be done on x- and y-axis separately
        mBarChart.setPinchZoom(false);
        mBarChart.setDrawBarShadow(false);
        mBarChart.setDrawGridBackground(false);

        Legend l = mBarChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setTextSize(12f);//图例得文字大小
        //上面三个设置 文字说明可以在图形底部显示
        l.setDrawInside(false);//图例是在图表内绘制 还是在图标外绘制

        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setGranularity(1f);//  设置缩放轴得最小间隔
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMinimum(0);
        xAxis.setTextColor(Color.parseColor("#999999")); //设置横坐标字体颜色
        xAxis.setAxisLineColor(Color.parseColor("#999999"));//设置横轴颜色
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mXStrList.get((Math.abs((int) value)) % 4);//这样处理是 因为数组越界
            }
        });

        YAxis leftAxis = mBarChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        mBarChart.getAxisRight().setEnabled(false);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
