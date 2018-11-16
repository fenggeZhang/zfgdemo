package com.zfg.test.activity.loaddata;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.adapter.LoadMoreAdapter;
import com.zfg.test.entity.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zfg
 * @create 2018/11/15
 * @Describe 加载更多
 */
public class LoadMoreDataActivity extends BaseActivity {
    public static final int PAGE_SIZE = 10;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LoadMoreAdapter mLoadMoreAdapter;
    private int mNextRequestPage = 1;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_load_more_data;
    }

    @Override
    protected void setupView() {
        mRecyclerView = findViewById(R.id.my_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSwipeRefreshLayout = findViewById(R.id.my_swipe_rl);
    }

    @Override
    protected void initData() {
        mLoadMoreAdapter = new LoadMoreAdapter();
        mRecyclerView.setAdapter(mLoadMoreAdapter);
    }

    @Override
    protected void addListener() {
        mLoadMoreAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        }, mRecyclerView);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void loadMore() {
        setData(false, getSampleData(8));
    }

    /**
     * 刷新
     */
    private void refresh() {
        mNextRequestPage = 1;
        mLoadMoreAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        setData(true, getSampleData(10));
        mLoadMoreAdapter.setEnableLoadMore(true);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected int getTitleStringId() {
        return 0;
    }

    private void setData(boolean isRefresh, List data) {
        mNextRequestPage++;
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {
            mLoadMoreAdapter.setNewData(data);
        } else {
            if (size > 0) {
                mLoadMoreAdapter.addData(data);
            }
        }
        if (size < PAGE_SIZE) {
            //第一页如果不够一页就不显示没有更多数据布局
            mLoadMoreAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
        } else {
            mLoadMoreAdapter.loadMoreComplete();
        }
    }

    public static List<Status> getSampleData(int lenth) {
        List<Status> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            Status status = new Status();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("BaseRecyclerViewAdpaterHelper https://www.recyclerview.org");
            list.add(status);
        }
        return list;
    }
}
