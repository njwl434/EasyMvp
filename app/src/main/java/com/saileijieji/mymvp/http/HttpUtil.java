package com.saileijieji.mymvp.http;


import android.text.TextUtils;
import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.GsonBuilder;
import com.saileijieji.mylibrary.SharedPreferenceUtil;
import com.saileijieji.mymvp.WlApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtil {
    private static HttpUtil instance;
    private ApiManager apiManager;
    private String url = "";
    public static OkHttpClient mOkHttpClient = new OkHttpClient();
    private String header = "";


    public static synchronized HttpUtil getInstance(String url) {
      String  headersp = SharedPreferenceUtil.getSharedStringData(WlApplication.getInstance()
                .getApplicationContext(), SPConstant.ACCESS_TOKEN, "");

        if (instance == null || !instance.url.equals(url)|| !headersp.equals(instance.header) )
            instance = new HttpUtil(url);
        return instance;
    }

    public static synchronized HttpUtil getNewInstance(String url) {
        instance = new HttpUtil(url);
        return instance;
    }

    private HttpUtil(String url) {
        this.url = url;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                if (TextUtils.isEmpty(message)){
                    return;
                };
                Log.e("log", message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        Interceptor headerInterceptor = new Interceptor() {

            @Override

            public Response intercept(Chain chain) throws IOException {
                header = SharedPreferenceUtil.getSharedStringData(WlApplication.getInstance()
                        .getApplicationContext(), SPConstant.ACCESS_TOKEN, "");
                Request request = chain.request()
                        .newBuilder()
//                        .addHeader("Authorization", header)
                        .build();

                return chain.proceed(request);

            }

        };
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .addNetworkInterceptor(loggingInterceptor)
                .addInterceptor(headerInterceptor)
                .build();
        mOkHttpClient = client;

//        gsonBuilder.registerTypeAdapter(new TypeToken<List<WalkmanBean>>() {
//        }.getType(), new WalkmanJsonDeserializer());


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiManager = retrofit.create(ApiManager.class);



    }

    public ApiManager getApiManager() {
        return apiManager;
    }



}
