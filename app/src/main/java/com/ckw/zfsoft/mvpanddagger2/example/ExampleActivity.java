package com.ckw.zfsoft.mvpanddagger2.example;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.ckw.zfsoft.mvpanddagger2.R;
import com.ckw.zfsoft.mvpanddagger2.global.utils.ActivityUtils;
import com.ckw.zfsoft.mvpanddagger2.global.base.BaseActivity;

import javax.inject.Inject;

public class ExampleActivity extends BaseActivity {
    private FragmentManager manager;
    private ExampleFragment mFragment;

    @Inject
    ExamplePresenter mPresenter;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_example;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mFragment = (ExampleFragment) manager.findFragmentById(R.id.rl_activity_container);
        if (mFragment == null) {
            mFragment = new ExampleFragment();
            ActivityUtils.addFragmentToActivity(manager, mFragment, R.id.rl_activity_container);
        }
    }

    @Override
    protected void setUpInject() {
        DaggerExampleComponent.builder()
                .appComponent(getAppComponent())
                .examplePresenterModule(new ExamplePresenterModule(mFragment))
                .build()
                .inject(this);
    }

    @Override
    protected void initVariables() {
        manager = getSupportFragmentManager();
    }
}
