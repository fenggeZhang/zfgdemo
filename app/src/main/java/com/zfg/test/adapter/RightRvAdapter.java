package com.zfg.test.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zfg.test.R;

import java.util.List;

/**
 * author : zfg
 * e-mail : zfg_android@163.com
 * date   : 2019/9/12
 * desc   :
 */
public class RightRvAdapter extends BaseQuickAdapter<List<String>, BaseViewHolder> {
    private Context mContext;
    RecyclerView.RecycledViewPool viewPool;

    public RightRvAdapter(@Nullable List<List<String>> data) {
        super(R.layout.item_right_rv, data);
        viewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);

    }
    /*  public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }*/

    @Override
    protected void convert(BaseViewHolder helper, List<String> item) {
        LinearLayout linearLayout = helper.getView(R.id.content);
        for (int i = 0; i < item.size(); i++) {
            addview(helper.itemView.getContext(), linearLayout, item.get(i), linearLayout);
        }

    }

    private void addview(Context context, LinearLayout linearLayout, String text, ViewGroup view) {
        //每次创建一个view
//        TextView rl_wifi = (TextView) LayoutInflater.from(context).inflate(R.layout.item_textview, view);
//        rl_wifi.setText(text);
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(16);
        textView.setTextColor(context.getResources().getColor(R.color.black));
        textView.setLayoutParams(new LinearLayout.LayoutParams(200, 80));
       /* TextView wifiNameTv = (TextView) rl_wifi.findViewById(R.id.wifiname_tv);
        TextView wifiMac = (TextView) rl_wifi.findViewById(R.id.wifi_mac_tv);
        //删除按钮
        ImageView iv_del_item = (ImageView) rl_wifi.findViewById(R.id.wifi_del_icon);
        wifiNameTv.setText(wifiBean.getWifiName());
        wifiMac.setText(wifiBean.getWifiMAC());
        wifiList.add(wifiBean.getWifiMAC());
        //给每个删除条目绑定一个id
        iv_del_item.setTag(wifiitemId);
        iv_del_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("确定要删除该wifi吗？");
                builder.setTitle("系统提示");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //获取绑定的id
                        int itemId = (int) v.getTag();
                        //布局中删除指定位置的view
                        mWifiLayout.removeView(wificonditions.get(itemId));
                        //集合中删除指定的item对象
                        wificonditions.remove(itemId);
                        //记录position最新位置
                        wifiposition--;
                        wifiList.remove(itemId);
                        delWifi(wifiBean.getWifiId());
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        //把当前对象保存到集合中
        wificonditions.put(wifiitemId, rl_wifi);*/
        linearLayout.addView(textView);
        //每次添加以后，位置会变动
//        wifiposition++;
        //每调用一次id++，防止重复
//        wifiitemId++;
    }


}
