package com.cfox.module_view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cfox.lib_common.arouter.RouterPath;
import com.cfox.lib_common.base.BaseFragment;

@Route(path = RouterPath.MAIN_VIEW_FG)
public class ViewMainFragment extends BaseFragment {

    private static final String TAG = "ViewMainFragment";

    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.view_main_fragment, null);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

    }

    private void initView() {

    }
}
