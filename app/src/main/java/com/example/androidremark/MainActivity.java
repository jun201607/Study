package com.example.androidremark;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.androidremark.banner.Banner1Activity;
import com.example.androidremark.base.BaseActivity;
import com.example.androidremark.bean.MainMenuNameBean;
import com.example.androidremark.network.SocketTestActivity;
import com.example.androidremark.permission.PermissionActivity;
import com.example.androidremark.statusbarutil.StatusBarActivity;
import com.example.androidremark.ui.alerter.ExampleActivity;
import com.example.androidremark.ui.chart.cake.ChartActivity;
import com.example.androidremark.ui.contacts.ContactsActivity;
import com.example.androidremark.ui.interfaceloading.TipActivity;
import com.example.androidremark.ui.flow.FlowLayoutActivity;
import com.example.androidremark.ui.imageview.ScratchActivity;
import com.example.androidremark.ui.layout.CoordinatorLayoutActivity;
import com.example.androidremark.ui.payment.ALiPayActivity;
import com.example.androidremark.ui.popup.PopupTestActivity;
import com.example.androidremark.ui.qq.SwipeMenuActivity;
import com.example.androidremark.ui.recycler.RecyclerViewActivity;
import com.example.androidremark.ui.recycler.sticky.StickyRecyclerActivity;
import com.example.androidremark.ui.textview.span.SpanActivity;
import com.example.androidremark.ui.textview.StrikeTextViewActivity;
import com.example.androidremark.ui2.baserecycler.BaseRecyclerActivity;
import com.example.androidremark.ui2.button.SwitchButtonActivity;
import com.example.androidremark.ui2.calendar.CalendarActivity;
import com.example.androidremark.ui2.grouprecycler.GroupRecyclerActivity;
import com.example.androidremark.ui2.xloadingdialog.XLoadingDialogActivity;
import com.example.androidremark.view.RounProgressActivity;

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
                {"自定义View", "饼形图", "支付完成", "橡皮擦", "日历"},
                {"自定义", "圆进度条", "流式布局", "播放器", "时光轴recycler"},
                {"轮播", "Banner", "粘性reclcler", "XLoadingDialog", "BaseRecycler1"},
                {"网络", "socket", "分组recycler", "", ""},
                {"按钮", "switch", "", "", ""},
                {"弹窗", "PopupWindow", "alerter", "", ""},
                {"状态栏", "状态栏", "CoordinatorLayout", "网易歌单详情", ""},
                {"其他", "魅族通讯录", "QQ侧滑删除", "权限管理", "界面提示"},
                {"textview", "span", "划线textview", "", ""},
                {"动画", "基本动画", "", "", ""},
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
                        //日历
                        launchActivity(CalendarActivity.class, null);
                        break;
                }
                break;
            case 1:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //圆进度条
                        launchActivity(RounProgressActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        //流式布局
                        launchActivity(FlowLayoutActivity.class, null);
                        break;
                    case R.id.tv_view_three:
                        //视频播放器
                        break;
                    case R.id.tv_view_four:
                        //Recyclerview
                        launchActivity(RecyclerViewActivity.class, null);
                        break;
                }
                break;
            case 2:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //banner
                        launchActivity(Banner1Activity.class, null);
                        break;
                    case R.id.tv_view_two:
                        //粘性recycler
                        launchActivity(StickyRecyclerActivity.class, null);
                        break;
                    case R.id.tv_view_three:
                        //XLoadingDialog
                        launchActivity(XLoadingDialogActivity.class, null);
                        break;
                    case R.id.tv_view_four:
                        //BaseRecyclerActivity
                        launchActivity(BaseRecyclerActivity.class, null);
                        break;
                }
                break;
            case 3:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //socket
                        launchActivity(SocketTestActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        //分组recycler
                        launchActivity(GroupRecyclerActivity.class, null);
                        break;
                    case R.id.tv_view_three:
                        break;
                    case R.id.tv_view_four:
                }
                break;
            case 4:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //switch
                        launchActivity(SwitchButtonActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        break;
                    case R.id.tv_view_three:
                        break;
                    case R.id.tv_view_four:
                }
                break;
            case 5:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //弹窗
                        launchActivity(PopupTestActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        //Alerter
                        launchActivity(ExampleActivity.class, null);
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
                        launchActivity(CoordinatorLayoutActivity.class, null);
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
                        //界面提示
                        launchActivity(TipActivity.class, null);
                        break;
                }
                break;
            case 8:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //span
                        launchActivity(SpanActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        //
                        launchActivity(StrikeTextViewActivity.class, null);
                        break;
                    case R.id.tv_view_three:
                        break;
                    case R.id.tv_view_four:
                        break;
                }
                break;
            case 9:
                switch (view.getId()) {
                    case R.id.tv_view_one:
                        //基本动画
                       // launchActivity(SpanActivity.class, null);
                        break;
                    case R.id.tv_view_two:
                        break;
                    case R.id.tv_view_three:
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
