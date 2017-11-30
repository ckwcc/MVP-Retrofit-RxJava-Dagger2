package com.ckw.zfsoft.mvpanddagger2.global.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Fragment添加到Activity上的工具类
 */
public class ActivityUtils {

    private static final String TAG = "ActivityUtils";

    private ActivityUtils() {

    }

    /**
     * 把Fragment添加到Activity上
     *
     * @param manager         FragmentManager的实例
     * @param fragment        Fragment的实例
     * @param containerViewId 布局id
     */
    public static void addFragmentToActivity(FragmentManager manager, Fragment fragment,
                                             int containerViewId) {

        if (manager == null || fragment == null || fragment.isAdded()) {

            return;
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerViewId, fragment);
        transaction.commit();
    }

    /**
     * 把Fragment添加到Activity上
     *
     * @param manager         FragmentManager的实例
     * @param fragment        Fragment的实例
     * @param containerViewId 布局id
     * @param tag             索引
     */
    public static void addFragmentToActivityWithTag(FragmentManager manager, Fragment fragment,
                                                    int containerViewId, String tag) {
        if (manager == null || fragment == null || tag == null || fragment.isAdded()) {

            return;
        }
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerViewId, fragment, tag);
        transaction.commit();
    }

}
