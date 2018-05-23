package com.saileijieji.mymvp.mvp;

import com.saileijieji.mymvp.mvp.base.BaseModel;

/**
 * @describe: mymvp
 * @author: 武梁
 * @date: 2018/5/23 13:38
 * @mailbox: 1034905058@qq.com
 */

public class MvpModel extends BaseModel<String>{


    @Override
    public void execute(final MvpCallback<String> callback) {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]){
                    case "normal":
                        callback.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                    default:
                }
            }
        },2000);
    }
}
