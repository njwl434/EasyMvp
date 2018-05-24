package com.saileijieji.mymvp.http;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;
import com.saileijieji.mylibrary.LoadingDialog;
import com.saileijieji.mylibrary.LogUtil;
import com.saileijieji.mylibrary.android.schedulers.AndroidSchedulers;

import java.net.UnknownHostException;

import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 用于对返回数据的预处理
 *
 * @author lqy
 * @time 2016/4/18 11:32
 */

public abstract class ResponseProcess<T> {
    private Context context;
    private boolean hasRefresh = false;
    public LoadingDialog loadingView;
    private boolean isGetting = false;
    private Object errorData;

    public ResponseProcess(Context context) {
        this(context, false);
    }

    public ResponseProcess(Context context, boolean hasRefresh) {
        this.context = context;
        this.hasRefresh = hasRefresh;
        loadingView = new LoadingDialog(context);
        loadingView.setCanceledOnTouchOutside(false);
    }

    public ResponseProcess() {
    }

    public void processResult(Observable<BaseResponse<T>> observable) {
        if (isGetting)
            return;
        isGetting = true;
        observable.subscribeOn(Schedulers.io())
                .flatMap(new Func1<BaseResponse, Observable<?>>() {
                             @Override
                             public Observable<?> call(BaseResponse baseResponse) {
                                 if (baseResponse.getStatus() != 0) {
                                     errorData = baseResponse.getData();
                                     return Observable.error(new ServerException(baseResponse.getStatus(), baseResponse.getMsg()));
                                 }
                                 return Observable.just(baseResponse.getData());
                             }
                         }
                ).doOnSubscribe(new Action0() {
                @Override
                public void call() {//显示网络请求动画
                    if (context != null && !hasRefresh) {
                        loadingView.show();
                    }
                    preDoOnSunscibe();
                }
            }).subscribeOn(Schedulers.immediate())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {

                    @Override
                    public void onCompleted() {
                        isGetting = false;
                        onResultComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        isGetting = false;
                        e.printStackTrace();
                        if (e instanceof JsonSyntaxException) {
                            if (context != null){
                                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                LogUtil.e(e.getMessage());
                            }
                        } else if (e instanceof ServerException) {
                            if (context != null) {
                                loadingView.dismiss();
                                Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
                                if (((ServerException) e).getCode() == 401) {
//                                    context.startActivity(new Intent(context, LoginActivity.class));
                                    if (context instanceof AppCompatActivity) {
                                        ((AppCompatActivity) context).finish();
                                    }
                                }
                            } else {

                            }LogUtil.e(e.getMessage());

                            onResultError(e, ((ServerException) e).getCode(), errorData);
                        } else if (e instanceof UnknownHostException) {
                            if (context != null && loadingView.isShowing()) {
                                loadingView.dismiss();
                                Toast.makeText(context, "网络链接失败，请检查网络后重试", Toast.LENGTH_SHORT).show();
                            } else {
                                LogUtil.e("请求失败");
                                onNetError();
                            }

                        } else {
                            if (context != null && loadingView.isShowing()) {

                                loadingView.dismiss();
                                e.printStackTrace();
                                Toast.makeText(context, "请求失败,请稍后重试", Toast.LENGTH_SHORT).show();
                            } else {
                                LogUtil.e("请求失败");
                                onNetError();
                            }

                        }
                    }

                    @Override
                    public void onNext(Object o) {
//                        if (o != null) {
                        try {
                            T t = (T) o;
                            if (context != null && !hasRefresh)
                                loadingView.dismiss();

                                onResult(t);
                            } catch (Exception e) {
                                e.printStackTrace();
                            loadingView.dismiss();
                            }
//                        }
                    }
                });
    }

    public abstract void onResult(T t) throws Exception;

    public void onResultError(Throwable e, int errorCode, Object errorData) {
        if (errorData != null) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onNetError() {

    }

    public void onResultComplete() {
    }

    public void preDoOnSunscibe() {
    }


}
