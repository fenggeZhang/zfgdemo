package com.zfg.test.activity;


import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.DividerGridItemDecoration;
import com.zfg.test.adapter.DragRecyclerAdapter;
import com.zfg.test.entity.DragContentItemBean;
import com.zfg.test.entity.DragItemBean;
import com.zfg.test.utils.LogUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.zfg.test.adapter.DragRecyclerAdapter.ITEM_CONTENT;
import static com.zfg.test.adapter.DragRecyclerAdapter.ITEM_HEAD;

public class DragGoupActivity extends BaseActivity {

    public static final int SPAN_COUNT = 4;
    private RecyclerView mRecyclerView;
    private DragRecyclerAdapter mAdapter;
    private List<MultiItemEntity> mDragItemBeanList;

    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_drag_goup;
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.drag_recycler);
    }

    @Override
    protected void initData() {
        mDragItemBeanList = new ArrayList<>();
        mDragItemBeanList.add(new DragItemBean(ITEM_HEAD, "分组A"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "A内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "A内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "A内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "A内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "A内容"));
        mDragItemBeanList.add(new DragItemBean(ITEM_HEAD, "分组B"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "B内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "B内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "B内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "B内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "B内容"));
        mDragItemBeanList.add(new DragItemBean(ITEM_HEAD, "分组C"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "C内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "C内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "C内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "C内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "C内容"));
        mDragItemBeanList.add(new DragItemBean(ITEM_HEAD, "分组D"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "D内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "D内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "D内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "D内容"));
        mDragItemBeanList.add(new DragContentItemBean(ITEM_CONTENT, "D内容"));
        mDragItemBeanList.add(new DragItemBean(ITEM_HEAD, "分组E"));
        mDragItemBeanList.add(new DragItemBean(ITEM_HEAD, "分组F"));
        mAdapter = new DragRecyclerAdapter(mDragItemBeanList);
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setAdapter(mAdapter);
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItemViewType(position) == DragRecyclerAdapter.ITEM_CONTENT ? 1 : manager.getSpanCount();
            }
        });
        mRecyclerView.setLayoutManager(manager);
        mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                } else {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                }
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //得到当拖拽的viewHolder的Position
                int fromPosition = viewHolder.getAdapterPosition();
                //拿到当前拖拽到的item的viewHolder
                int toPosition = target.getAdapterPosition();
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(mDragItemBeanList, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(mDragItemBeanList, i, i - 1);
                    }
                }
                mAdapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
                LogUtil.e("onSelectedChanged()");
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE)
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
            }

            /**
             * 重写拖拽可用
             * @return
             */
            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

            /**
             * isItemViewSwipeEnabled返回的也是一个boolean值
             * 它和isLongPressDragEnabled类似。不同的是它控制的是左右滑动效果。
             */
            @Override
            public boolean isItemViewSwipeEnabled() {
                return true;
            }
            /**
             * 手指松开的时候还原
             * @param recyclerView
             * @param viewHolder
             */
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }
        });
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void addListener() {
//        mAdapter.setOnItemDragListener(listener);
    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_drag_title;
    }

    OnItemDragListener listener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            LogUtil.d("drag start");
            BaseViewHolder holder = ((BaseViewHolder) viewHolder);
//                holder.setTextColor(R.id.tv, Color.WHITE);
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
            LogUtil.d("move from: " + source.getAdapterPosition() + " to: " + target.getAdapterPosition());
        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            LogUtil.d("drag end");
            BaseViewHolder holder = ((BaseViewHolder) viewHolder);
        }
    };
}
