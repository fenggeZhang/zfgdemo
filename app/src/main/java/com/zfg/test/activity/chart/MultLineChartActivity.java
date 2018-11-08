package com.zfg.test.activity.chart;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.ArrayList;

/**
 * 多个折线
 */
public class MultLineChartActivity extends BaseActivity {

    private LineChart mLineChart;

    private final int[] colors = new int[]{
            ColorTemplate.VORDIPLOM_COLORS[0],
            ColorTemplate.VORDIPLOM_COLORS[1],
            ColorTemplate.VORDIPLOM_COLORS[2]
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mult_line_chart;
    }

    @Override
    protected void setupView() {
        mLineChart = findViewById(R.id.lineChart);
    }

    @Override
    protected void initData() {
        initChart();
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();

        for (int z = 0; z < 3; z++) {
            ArrayList<Entry> values = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                double val = (Math.random() * 50) + 3;
                values.add(new Entry(i, (float) val));
            }

            LineDataSet d = new LineDataSet(values, "配件 " + (z + 1));
            d.setMode(LineDataSet.Mode.CUBIC_BEZIER);//圆滑曲线  默认是折线
            d.setLineWidth(2.5f);
            d.setCircleRadius(4f);

            int color = colors[z % colors.length];
            d.setColor(color);
            d.setCircleColor(color);
            dataSets.add(d);
        }

        // make the first DataSet dashed
//        ((LineDataSet) dataSets.get(0)).enableDashedLine(10, 10, 0);
//        ((LineDataSet) dataSets.get(0)).setColors(ColorTemplate.VORDIPLOM_COLORS);
//        ((LineDataSet) dataSets.get(0)).setCircleColors(ColorTemplate.VORDIPLOM_COLORS);

        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        mLineChart.invalidate();


    }

    private void initChart() {
        //图表的描述文字
        Description description = new Description();
        description.setText("");
        mLineChart.setDescription(description);//图表得描述

        mLineChart.setVisibleXRangeMinimum(3);//横坐标最少要留几个点
        mLineChart.setVisibleXRangeMaximum(5);//横坐标最多有几个点

// X轴
        XAxis xAxis;
        {   // // X-Axis Style // //
            xAxis = mLineChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//默认是TOP
            // vertical grid lines
            xAxis.enableGridDashedLine(10f, 10f, 0f);//横坐标的间距 启用虚线网格
        }

//        Y轴
        YAxis yAxis;
        {   // // Y-Axis Style // //
            yAxis = mLineChart.getAxisLeft();

            // disable dual axis (only use LEFT axis)
            mLineChart.getAxisRight().setEnabled(false);
            // horizontal grid lines
            yAxis.enableGridDashedLine(10f, 10f, 0f);//设置纵坐标的间距

            // axis range
//            yAxis.setAxisMaximum(200f);
            yAxis.setAxisMinimum(0f);//设置纵坐标的区域  从0开始
        }


        Legend l = mLineChart.getLegend();//图例
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER); //文字说明得位置

//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);

    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
