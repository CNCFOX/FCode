package com.cfox.module_main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class MainViewAdapter extends FragmentPagerAdapter {

    private List<Fragment> mPages;

    public MainViewAdapter(FragmentManager fm, List<Fragment> pages) {
        super(fm);
        mPages = pages;
    }

    @Override
    public Fragment getItem(int position) {
        return mPages.get(position);
    }

    @Override
    public int getCount() {
        return mPages.size();
    }
}
