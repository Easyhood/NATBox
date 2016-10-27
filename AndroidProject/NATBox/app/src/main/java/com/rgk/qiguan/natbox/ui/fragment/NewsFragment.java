package com.rgk.qiguan.natbox.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.rgk.qiguan.natbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 新闻资讯的Fragment
 */
public class NewsFragment extends BaseFragment {


    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;
    @BindView(R.id.container_news)
    LinearLayout containerNews;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);

        //TODO 2016年10月27日19:58:49
        return view;
    }
}
