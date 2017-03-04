package com.color.function.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jstelcom.colorshape.R;

/**
 * 发现模块Fragment
 */
public class DiscoverFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        return view;
    }

}
