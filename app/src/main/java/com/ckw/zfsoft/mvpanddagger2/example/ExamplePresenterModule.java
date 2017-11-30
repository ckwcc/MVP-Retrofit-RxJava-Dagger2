package com.ckw.zfsoft.mvpanddagger2.example;

import android.util.Log;

import com.ckw.zfsoft.mvpanddagger2.global.HttpManager;
import com.ckw.zfsoft.mvpanddagger2.global.RetrofitService;
import com.ckw.zfsoft.mvpanddagger2.global.base.PerActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ckw
 * on 2017/11/30.
 */

@Module
class ExamplePresenterModule {
    private ExampleContract.View mView;

    public ExamplePresenterModule(ExampleContract.View mView) {
        this.mView = mView;
    }

    @PerActivity
    @Provides
    ExamplePresenter provideExamplePresenter(RetrofitService retrofitService, HttpManager httpManager){
        return new ExamplePresenter(mView,retrofitService,httpManager);
    }

    @Provides
    RetrofitService provideRetrofitService(Retrofit retrofit){
        return retrofit.create(RetrofitService.class);
    }



}
