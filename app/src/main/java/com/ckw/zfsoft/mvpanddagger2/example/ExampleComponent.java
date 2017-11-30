package com.ckw.zfsoft.mvpanddagger2.example;

import com.ckw.zfsoft.mvpanddagger2.global.AppComponent;
import com.ckw.zfsoft.mvpanddagger2.global.base.PerActivity;

import dagger.Component;

/**
 * Created by ckw
 * on 2017/11/30.
 */

@PerActivity
@Component(modules = ExamplePresenterModule.class, dependencies = AppComponent.class)
interface ExampleComponent {

    void inject(ExampleActivity exampleActivity);
}
