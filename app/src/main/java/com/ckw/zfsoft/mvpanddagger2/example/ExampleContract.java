package com.ckw.zfsoft.mvpanddagger2.example;

import com.ckw.zfsoft.mvpanddagger2.example.repository.NearbyPerson;
import com.ckw.zfsoft.mvpanddagger2.global.base.BasePresenter;
import com.ckw.zfsoft.mvpanddagger2.global.base.BaseView;

import java.util.List;

/**
 * Created by ckw
 * on 2017/11/30.
 */

public interface ExampleContract {
    interface View extends BaseView<ExamplePresenter>{
        void showExampleData(List<NearbyPerson> data);
        void showExampleError(String msg);
    }

    interface Presenter extends BasePresenter{
        void getExampleData(String name,String longitude,String latitude,String sex);
    }
}
