package com.zfg.test.activity.chart;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;



/**
 * @author zfg
 * @create 2018/11/6
 * @Describe 图表--折线图
 */

public class ChartsActivity extends BaseActivity {
    LineChart mLineChart;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_charts;
    }

    @Override
    protected void setupView() {
        mLineChart = findViewById(R.id.chart);
    }

    @Override
    protected void initData() {
        List<Entry> valsComp1 = new ArrayList<Entry>();
        List<Entry> valsComp2 = new ArrayList<Entry>();

        Entry c1e1 = new Entry(0f, 100000f); // 0 == quarter 1
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(1f, 140000f); // 1 == quarter 2 ...
        valsComp1.add(c1e2);
        Entry c1e3 = new Entry(2f, 130000f); // 1 == quarter 2 ...
        Entry c1e4 = new Entry(3f, 150000f); // 1 == quarter 2 ...
        valsComp1.add(c1e3);
        valsComp1.add(c1e4);
        // and so on ...

        Entry c2e1 = new Entry(0f, 130000f); // 0 == quarter 1
        valsComp2.add(c2e1);
        Entry c2e2 = new Entry(1f, 115000f); // 1 == quarter 2 ...
        valsComp2.add(c2e2);

        Entry c2e3 = new Entry(2f, 120000f); // 0 == quarter 1
        valsComp2.add(c2e3);
        Entry c2e4 = new Entry(3f, 110000f); // 1 == quarter 2 ...
        valsComp2.add(c2e4);


        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");
        setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);

        // use the interface ILineDataSet
        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        mLineChart.invalidate(); // refresh


        final String[] quarters = new String[]{"Q1", "Q2", "Q3", "Q4"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };

        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
