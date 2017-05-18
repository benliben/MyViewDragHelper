package com.android.benben.myviewdraghelper.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.benben.myviewdraghelper.R;

/**
 * Time      2017/5/17 15:23 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class OneFragment extends Fragment {
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mView==null){
            mView=inflater.inflate(R.layout.one_frag_layout,container,false);
        }
        return mView;
    }
}
