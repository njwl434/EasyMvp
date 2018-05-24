package com.saileijieji.mymvp.http;



import com.saileijieji.mymvp.bean.GetMessageCenterBean;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 存放各种网络请求的类
 *
 * @author fym
 */
public interface ApiManager {

    String BASE_URL = "http://dev.saileikeji.com:10030/ebr/"; //http://192.168.10.199:8082/tms/a/

    @GET("getMessageCenter")
    Observable<BaseResponse<List<GetMessageCenterBean>>> getMessageCenter();
}

