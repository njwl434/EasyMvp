package com.saileijieji.mymvp.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saileijieji.mymvp.http.ApiManager;
import com.saileijieji.mymvp.http.HttpUtil;
import com.saileijieji.mymvp.mvp.MvpPresenter;

/**
 * @describe: fragment基类
 * @author: 武梁
 * @date: 2018/5/23 14:49
 * @mailbox: 1034905058@qq.com
 */

public abstract class BaseFragment extends Fragment implements IBaseView {

    public abstract int getContentViewId();
    protected abstract void initAllMembersView(Bundle savedInstanceState);
    protected Context mContext;
    protected View mRootView;
    public ApiManager apiManager;
    public MvpPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView=inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMembersView(savedInstanceState);
        apiManager = HttpUtil.getInstance(ApiManager.BASE_URL).getApiManager();
        //初始化Presenter
        presenter = new MvpPresenter();
        // 绑定View引用
        presenter.attachView(this);
        return mRootView;
    }



    /**
     * 检查activity连接情况
     */
    public void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotAttachedException();
        }
    }
    public static class ActivityNotAttachedException extends RuntimeException {
        public ActivityNotAttachedException() {
            super("Fragment has disconnected from Activity ! - -.");
        }
    }
}
