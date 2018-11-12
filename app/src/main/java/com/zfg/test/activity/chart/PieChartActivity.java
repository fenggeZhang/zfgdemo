package com.zfg.test.activity.chart;

import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.ArrayList;

/**
 * 饼状图
 */
public class PieChartActivity extends BaseActivity {

    private PieChart mPieChart;
    private String[] parties = new String[]{"配件A", "配件B", "配件C", "配件D", "配件E"};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pie_chart;
    }

    @Override
    protected void setupView() {
        mPieChart = findViewById(R.id.pieChart);
    }

    @Override
    protected void initData() {
        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < 5; i++) {
            entries.add(new PieEntry((float) ((Math.random() * 20) + 20 / 5),
                    parties[i % parties.length],
                    getResources().getDrawable(R.drawable.ic_navigation)));
        }

        PieDataSet dataSet = new PieDataSet(entries, "配件饼状图");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
//        data.setValueTypeface(tfLight);
        mPieChart.setData(data);

        // undo all highlights
        mPieChart.highlightValues(null);

        mPieChart.invalidate();
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }
}
