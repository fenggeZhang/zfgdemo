package com.zfg.test.activity.chart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 折线图
 */
public class LineChartActivity extends BaseActivity {
    private List<String> mxList;
    private List<Float> mFloatList;

    private LineChart mLineChart;
    public static final int[] LINE_COLORS = {
            Color.rgb(140, 210, 118), Color.rgb(159, 143, 186), Color.rgb(233, 197, 23)
    };//绿色，紫色，黄色

    public static final int[] LINE_FILL_COLORS = {
            Color.rgb(222, 239, 228), Color.rgb(246, 234, 208), Color.rgb(235, 228, 248)
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_line_chart;
    }

    @Override
    protected void setupView() {
        mLineChart = findViewById(R.id.lineChart);
    }

    @Override
    protected void initData() {
        mxList = new ArrayList<>();
        mFloatList = new ArrayList<>();
        mxList.add("test1");
        mxList.add("test2");
        mxList.add("test3");
        mxList.add("test4");
        mxList.add("test5");
        mxList.add("test6");

        mFloatList.add(100f);
        mFloatList.add(130f);
        mFloatList.add(125f);
        mFloatList.add(110f);
        mFloatList.add(125f);
        mFloatList.add(105f);
        setLineChart(mLineChart, mxList, mFloatList, "测试1", true);

        List<String> strings = new ArrayList<>();
        strings.add("1月");
        strings.add("2月");
        strings.add("3月");
        strings.add("4月");
        strings.add("5月");
        strings.add("6月");

        List<Float> floatList = new ArrayList<>();
        floatList.add(90f);
        floatList.add(100f);
        floatList.add(125f);
        floatList.add(145f);
        floatList.add(115f);
        floatList.add(95f);
        initChart();
//        setLineChart(mLineChart, strings, floatList, "测试2", true);
    }

    private void initChart() {
        mLineChart.setDrawGridBackground(false);
        mLineChart.getDescription().setEnabled(false);
        mLineChart.setDrawBorders(false);//是否绘制图表得边框 true绘制边框 默认不绘制

        mLineChart.getAxisLeft().setEnabled(false);//左侧得边线 true是显示
        mLineChart.getAxisRight().setDrawAxisLine(true);//折线下方得面积会显示颜色 true是显示
        mLineChart.getAxisRight().setDrawGridLines(false);//
        mLineChart.getXAxis().setDrawAxisLine(false);
        mLineChart.getXAxis().setDrawGridLines(false);

        // enable touch gestures
        mLineChart.setTouchEnabled(true);

        // enable scaling and dragging
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mLineChart.setPinchZoom(false);

        Legend l = mLineChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER); //文字说明得位置

        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //上面三个设置 文字说明可以在图形底部显示
        l.setDrawInside(false);//图例是在图表内绘制 还是在图标外绘制
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }


    /**
     * 单线单y轴图。
     *
     * @param lineChart
     * @param xAxisValue
     * @param yAxisValue
     * @param title
     * @param showSetValues 是否在折线上显示数据集的值。true为显示，此时y轴上的数值不可见，否则相反。
     */
    public static void setLineChart(LineChart lineChart, List<String> xAxisValue, List<Float> yAxisValue, String title, boolean showSetValues) {
        List<List<Float>> entriesList = new ArrayList<>();
        entriesList.add(yAxisValue);

        List<String> titles = new ArrayList<>();
        titles.add(title);

        setLinesChart(lineChart, xAxisValue, entriesList, titles, showSetValues, null);
    }

    /**
     * 绘制线图，默认最多绘制三种颜色。所有线均依赖左侧y轴显示。
     *
     * @param lineChart
     * @param xAxisValue    x轴的轴
     * @param yXAxisValues  y轴的值
     * @param titles        每一个数据系列的标题
     * @param showSetValues 是否在折线上显示数据集的值。true为显示，此时y轴上的数值不可见，否则相反。
     * @param lineColors    线的颜色数组。为null时取默认颜色，此时最多绘制三种颜色。
     */
    public static void setLinesChart(LineChart lineChart, List<String> xAxisValue, List<List<Float>> yXAxisValues, List<String> titles, boolean showSetValues, int[] lineColors) {
        lineChart.getDescription().setEnabled(false);//设置描述
        lineChart.setPinchZoom(true);//设置按比例放缩柱状图
      /*  MPChartMarkerView markerView = new MPChartMarkerView(lineChart.getContext(), R.layout.custom_marker_view);
        lineChart.setMarker(markerView);*/

        //x坐标轴设置
        IAxisValueFormatter xAxisFormatter = new StringAxisValueFormatter(xAxisValue);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(xAxisValue.size());
        /*xAxis.setAxisLineWidth(2f);*/
        xAxis.setValueFormatter(xAxisFormatter);

        //y轴设置
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setDrawGridLines(false);
        if (showSetValues) {
            leftAxis.setDrawLabels(false);//折线上显示值，则不显示坐标轴上的值
        }
        //leftAxis.setDrawZeroLine(true);
        /*leftAxis.setAxisMinimum(0f);*/
        /*leftAxis.setAxisLineWidth(2f);*/

        lineChart.getAxisRight().setEnabled(false);

        //图例设置
        Legend legend = lineChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(12f);

        //设置折线图数据
        setLinesChartData(lineChart, yXAxisValues, titles, showSetValues, lineColors);

        lineChart.setExtraOffsets(10, 30, 20, 10);
        lineChart.animateX(1500);//数据显示动画，从左往右依次显示
    }

    private static void setLinesChartData(LineChart lineChart, List<List<Float>> yXAxisValues, List<String> titles, boolean showSetValues, int[] lineColors) {

        List<List<Entry>> entriesList = new ArrayList<>();
        for (int i = 0; i < yXAxisValues.size(); ++i) {
            ArrayList<Entry> entries = new ArrayList<>();
            for (int j = 0, n = yXAxisValues.get(i).size(); j < n; j++) {
                entries.add(new Entry(j, yXAxisValues.get(i).get(j)));
            }
            entriesList.add(entries);
        }

        if (lineChart.getData() != null && lineChart.getData().getDataSetCount() > 0) {

            for (int i = 0; i < lineChart.getData().getDataSetCount(); ++i) {
                LineDataSet set = (LineDataSet) lineChart.getData().getDataSetByIndex(i);
                set.setValues(entriesList.get(i));
                set.setLabel(titles.get(i));
            }

            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();

            for (int i = 0; i < entriesList.size(); ++i) {
                LineDataSet set = new LineDataSet(entriesList.get(i), titles.get(i));
                if (lineColors != null) {
                    set.setColor(lineColors[i % entriesList.size()]);
                    set.setCircleColor(lineColors[i % entriesList.size()]);

                } else {
                    set.setColor(LINE_COLORS[i % 3]);
                    set.setCircleColor(LINE_COLORS[i % 3]);

                }
                set.setCircleHoleColor(Color.WHITE);
                if (entriesList.size() == 1) {
                    set.setDrawFilled(true);
                    set.setFillColor(LINE_FILL_COLORS[i % 3]);
                }
                dataSets.add(set);
            }

            LineData data = new LineData(dataSets);
            if (showSetValues) {
                data.setValueTextSize(10f);
                data.setValueFormatter(new IValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, Entry entry, int i, ViewPortHandler viewPortHandler) {
                        return StringUtils.double2String(value, 1);
                    }
                });
            } else {
                data.setDrawValues(false);
            }

            lineChart.setData(data);
        }
    }

}
