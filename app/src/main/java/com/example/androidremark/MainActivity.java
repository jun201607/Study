package com.example.androidremark;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.androidremark.base.BaseActivity;
import com.example.androidremark.bean.MainMenuNameBean;
import com.example.androidremark.statusbarutil.StatusBarActivity;
import com.example.androidremark.ui.contacts.ContactsActivity;
import com.example.androidremark.ui.chart.cake.ChartActivity;
import com.example.androidremark.ui.flow.FlowLayoutActivity;
import com.example.androidremark.ui.imageview.ScratchActivity;
import com.example.androidremark.ui.payment.ALiPayActivity;
import com.example.androidremark.ui.permission.PermissionActivity;
import com.example.androidremark.ui.popup.PopupTestActivity;
import com.example.androidremark.ui.qq.SwipeMenuActivity;
import com.example.androidremark.ui.textview.StrikeTextViewActivity;
import com.example.androidremark.widget.StrikeTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements MainMenuItemListener {
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        //
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar(toolbar, "学习笔记", false);
        //
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MainAdapter(this);
        mAdapter.setOnItemClickListener(this);
        initData();
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 在这里添加菜单的数据
     */
    private void initData() {
        List<MainMenuNameBean> list = new ArrayList<>();
        String[][] array = {
                {"自定义View", "饼形图", "支付完成", "橡皮擦", "划线textview"},
                {"自定义ViewGroup", "", "流式布局", "", ""},
                {"属性动画+Path", "PathMeasure", "Path+SVG", "ViewPropertyAnimator", ""},
                {"贝塞尔曲线", "基本用法示例", "", "", ""},
                {"图片加载", "Volley(TODO)", "Glide(TODO)", "", "", ""},
                {"弹窗", "PopupWindow", "", "", "", ""},
                {"状态栏", "状态栏", "", "", "", ""},
                {"其他", "魅族通讯录", "QQ侧滑删除", "权限管理", "调用相机剪裁", ""},
        };
        for (String[] anArray : array) {
            list.add(new MainMenuNameBean(anArray[0], anArray[1], anArray[2], anArray[3], anArray[4]));
        }
        mAdapter.setList(list);
    }

    /**
     * recyclerView的点击事件监听
     *
     * @param view     控件
     * @param position 位置
     */
    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                //自定义View
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        launchActivity(ChartActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        launchActivity(ALiPayActivity.class, null);
                        break;
                    case R.id.tv_view_three:
                        launchActivity(ScratchActivity.class, null);
                        break;
                    case R.id.tv_view_four:
                        launchActivity(StrikeTextViewActivity.class, null);
                        break;
                }
                break;
            case 1:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        break;
                    case R.id.tv_view_two:
                        //流式布局
                        launchActivity(FlowLayoutActivity.class, null);
                        break;
                    case R.id.tv_view_three:
                        break;
                    case R.id.tv_view_four:
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //弹窗
                        launchActivity(PopupTestActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        break;
                    case R.id.tv_view_three:
                        break;
                    case R.id.tv_view_four:
                }
                break;
            case 6:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //状态栏
                        launchActivity(StatusBarActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        break;
                    case R.id.tv_view_three:
                        break;
                    case R.id.tv_view_four:
                        break;
                }
                break;
            case 7:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //仿魅族通讯录
                        launchActivity(ContactsActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        //QQ侧滑删除
                        launchActivity(SwipeMenuActivity.class, null);
                        break;
                    case R.id.tv_view_three:
                        //权限
                        launchActivity(PermissionActivity.class, null);
                        break;
                    case R.id.tv_view_four:

                        break;
                }
                break;
            default:
                break;
        }

    }
}
