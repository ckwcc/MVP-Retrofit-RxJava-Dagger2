package com.ckw.zfsoft.mvpanddagger2.example;

import com.ckw.zfsoft.mvpanddagger2.example.repository.NearbyPerson;
import com.ckw.zfsoft.mvpanddagger2.global.base.CallBackListener;
import com.ckw.zfsoft.mvpanddagger2.global.HttpManager;
import com.ckw.zfsoft.mvpanddagger2.global.RetrofitService;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by ckw
 * on 2017/11/30.
 */

public class ExamplePresenter implements ExampleContract.Presenter {

    private ExampleContract.View mView;
    private RetrofitService mRetrofitService;
    private CompositeDisposable mCompositeDisposable;
    private HttpManager mHttpManager;

    public ExamplePresenter(ExampleContract.View mView, RetrofitService mRetrofitService, HttpManager mHttpManager) {
        this.mView = mView;
        mView.setPresenter(this);
        this.mRetrofitService = mRetrofitService;
        this.mHttpManager = mHttpManager;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void cancelRequest() {
        mCompositeDisposable.clear();
    }

    @Override
    public void getExampleData(String name, String longitude, String latitude, String sex) {
        mHttpManager.request(mRetrofitService.getNearbyPersonList(name, longitude, latitude, sex), mCompositeDisposable,
                mView, new CallBackListener<List<NearbyPerson>>() {
                    @Override
                    public void onSuccess(List<NearbyPerson> data) {
                        mView.showExampleData(data);
                    }

                    @Override
                    public void onError(String errorMsg) {
                        mView.showExampleError(errorMsg);
                    }
                });
    }
}
