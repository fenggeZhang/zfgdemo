package com.zfg.test.activity;

import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间选择器
 */
public class SelectTimeActivity extends BaseActivity implements View.OnClickListener {
    private Button mButton;
    private Button mSelectRangeBtn;
    private Button mSelectWhatBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_time;
    }

    @Override
    protected void setupView() {
        mButton = findViewById(R.id.select_btn);
        mSelectRangeBtn = findViewById(R.id.select_range_btn);
        mSelectWhatBtn = findViewById(R.id.select_what_btn);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void addListener() {
        mButton.setOnClickListener(this);
        mSelectRangeBtn.setOnClickListener(this);
        mSelectWhatBtn.setOnClickListener(this);
    }

    @Override
    protected int getTitleStringId() {
        return R.string.select_time_title;
    }


    private void selectTimeDialog() {
        TimePickerView timePickerView = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                mButton.setText(date.toString());
            }
        }).build();
        timePickerView.setTitleText("选择时间");
        timePickerView.setDate(Calendar.getInstance());
        timePickerView.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.select_btn:
                selectTimeDialog();
                break;
            case R.id.select_range_btn:
                selectRangeTimeDialog();
                break;
            case R.id.select_what_btn:
                selectWhatDialog();
                break;
        }
    }

    private void selectWhatDialog() {
        TimePicker timePickerView1 = new TimePicker(this);
        timePickerView1.showContextMenu();
    }

    private void selectRangeTimeDialog() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mSelectRangeBtn.setText(hourOfDay + ":" + minute);
            }
        }, 12, 45, true);

        timePickerDialog.show();
    }
}
