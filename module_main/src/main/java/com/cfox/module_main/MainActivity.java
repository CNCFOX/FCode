package com.cfox.module_main;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cfox.lib_common.arouter.RouterPath;

import java.util.List;

public class MainActivity extends ActivtyWrapper {

    private Fragment mViewFg;
    private Fragment mMineFg;
    private Fragment mDbFg;
    private Fragment mMediaFg;
    private Fragment mWebviewFg;
    @Override
    public void initViews(List<Fragment> views) {
        mViewFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VIEW_FG).navigation();
        if (mViewFg != null) views.add(mViewFg);

        mMineFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_MINE_FG).navigation();
        if (mMineFg != null) views.add(mMineFg);

        mDbFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_DB_FG).navigation();
        if (mDbFg != null) views.add(mDbFg);

        mMediaFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_MEDIA_FG).navigation();
        if (mMediaFg != null) views.add(mMediaFg);

        mWebviewFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VEBVIEW_FG).navigation();
        if (mWebviewFg != null) views.add(mWebviewFg);
    }
}

