package com.cfox.module_main.theme_two;


import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cfox.lib_common.arouter.RouterPath;
import com.cfox.module_main.PagerInfo;
import com.cfox.module_main.R;

import java.util.List;

public class MainTwoActivity extends ActivityWrapper{

    private static final String TAB_FLAG_VIEW       = "view";
    private static final String TAB_FLAG_DB         = "db";
    private static final String TAB_FLAG_MEDIA      = "media";
    private static final String TAB_FLAG_VEBVIEW    = "webview";
    private static final String TAB_FLAG_MINE       = "mine";


    @Override
    public void initPagerInfos(List<PagerInfo> views) {
        views.add(createPagerInfo(TAB_FLAG_VIEW,R.string.main_tab_view, R.mipmap.main_tab_mine_select, R.mipmap.main_tab_mine_unselect));
        views.add(createPagerInfo(TAB_FLAG_DB,R.string.main_tab_db, R.mipmap.main_tab_mine_select, R.mipmap.main_tab_mine_unselect));
        views.add(createPagerInfo(TAB_FLAG_MEDIA, R.string.main_tab_media, R.mipmap.main_tab_mine_select, R.mipmap.main_tab_mine_unselect));
        views.add(createPagerInfo(TAB_FLAG_VEBVIEW,R.string.main_tab_webview, R.mipmap.main_tab_mine_select, R.mipmap.main_tab_mine_unselect));
        views.add(createPagerInfo(TAB_FLAG_MINE,R.string.main_tab_mine, R.mipmap.main_tab_mine_select, R.mipmap.main_tab_mine_unselect));
    }

    @Override
    public Fragment createView(String flag) {
        Fragment fragmentView = null;
        switch (flag) {
            case TAB_FLAG_VIEW:
                fragmentView = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VIEW_FG).navigation();
                break;
            case TAB_FLAG_DB:
                fragmentView = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_DB_FG).navigation();
                break;
            case TAB_FLAG_MEDIA:
                fragmentView = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_MEDIA_FG).navigation();
                break;
            case TAB_FLAG_VEBVIEW:
                fragmentView = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_VEBVIEW_FG).navigation();
                break;
            case TAB_FLAG_MINE:
                fragmentView = (Fragment) ARouter.getInstance().build(RouterPath.MAIN_MINE_FG).navigation();
                break;

            default:
        }

        return fragmentView;
    }
}
