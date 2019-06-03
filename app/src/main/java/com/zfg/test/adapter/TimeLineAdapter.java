package com.zfg.test.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;

import java.util.List;

/**
 * Created by zfg on 2019/5/5
 */
public class TimeLineAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int selectIndex = 0;

    public TimeLineAdapter(@Nullable List<String> data) {
        super(R.layout.item_timeline, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (helper.getLayoutPosition() == 0) {
            helper.setVisible(R.id.start_line, false);
        } else {
            helper.setVisible(R.id.start_line, true);
        }
        if (helper.getLayoutPosition() == getData().size() - 1) {
            helper.setVisible(R.id.end_line, false);
        } else {
            helper.setVisible(R.id.end_line, true);
        }
        if (helper.getLayoutPosition() < selectIndex) {
            helper.setImageResource(R.id.icon_iv, R.drawable.icon_finished);
            helper.setBackgroundColor(R.id.start_line, mContext.getResources().getColor(R.color.color_blue));
            helper.setBackgroundColor(R.id.end_line, mContext.getResources().getColor(R.color.color_blue));
            helper.setTextColor(R.id.desc_tv, mContext.getResources().getColor(R.color.color_blue));
        } else if (helper.getLayoutPosition() == selectIndex) {
            helper.setImageResource(R.id.icon_iv, R.drawable.icon_ongoing);
            helper.setBackgroundColor(R.id.start_line, mContext.getResources().getColor(R.color.color_blue));
            helper.setBackgroundColor(R.id.end_line, mContext.getResources().getColor(R.color.gray_66));
            helper.setTextColor(R.id.desc_tv, mContext.getResources().getColor(R.color.color_blue));
        } else {
            helper.setImageResource(R.id.icon_iv, R.drawable.icon_incomplete);
            helper.setBackgroundColor(R.id.start_line, mContext.getResources().getColor(R.color.gray_66));
            helper.setBackgroundColor(R.id.end_line, mContext.getResources().getColor(R.color.gray_66));
            helper.setTextColor(R.id.desc_tv, mContext.getResources().getColor(R.color.gray_66));
        }
        helper.setText(R.id.desc_tv, item);
    }

    public void setSelectState(int index) {
        selectIndex = index;
    }

}
