package com.saileijieji.mymvp.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.saileijieji.mymvp.mvp.base.IBaseView;

/**
 * @describe: activity 基类
 * @author: 武梁
 * @date: 2018/5/23 14:40
 * @mailbox: 1034905058@qq.com
 */

public class BaseActivity extends AppCompatActivity implements IBaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void showData(String data) {

    }

    @Override
    public void showFailureMessage(String msg) {

    }

    @Override
    public void showErrorMessage() {

    }
}
