package com.cfox.module_main;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cfox.lib_common.arouter.RouterPath;

import java.util.List;

public class MainActivity extends ActivtyWrapper {

    private Fragment mViewFg;
    @Override
    public void initViews(List<Fragment> views) {
        mViewFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VIEW_FG).navigation();
        if (mViewFg != null) views.add(mViewFg);
    }
}

