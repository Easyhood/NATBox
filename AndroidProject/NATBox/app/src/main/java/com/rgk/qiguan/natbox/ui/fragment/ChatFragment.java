package com.rgk.qiguan.natbox.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgk.qiguan.natbox.R;

/**
 * 会话的fragment
 */
public class ChatFragment extends BaseFragment {


    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance(){
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }


    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat,container,false);
    }
}

