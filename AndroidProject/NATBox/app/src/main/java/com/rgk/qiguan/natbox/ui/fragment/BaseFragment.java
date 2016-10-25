package com.rgk.qiguan.natbox.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : RGK
 * Author     : qi.guan
 * Date       : 2016/10/21 15:58
 */

/**
 * 所有Fragment的基类，处理一些公共的方法
 */
public abstract class BaseFragment extends Fragment {

    public Activity mActivity;//当做context使用，HomeActivity
    public View mRootView; //fragment的根布局

    /**
     * Fragment的创建
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取fragment所依赖的activity的对象
        mActivity = getActivity();
    }
    /**
     * 初始化Fragment布局
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = initView(inflater,container,savedInstanceState);
        return mRootView;
    }

    /**
     * Fragment所在Activity创建完成
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    /**
     * 初始化布局，必须由子类来实现
     */
    public abstract View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * 初始化数据，子类可以不实现
     */
    public void initData(){

    }
}
