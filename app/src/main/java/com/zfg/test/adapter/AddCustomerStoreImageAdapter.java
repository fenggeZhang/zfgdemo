package com.zfg.test.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;
import com.zfg.test.activity.bean.CustomerStoreImageBean;

import java.util.List;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/5/24
 * desc   :
 */
public class AddCustomerStoreImageAdapter extends BaseQuickAdapter<CustomerStoreImageBean, BaseViewHolder> {

    public AddCustomerStoreImageAdapter(@Nullable List<CustomerStoreImageBean> data) {
        super(R.layout.item_add_customer_store_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CustomerStoreImageBean item) {
        if (item.isAdd()) {
            helper.setGone(R.id.delete_iv, false);
            helper.setImageResource(R.id.content_iv, R.drawable.icon_add_image);
        } else {
            helper.setGone(R.id.delete_iv, true);
            ImageView imageView = helper.getView(R.id.content_iv);
            Glide.with(mContext).load(item.getLocalPath()).into(imageView);
//            Glide.with(mContext).load("https://static.dingtalk.com/media/lADPDgQ9qUNNA2PNBLnNBNc_1239_1209.jpg").into(imageView);
        }
        helper.addOnClickListener(R.id.delete_iv);
    }
}
