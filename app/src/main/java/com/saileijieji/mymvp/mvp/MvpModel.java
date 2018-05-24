package com.saileijieji.mymvp.mvp;

import android.content.Context;

import com.saileijieji.mymvp.mvp.base.BaseModel;
import com.saileijieji.mymvp.mvp.base.Callback;

import rx.Observable;

/**
 * @describe: EasyMvp
 * @author: 武梁
 * @date: 2018/5/24 16:56
 * @mailbox: 1034905058@qq.com
 */

public class MvpModel extends BaseModel {

    @Override
    public void request(Context context, boolean type, Observable api, Callback callback) {
        super.request(context, type, api, callback);
    }
}
