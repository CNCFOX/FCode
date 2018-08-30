package com.cfox.module_main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.cfox.lib_common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;


public abstract class ActivtyWrapper extends BaseActivity {
    private ViewPager mMainView;
    private MainViewAdapter mAdapter;

    private List<Fragment> mViews = new ArrayList<Fragment>();

    public abstract void initViews(List<Fragment> views);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initViews(mViews);
        mAdapter = new MainViewAdapter(getSupportFragmentManager(), mViews);
        mMainView = findViewById(R.id.main_view_vp);
        mMainView.setAdapter(mAdapter);

    }
}
