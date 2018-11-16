package com.zfg.test.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;
import com.zfg.test.entity.Status;

/**
 * Created by zfg on 2018/11/15
 */
public class LoadMoreAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public LoadMoreAdapter() {
        super(R.layout.layout_animation, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        switch (helper.getLayoutPosition() %
                3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        helper.setText(R.id.tweetText, item.getUserName());

    }
}
