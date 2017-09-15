package com.example.androidremark.ui2.baserecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidremark.R;

public class BaseRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_recycler);
    }
}
