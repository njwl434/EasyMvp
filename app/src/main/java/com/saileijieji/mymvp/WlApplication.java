package com.saileijieji.mymvp;

import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDexApplication;

import com.saileijieji.mylibrary.Tool;


/**
 * @describe: WlApplication
 * @author: 武梁
 * @date: 2017/11/9 09:57
 * @mailbox: 1034905058@qq.com
 */

public class WlApplication extends MultiDexApplication {

    public static Context context;
    private static WlApplication application;
    private static Handler mHandler;//主线程Handler
    private static final String TAG = "WlApplication";
//    static {//static 代码段可以防止内存泄露
//        //设置全局的Header构建器
//        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
//            @Override
//            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
//                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
//                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
//            }
//        });
//        //设置全局的Footer构建器
//        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
//            @Override
//            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
//                //指定为经典Footer，默认是 BallPulseFooter
//                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
//            }
//        });
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        context = getApplicationContext();
        mHandler = new Handler();
        Tool.init(context);
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }

    public static WlApplication getInstance() {
        return application;
    }

}
