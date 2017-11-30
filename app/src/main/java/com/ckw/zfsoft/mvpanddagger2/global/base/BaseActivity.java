package com.ckw.zfsoft.mvpanddagger2.global.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ckw.zfsoft.mvpanddagger2.global.AppComponent;

/**
 * Created by ckw
 * on 2017/11/30.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        initVariables();
        initViews(savedInstanceState);
        setUpInject();
    }

    /**
     * 获取全局的组件
     *
     * @return AppComponent的实例
     */
    protected AppComponent getAppComponent() {
        return BaseApplication.getAppComponent();
    }

    /**
     * 获取布局文件
     *
     * @return 布局文件id
     */
    protected abstract int getLayoutResID();

    /**
     * 初始化控件
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 注入
     */
    protected abstract void setUpInject();

    /**
     * 初始化变量---如:list adapter
     */
    protected abstract void initVariables();
}
