package com.zfg.test.activity.chart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.List;

/**
 * Created by zfg on 2018/11/7
 */
public class StringAxisValueFormatter implements IAxisValueFormatter {
    //区域值
    private List<String> mStrs;

    /**
     * 对字符串类型的坐标轴标记进行格式化
     *
     * @param strs
     */
    public StringAxisValueFormatter(List<String> strs) {
        this.mStrs = strs;
    }

    @Override
    public String getFormattedValue(float v, AxisBase axisBase) {
        return mStrs.get((int) v);
    }


}
