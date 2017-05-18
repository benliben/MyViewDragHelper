package com.android.benben.myviewdraghelper.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.benben.myviewdraghelper.R;

/**
 * Time      2017/5/17 15:21 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class TwoFragment extends Fragment {
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.two_frag_layout,container,false);
        }
        return mView;
    }
}
