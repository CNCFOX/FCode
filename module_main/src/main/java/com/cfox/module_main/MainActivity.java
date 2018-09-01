package com.cfox.module_main;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cfox.lib_common.arouter.RouterPath;

import java.util.List;

public class MainActivity extends ActivtyWrapper {

    @Override
    public void initPagerViews(List<PagerInfo> views) {
        Fragment viewFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VIEW_FG).navigation();
        if (viewFg != null) {
            views.add(createPagerInfo(R.string.main_tab_view, R.mipmap.mine_tab_select, R.mipmap.mine_tab_unselect, viewFg));
        }

        Fragment dbFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_DB_FG).navigation();
        if (dbFg != null) {
            views.add(createPagerInfo( R.string.main_tab_db, R.mipmap.mine_tab_select, R.mipmap.mine_tab_unselect, dbFg));
        }

        Fragment mediaFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_MEDIA_FG).navigation();
        if (mediaFg != null) {
            views.add(createPagerInfo( R.string.main_tab_media, R.mipmap.mine_tab_select, R.mipmap.mine_tab_unselect, mediaFg));
        }

        Fragment webviewFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VEBVIEW_FG).navigation();
        if (webviewFg != null) {
            views.add(createPagerInfo(R.string.main_tab_webview, R.mipmap.mine_tab_select, R.mipmap.mine_tab_unselect, webviewFg));
        }
        Fragment mineFg = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_MINE_FG).navigation();
        if (mineFg != null) {
            views.add(createPagerInfo(R.string.main_tab_mine, R.mipmap.mine_tab_select, R.mipmap.mine_tab_unselect, mineFg));
        }
    }
}

