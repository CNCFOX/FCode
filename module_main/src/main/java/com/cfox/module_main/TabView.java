package com.cfox.module_main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.nio.channels.Selector;


public class TabView {

    private View mTabView;

    public TabView(Context context, int viewRes) {
        mTabView = LayoutInflater.from(context).inflate(viewRes, null);
    }

    public static TabView createTabView(Context context, int viewRes) {
        return new TabView(context,viewRes);
    }


    public View build() {
        return mTabView;
    }


    private Selector createImgSelec() {
        return null;

    }
}
