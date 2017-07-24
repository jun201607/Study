package com.example.androidremark.ui.permission;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;

import com.example.androidremark.R;
import com.example.androidremark.base.BaseActivity;
import com.example.androidremark.ui.permission.runtime.PermissionsManager;
import com.example.androidremark.ui.permission.runtime.PermissionsResultAction;
import com.example.androidremark.utils.MyUtils;

import java.io.File;

/**
 * 动态申请权限
 */
public class PermissionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        initView();
        requestPermissions();
    }

    private void initView() {
        //打开相机
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MyUtils.isHavePermission(PermissionActivity.this, Manifest.permission.CAMERA)) {
                    openCamera();
                } else {
                    showAlert("没有相机权限");
                }
            }
        });
    }


    /**
     * 请求权限
     */
    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
                //System.err.println("哈哈---所有权限已经申请");
            }

            @Override
            public void onDenied(String permission) {
                //System.err.println("哈哈---" + permission + "拒绝");
            }
        });
    }

    private String FilePath = "";

    private void openCamera() {
        String state = Environment.getExternalStorageState();
        //SD卡正常
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            FilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "AndroidRemark"
                    + File.separator + "homeCare";
        } else {
            FilePath = "/data/data/com.example.androidremark/files";
        }
        File file = new File(FilePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //---
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(FilePath + "test.jpg")));
        startActivityForResult(intent, 1001);
    }
}
