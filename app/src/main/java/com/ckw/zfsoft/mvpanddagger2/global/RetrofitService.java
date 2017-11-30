package com.ckw.zfsoft.mvpanddagger2.global;


import com.ckw.zfsoft.mvpanddagger2.example.repository.NearbyPerson;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ckw
 * on 2017/11/29.
 */

public interface RetrofitService {
    String BASEURL="http://www.l-zh.com/";

    //用于测试的接口
    //附近的人 获取周边的人
    @FormUrlEncoded
    @POST("api.php?m=member&a=neighborPic")
    Observable<Response<List<NearbyPerson>>> getNearbyPersonList(@Field("userid") String userid,
                                                                 @Field("longitude") String longitude,
                                                                 @Field("latitude") String latitude,
                                                                 @Field("sex") String sex);


}
