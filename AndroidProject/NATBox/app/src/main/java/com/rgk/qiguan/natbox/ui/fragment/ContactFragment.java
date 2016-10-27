package com.rgk.qiguan.natbox.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgk.qiguan.natbox.R;

/**
 * 联系人fragment
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact,container,false);
    }
}
