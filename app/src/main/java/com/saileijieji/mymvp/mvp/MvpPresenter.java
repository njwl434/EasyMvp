package com.saileijieji.mymvp.mvp;

import com.saileijieji.mymvp.mvp.base.BasePresenter;
import com.saileijieji.mymvp.mvp.base.DataModelManager;

/**
 * @describe: mymvp
 * @author: 武梁
 * @date: 2018/5/23 13:50
 * @mailbox: 1034905058@qq.com
 */

public class MvpPresenter extends BasePresenter<MvpView> {
    private MvpView View;

    public MvpPresenter(){

    }

    public void getData(String parm) {
        getView().showLoading();
        DataModelManager.newInstance(MvpModel.class.getName())
                .params("123","123")
                .execute(new MvpCallback<String>() {
                    @Override
                    public void onSuccess(String data) {

                    }

                    @Override
                    public void onFailure(String msg) {

                    }

                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}