package com.cfox.module_main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.cfox.lib_common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public abstract class ActivtyWrapper extends BaseActivity {
    private static final String TAG = "ActivtyWrapper";
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MainViewAdapter mAdapter;

    private List<PagerInfo> mViews = new ArrayList<PagerInfo>();

    public abstract void initPagerViews(List<PagerInfo> views);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initPagerViews(mViews);
        initView();
        configView();
    }

    private void configView() {
        mAdapter = new MainViewAdapter(this,getSupportFragmentManager(), mViews);
        mViewPager.setAdapter(mAdapter);
        setTabs(mTabLayout,mViews);
    }

    private void initView() {
        mViewPager = findViewById(R.id.main_view_vp);
        mTabLayout = findViewById(R.id.main_tab);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addOnTabSelectedListener(mTabSelectListener);
        mTabLayout.setSelectedTabIndicatorHeight(0);
    }

    PagerInfo createPagerInfo(int titleRes, int selectImgRes, int unSelectImgRes, Fragment pager) {
        PagerInfo pagerInfo = new PagerInfo();
        pagerInfo.setTitleRes(titleRes);
        pagerInfo.setSelectImgRes(selectImgRes);
        pagerInfo.setUnSelectImgRes(unSelectImgRes);
        pagerInfo.setPager(pager);
        return pagerInfo;
    }


    private void setTabs(TabLayout tabLayout, List<PagerInfo> viewInfos) {

        int tabCount = tabLayout.getTabCount();
        for (int i = 0 ; i < tabCount; i ++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            PagerInfo pagerInfo = viewInfos.get(i);
//            tab.setText(pagerInfo.getTitleRes());
//            tab.setIcon(pagerInfo.getUnSelectImgRes());
            if (tab == null) return;
            tab.setCustomView(bindTabView(mViews.get(i)));
        }
    }

    private TabLayout.OnTabSelectedListener mTabSelectListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getCustomView() == null) return;
            tab.getCustomView().setSelected(true);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            if (tab.getCustomView() == null) return;
            tab.getCustomView().setSelected(false);
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    private View bindTabView(PagerInfo info) {
        TabView tabView = TabView.createTabView(this,R.layout.main_tab_item);
        return tabView.build();
    }
}
