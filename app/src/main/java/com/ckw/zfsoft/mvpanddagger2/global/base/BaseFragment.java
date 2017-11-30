package com.ckw.zfsoft.mvpanddagger2.global.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ckw.zfsoft.mvpanddagger2.global.AppComponent;

/**
 * Created by ckw
 * on 2017/11/30.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView<T> {

    protected T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariables();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (inflater == null) {
            return null;
        }
        return inflater.inflate(getLayoutResID(), container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (view == null) {
            return;
        }
        initViews(view);
    }

    @Override
    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

    /**
     * 初始化变量---如list adapter FragmentManager
     */
    protected abstract void initVariables();

    /**
     * 获取布局文件
     *
     * @return 布局文件的id
     */
    protected abstract int getLayoutResID();

    /**
     * 初始化控件
     *
     * @param view 布局文件的跟布局
     */
    protected abstract void initViews(View view);

    /**
     * 获取全局的组件
     *
     * @return AppComponent的实例
     */
    protected AppComponent getAppComponent() {
        return BaseApplication.getAppComponent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.cancelRequest();
        }
    }
}
