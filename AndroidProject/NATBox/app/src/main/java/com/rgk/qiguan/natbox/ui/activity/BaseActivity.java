package com.rgk.qiguan.natbox.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rgk.qiguan.natbox.App;
import com.rgk.qiguan.natbox.R;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : RGK
 * Author     : qi.guan
 * Date       : 2016/10/20 10:33
 */

public class BaseActivity extends AppCompatActivity {

    public App application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (App) getApplication();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.from_right_in,R.anim.from_left_out);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.from_left_in,R.anim.from_right_out);
    }

}
