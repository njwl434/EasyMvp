package com.saileijieji.mymvp.mvp;

import android.content.Context;

import com.saileijieji.mymvp.http.BaseResponse;
import com.saileijieji.mymvp.mvp.base.BaseModel;
import com.saileijieji.mymvp.mvp.base.BasePresenter;
import com.saileijieji.mymvp.mvp.base.Callback;
import com.saileijieji.mymvp.mvp.base.DataModelManager;
import com.saileijieji.mymvp.mvp.base.IBaseView;

import rx.Observable;

/**
 * @describe: MvpPresenter 通用类
 * @author: 武梁
 * @date: 2018/5/23 13:50
 * @mailbox: 1034905058@qq.com
 */

public class MvpPresenter<T> extends BasePresenter<IBaseView> {
    public MvpPresenter(){
    }

    public void getData(final int tag, Context context,boolean type, Observable<BaseResponse<T>> api) {
        BaseModel model=new BaseModel() {
            @Override
            public void request(Context context, boolean type, Observable api, Callback callback) {
                super.request(context, type, api, callback);
            }
        };
        model.request(context,type, api, new Callback<T>() {
                    @Override
                    public void onSuccess(T data) {
                        getView().showData(tag,data);
                    }
                });
    }
}