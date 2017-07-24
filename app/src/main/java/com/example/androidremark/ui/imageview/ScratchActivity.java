package com.example.androidremark.ui.imageview;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.androidremark.R;
import com.example.androidremark.base.BaseActivity;
import com.example.androidremark.utils.StatusBarUtil;

/**
 * 橡皮擦 一般用于抽奖
 */
public class ScratchActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar(toolbar, "橡皮擦view", true);
        toolbar.setBackgroundResource(R.color.green_deep_color);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.green_deep_color),30);
    }
}
