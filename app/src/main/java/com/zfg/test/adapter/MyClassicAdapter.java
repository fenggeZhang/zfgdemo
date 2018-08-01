package com.zfg.test.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zfg.test.R;
import com.zfg.test.entitiy.LevelOne;
import com.zfg.test.entitiy.LevelThree;
import com.zfg.test.entitiy.LevelTwo;

import java.util.List;

/**
 * Created by zfg on 2018/6/27
 */
public class MyClassicAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private Context mContext;
    public static final int LEVEL_ONE = 0;
    public static final int LEVEL_TWO = 1;
    public static final int LEVEL_THREE = 2;

    public MyClassicAdapter(Context context, List<MultiItemEntity> data) {
        super(data);
        this.mContext = context;
        addItemType(LEVEL_ONE, R.layout.level_one);
        addItemType(LEVEL_TWO, R.layout.level_two);
        addItemType(LEVEL_THREE, R.layout.level_three);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {

        switch (item.getItemType()) {

            case LEVEL_ONE:

                final LevelOne one = (LevelOne) item;
                helper.setText(R.id.tv_level_one, one.title);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        if (one.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });


                break;

            case LEVEL_TWO:
                final LevelOne levelTwo = (LevelOne) item;
               /* if (TextUtils.isEmpty(levelTwo.title)) {
                    helper.itemView.setVisibility(View.GONE);
                }else{

                }*/
                helper.setText(R.id.tv_level_two, levelTwo.title);
                helper.getView(R.id.ll_level_two).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        if (levelTwo.isExpanded()) {
                            collapse(pos, true);
                        } else {
                            expand(pos, true);
                        }
                    }
                });

                break;

            case LEVEL_THREE:

                final LevelOne three = (LevelOne) item;
                helper.setText(R.id.tv_level_three, three.title);
//                helper.setText(R.id.tv_level_three_desc, three.getDesc());

            /*    // 判断 记住的状态
                if (three.isChecked) {
                    helper.setChecked(R.id.cb_three, true);
                } else {
                    helper.setChecked(R.id.cb_three, false);
                }*/

                // 设置复选框的点击事件
            /*    helper.getView(R.id.cb_three).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        three.isChecked = !three.isChecked;
                        if (three.isChecked) {
//                            list.add(bean);
                            Log.e("isChecked", "开启了");
                        } else {
//                            list.remove(bean);
                            Log.e("isChecked", "取消了");
                        }

                        // 使用此句可能会造成item 无法伸缩,并有可能造成出现多个 item
                        //     getData().set(helper.getLayoutPosition(), (MultiItemEntity) three);

                    }
                });*/

                break;

        }

    }
}
