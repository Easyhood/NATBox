package com.rgk.qiguan.natbox.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgk.qiguan.natbox.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends BaseFragment {


    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance(){
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }


    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact,container,false);
    }
}
