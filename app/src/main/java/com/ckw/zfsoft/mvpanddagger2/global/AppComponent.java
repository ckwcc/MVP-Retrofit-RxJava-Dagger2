package com.ckw.zfsoft.mvpanddagger2.global;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by ckw
 * on 2017/11/30.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    /**
     * 获取上下文对象
     *
     * @return context
     */
    Context getContext();

    /**
     * 获取Gson对象
     *
     * @return Gson实例
     */
    Gson getGson();

    /**
     * 获取Retrofit对象
     *
     * @return Retrofit实例
     */
    Retrofit getRetrofit();

    /**
     * 获取HttpHelper
     *
     * @return HttpHelper的实例
     */
    HttpManager getHttpHelper();
}
