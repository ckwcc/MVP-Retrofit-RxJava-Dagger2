package com.ckw.zfsoft.mvpanddagger2.global.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *  网络管理的工具类
 */
public class NetworkUtils {

    private NetworkUtils() {

    }

    /**
     * 判读网络是否可用 --- 需要<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> 权限
     *
     * @param context 上下文对象
     * @return true:可用  false:不可用
     */
    public static boolean isConnected(Context context) {
        if (context == null) {
            return false;
        }

        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isConnected();
    }

    //获取NetworkInfo的实例
    private static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }

    /**
     * 是否是wifi环境下
     */
    public static boolean isNetWorkWifiState(Context context){
        NetworkInfo info = getActiveNetworkInfo(context);
        return info.getType() == ConnectivityManager.TYPE_WIFI;
    }
}
