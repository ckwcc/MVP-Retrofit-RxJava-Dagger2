package com.ckw.zfsoft.mvpanddagger2.global;

import android.content.Context;

import com.ckw.zfsoft.mvpanddagger2.global.base.BaseApplication;
import com.ckw.zfsoft.mvpanddagger2.global.base.BasePresenter;
import com.ckw.zfsoft.mvpanddagger2.global.base.BaseView;
import com.ckw.zfsoft.mvpanddagger2.global.base.CallBackListener;
import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 *  网络请求的工具类
 */
public class HttpManager {

    private static final String TAG = "HttpManager";

    public HttpManager() {

    }

    /**
     * 統一的网络请求
     *
     * @param observable          被观察者
     * @param <T>                 网络返回的数据
     * @param compositeDisposable 用于取消网络请求
     */
    public <T, K extends BasePresenter> void  request(Observable<Response<T>> observable,
                                                      final CompositeDisposable compositeDisposable, final BaseView<K> view,
                                                      final CallBackListener<T> listener) {

        if (observable == null || compositeDisposable == null || view == null || listener == null) {
            return;
        }

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<T>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Response<T> response) {
                        if ( response == null) {//!view.isActive()
                            return;
                        }

                        int code = response.getCode();
                        T data = response.getData();
                        switch (code) {
                        /*
                         * 失败
                         */
                        case 0:
                            listener.onError(response.getMsg());
                            break;

                        /*
                         * 成功
                         */
                        case 1:
                            listener.onSuccess(response.getData());
                            break;

                        /*
                         * token error---跳转到登录界面
                         */
                        case 2:
                            Context context = BaseApplication.getAppComponent().getContext();
                            if (context == null) {
                                return;
                            }

                            break;

                        default:
                            listener.onError(response.getMsg());
                            break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if ( e == null) {//!view.isActive() ||
                            return;
                        }
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            switch (httpException.code()) {
                            /*
                             * 没有网络
                             */
                            case 504:
                                listener.onError(Constant.NET_WORK_ERROR);
                                break;

                            default:
                                listener.onError(Constant.REQUEST_FAILURE);
                                break;
                            }
                            return;
                        }
                        if (e instanceof ConnectException) {
                            listener.onError(Constant.CAN_NOT_CONNECT_TO_SERVER);
                            return;
                        }
                        if (e instanceof SocketException) {
                            listener.onError(Constant.NET_WORK_ERROR);
                            return;
                        }
                        if (e instanceof SocketTimeoutException) {
                            listener.onError(Constant.time_out);
                            return;
                        }
                        if (e instanceof JsonParseException || e instanceof JSONException ||
                                e instanceof MalformedJsonException) {
                            listener.onError(Constant.DATA_PARSE_EXCEPTION);
                            return;
                        }
                        listener.onError(Constant.REQUEST_FAILURE);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * <p>
     * 另外的网络请求
     * </p>
     *
     * created by sy
     * on 2017/6/21
     */
    public <T> void outRequest(Observable<Response<T>> observable, final CallBackListener<T> listener) {
        if (observable == null) {
            return;
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<T>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Response<T> response) {
                        int code = response.getCode();
                        switch (code) {
                        case 0:
                            listener.onError(response.getMsg());
                            break;
                        case 1:
                            listener.onSuccess(response.getData());
                            break;
                        case 2:
                            Context context = BaseApplication.getAppComponent().getContext();
                            if (context == null) {
                                return;
                            }

                            break;

                        default:
                            listener.onError(response.getMsg());
                            break;
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e == null) {
                            return;
                        }
                        if (e instanceof ConnectException) {
                            listener.onError(Constant.CAN_NOT_CONNECT_TO_SERVER);
                            return;
                        }
                        if (e instanceof SocketException) {
                            listener.onError(Constant.NET_WORK_ERROR);
                            return;
                        }
                        if (e instanceof SocketTimeoutException) {
                            listener.onError(Constant.time_out);
                            return;
                        }
                        listener.onError(Constant.REQUEST_FAILURE);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }




}
