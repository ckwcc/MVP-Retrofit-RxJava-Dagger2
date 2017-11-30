package com.ckw.zfsoft.mvpanddagger2.example;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ckw.zfsoft.mvpanddagger2.R;
import com.ckw.zfsoft.mvpanddagger2.example.repository.NearbyPerson;
import com.ckw.zfsoft.mvpanddagger2.global.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by ckw
 * on 2017/11/30.
 */

public class ExampleFragment extends BaseFragment<ExamplePresenter> implements ExampleContract.View{

    private TextView mShow;
    private Button mButton;


    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_example;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(View view) {
        mButton = view.findViewById(R.id.btn_click);
        mShow = view.findViewById(R.id.tv_show);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * "userid": "607",
                 "userpic": "/Uploads/s_5997adc3d3a85.png",
                 "longitude": "108.895002706077776",
                 "latitude": "34.241995671795905"
                 */
                presenter.getExampleData("607","108.895002706077776","34.241995671795905","");
            }
        });
    }

    @Override
    public void showExampleData(List<NearbyPerson> data) {
        mShow.setText(data.toString());
    }

    @Override
    public void showExampleError(String msg) {
        mShow.setText(msg);
    }
}
