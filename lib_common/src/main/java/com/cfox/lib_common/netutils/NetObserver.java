package com.cfox.lib_common.netutils;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : NetStatus
 * <br/>PACKAGE_NAME : com.cfox.netstatus.netutils
 * <br/>AUTHOR : CFOX (https://github.com/CNCFOX)
 * <br/>MSG :
 * <br/>************************************************
 */

public class NetObserver {

    private static NetStatusReceiver sGlobalReceiver;
    private static NetStatusReceiver sNetStatusReceiver;

    /**
     * 注册全局回调,全局网络状态改变时,每次都会回调,主要用于设置全局网络状态使用
     * @param netStatusReceiver
     */
    public static synchronized void registerlGlobalReceiver(NetStatusReceiver netStatusReceiver){
        sGlobalReceiver = netStatusReceiver;
    }

    /**
     * 获取全局回调
     * @return
     */
    public static NetStatusReceiver getGlobalReceiver(){
        return sGlobalReceiver;
    }

    /**
     * 取消注册的全局回调
     */
    public static void unGlobalRegister(){
        sGlobalReceiver = null;
    }

    /**
     * 注册回调
     * @param netStatusReceiver
     */
    public static synchronized void register(NetStatusReceiver netStatusReceiver){
        sNetStatusReceiver = netStatusReceiver;
    }

    /**
     * 取消
     */
    public static void unregister(){
        sNetStatusReceiver = null;
    }

    public static NetStatusReceiver  getNetStatusReceiver(){
        return sNetStatusReceiver;
    }
}
