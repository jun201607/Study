package com.example.androidremark.ui.qq;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.androidremark.R;
import com.example.androidremark.base.BaseActivity;
import com.example.androidremark.utils.StatusBarUtil;

/**
 * QQ空间
 */
public class QQZoneActivity extends BaseActivity {

    private LinearLayout TopBar;
    private QqZoneTopBarListView qqZoneTopBarListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 让状态了成半透明状态
         */
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        /**
         * 为了达到效果将状态栏设置沉浸式状态栏
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_qqzone);
        initViews();

    }

    private void initViews() {
        TopBar = (LinearLayout) findViewById(R.id.TopBar);
        qqZoneTopBarListView = (QqZoneTopBarListView) findViewById(R.id.qq_list_view);
        qqZoneTopBarListView.setTopBar(TopBar);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTranslucent(this,50);
    }
}
