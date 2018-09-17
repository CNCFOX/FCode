package com.cfox.lib_common.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cfox.lib_common.netutils.NetTools;

public class BaseApplication extends Application {
    private boolean routerDebug = true;
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        if (routerDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        NetTools.init(this);

    }
}
