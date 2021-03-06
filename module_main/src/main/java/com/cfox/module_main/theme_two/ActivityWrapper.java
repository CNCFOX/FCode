package com.cfox.module_main.theme_two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.cfox.lib_common.base.BaseActivity;
import com.cfox.module_main.PagerInfo;
import com.cfox.module_main.R;
import com.cfox.module_main.TabView;

import java.util.ArrayList;
import java.util.List;

public abstract class ActivityWrapper extends BaseActivity{

    private List<PagerInfo> mViews = new ArrayList<PagerInfo>();
    private TabLayout mTabLayout;

    private FragmentManager mManager;
    private Fragment mCurrentViewFg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_two_activity);
        mManager = getSupportFragmentManager();
        initPagerInfos(mViews);
        initView();
        initTab();
    }

    private void initView() {
        mTabLayout = findViewById(R.id.main_tab_layout);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.addOnTabSelectedListener(mTabSelectListener);
        mTabLayout.setSelectedTabIndicatorHeight(0);
    }

    private void initTab() {
        int tabCount = mViews.size();
        for (int i = 0 ; i < tabCount; i ++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setCustomView(bindTabView(mViews.get(i)));
            mTabLayout.addTab(tab,i);
        }
    }


    PagerInfo createPagerInfo(String flag, int titleRes, int selectImgRes, int unSelectImgRes) {
        PagerInfo pagerInfo = new PagerInfo();
        pagerInfo.setFlag(flag);
        pagerInfo.setTitleRes(titleRes);
        pagerInfo.setSelectImgRes(selectImgRes);
        pagerInfo.setUnSelectImgRes(unSelectImgRes);
        return pagerInfo;
    }

    private TabLayout.OnTabSelectedListener mTabSelectListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getCustomView() == null) return;
            tab.getCustomView().setSelected(true);
            showView((String) tab.getCustomView().getTag());
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
        tabView.setTabTile(info.getTitleRes());
        tabView.setIconStatus(info.getSelectImgRes(), info.getUnSelectImgRes());
        return tabView.build(info.getFlag());
    }

    private void showView(String viewFlag) {
        FragmentTransaction transaction = mManager.beginTransaction();
        Fragment fragment = mManager.findFragmentByTag(viewFlag);

        if (mCurrentViewFg != null) {
            transaction.detach(mCurrentViewFg);
            transaction.hide(mCurrentViewFg);
        }

        if (fragment == null) {
            fragment = createView(viewFlag);
            transaction.add(R.id.main_content, fragment, viewFlag);
            transaction.attach(fragment);
        } else {
            transaction.attach(fragment);
            transaction.show(fragment);
        }
        mCurrentViewFg = fragment;
        transaction.commit();

    }

    public abstract void initPagerInfos(List<PagerInfo> views);
    public abstract Fragment createView(String flag);

}
