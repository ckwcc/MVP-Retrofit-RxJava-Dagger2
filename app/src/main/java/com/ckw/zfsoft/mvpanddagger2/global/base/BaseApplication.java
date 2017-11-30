package com.ckw.zfsoft.mvpanddagger2.global.base;

import android.app.Application;
import android.util.Log;

import com.ckw.zfsoft.mvpanddagger2.global.AppComponent;
import com.ckw.zfsoft.mvpanddagger2.global.AppModule;
import com.ckw.zfsoft.mvpanddagger2.global.DaggerAppComponent;

/**
 * Created by ckw
 * on 2017/11/30.
 */

public class BaseApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }


    //初始化Component
    private void initComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
    /**
     * 获取AppComponent实例
     *
     * @return AppComponent实例
     */
    public static AppComponent getAppComponent() {
        if(appComponent == null){
            Log.d("----", "getAppComponent: 为空");
        }
        return appComponent;
    }
}
