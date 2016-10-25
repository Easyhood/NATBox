package com.rgk.qiguan.natbox.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgk.qiguan.natbox.R;

/**
 * 新闻资讯的Fragment
 */
public class NewsFragment extends BaseFragment {


    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(){
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }


    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,container,false);
    }
}
