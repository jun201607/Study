package com.example.androidremark.ui2.baserecycler;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidremark.R;
import com.example.androidremark.banner.GlideImageLoader;
import com.example.androidremark.base.BaseActivity;
import com.example.androidremark.utils.MyUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseRecyclerActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecyclerView;
    private TestmAdapter mAdapter;
    private List<String> datas;
    private Handler mHandler = new Handler();
    private SwipeRefreshLayout mSwipeLayout;
    private List<String> mList;
    private List<String> mList2;
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler);
        datas = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            datas.add("第 " + i + " 个");
        }
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar(toolbar, "recyclermAdapter", true);

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(R.color.main_color);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#C4C4C4"), 2));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        mAdapter = new TestmAdapter(mRecyclerView, datas);
        View headView = LayoutInflater.from(this).inflate(R.layout.layout_banner, null);
        banner = (Banner) headView.findViewById(R.id.banner1);
        mList = new ArrayList<>();
        mList.add("http://img.zcool.cn/community/01b72057a7e0790000018c1bf4fce0.png");
        mList.add("http://img.zcool.cn/community/01fca557a7f5f90000012e7e9feea8.jpg");
        mList.add("http://img.zcool.cn/community/01996b57a7f6020000018c1bedef97.jpg");
        mList.add("http://img.zcool.cn/community/01700557a7f42f0000018c1bd6eb23.jpg");

        mList2 = new ArrayList<>();
        mList2.add("1");
        mList2.add("2");
        mList2.add("3");
        mList2.add("4");

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.update(mList, mList2);
        banner.start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                toast("我是第" + (position + 1) + "个");
            }
        });
        mAdapter.addHeaderView(headView);

        //点击事件
        mAdapter.setOnItemClickListener(new XRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                toast("点击第" + position);
            }
        });
        mAdapter.isLoadMore(true);
        mAdapter.setOnLoadMoreListener(new XRecyclerViewAdapter.OnLoadMoreListener() {
            @Override
            public void onRetry() {//加载失败，重新加载回调方法
                // load();
                toast("11");
            }

            @Override
            public void onLoadMore() {//加载更多回调方法
                load();
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }


    public void load() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                //模拟几种错误情况和正确情况
                int random = new Random().nextInt(10);
                if (random < 3) {
                    mAdapter.showLoadError();//显示加载错误
                } else if (random >= 3 && random < 6) {
                    mAdapter.showLoadComplete();//没有更多数据了
                } else {
                    mAdapter.addAll(getDatas("新增加"));//加载更多
                }
            }
        }, 2000);
    }

    public List<String> getDatas(String str) {
        List<String> datas = new ArrayList<>();
//        int random = new Random().nextInt(10);
//        for (int i = 1; i <= random; i++) {
//            datas.add(str + " 第 " + i + " 个");
//        }
//        Log.e("--", str + "  " + datas.size());
        datas.add(str);
        return datas;
    }


    @Override
    protected void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void onRefresh() {
        mAdapter.isLoadMore(false);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.setDataList(getDatas("刷新"));
                mSwipeLayout.setRefreshing(false);

            }
        }, 2000);
    }


    class TestmAdapter extends XRecyclerViewAdapter<String> {

        public TestmAdapter(@NonNull RecyclerView mRecyclerView, List<String> dataLists) {
            super(mRecyclerView, dataLists, R.layout.dome_item);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {
            TextView textView = (TextView) holder.getConvertView().findViewById(R.id.text);
            textView.setText(data);
        }
    }
}

