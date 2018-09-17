package com.cfox.lib_common.netutils;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : NetStatus
 * <br/>PACKAGE_NAME : com.cfox.netstatus.netutils
 * <br/>AUTHOR : CFOX (https://github.com/CNCFOX)
 * <br/>MSG :
 * <br/>************************************************
 */

public interface NetStatusReceiver {

    void netStatusChanged(NetType netType);
}
