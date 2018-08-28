package com.cfox.fcode;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.cfox.lib_common.base.BaseApplication;

/**
 * Created by Mr.Ma on 2018/8/27.
 */

public class FCodeApplication extends BaseApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
