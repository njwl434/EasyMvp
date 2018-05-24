package com.saileijieji.mymvp.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.saileijieji.mymvp.http.ApiManager;
import com.saileijieji.mymvp.http.HttpUtil;
import com.saileijieji.mymvp.mvp.MvpPresenter;
import com.saileijieji.mymvp.mvp.base.IBaseView;

/**
 * @describe: activity 基类
 * @author: 武梁
 * @date: 2018/5/23 14:40
 * @mailbox: 1034905058@qq.com
 */

public class BaseActivity extends AppCompatActivity implements IBaseView {
    public ApiManager apiManager;
    public MvpPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiManager = HttpUtil.getInstance(ApiManager.BASE_URL).getApiManager();
        //初始化Presenter
        presenter = new MvpPresenter();
        // 绑定View引用
        presenter.attachView(this);
    }


    @Override
    public void showData(int tag, Object data) {

    }
}
