package com.saileijieji.mymvp.mvp.base;

import android.content.Context;

import com.saileijieji.mymvp.http.BaseResponse;
import com.saileijieji.mymvp.http.ResponseProcess;

import java.util.Map;

import rx.Observable;


/**
 * @describe: model通用基类
 * @author: 武梁
 * @date: 2018/5/23 15:03
 * @mailbox: 1034905058@qq.com
 */

public abstract class BaseModel<T> {

    public  void request(Context context, boolean type, Observable<BaseResponse<T>> api, final Callback<T> callback){
        if (context!=null) {
            //这里写具体的网络请求
            new ResponseProcess<T>(context,type) {

                @Override
                public void onResult(T t) throws Exception {
                    callback.onSuccess(t);
                }
            }.processResult(api);
        }
     }
}
