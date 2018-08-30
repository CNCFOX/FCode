package com.cfox.lib_common.base;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApplication extends Application {
    private boolean routerDebug = true;
    @Override
    public void onCreate() {
        super.onCreate();

        if (routerDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

    }
}
