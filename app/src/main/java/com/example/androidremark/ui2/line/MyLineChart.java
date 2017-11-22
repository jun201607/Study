package com.example.androidremark.ui2.line;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cb on 2017/11/1.
 */

public class MyLineChart extends View {


    public MyLineChart(Context context) {
        this(context, null);
    }

    public MyLineChart(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLineChart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }
}
