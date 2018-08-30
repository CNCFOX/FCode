package com.cfox.fcode;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.cfox.lib_common.base.BaseApplication;

public class FCodeApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
