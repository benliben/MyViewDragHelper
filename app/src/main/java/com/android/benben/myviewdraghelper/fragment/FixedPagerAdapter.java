package com.android.benben.myviewdraghelper.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Time      2017/5/17 15:25 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class FixedPagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles;
    private List<Fragment> fragments;
    public FixedPagerAdapter(FragmentManager fm) {
        super(fm);
        titles=new String[]{"第一个","第二个","第三个","第四个"};
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }
    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment=null;
        try {
            fragment=(Fragment)super.instantiateItem(container,position);
        }catch (Exception e){

        }
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return titles[position % titles.length];
    }

    public List<Fragment> getFragments() {
        return fragments;
    }
    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }
}
