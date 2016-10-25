package com.rgk.qiguan.natbox;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : RGK
 * Author     : qi.guan
 * Date       : 2016/10/19 17:22
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化融云
         */
        RongIM.init(this);
    }
}
