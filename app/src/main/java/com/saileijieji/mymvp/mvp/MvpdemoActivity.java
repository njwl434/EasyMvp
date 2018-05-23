package com.saileijieji.mymvp.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.saileijieji.mymvp.R;
import com.saileijieji.mymvp.mvp.base.BaseActivity;

/**
 * @describe: mymvp
 * @author: 武梁
 * @date: 2018/5/23 13:58
 * @mailbox: 1034905058@qq.com
 */

public class MvpdemoActivity extends BaseActivity implements MvpView{


    //进度条`
    ProgressDialog progressDialog;
    TextView text;
    MvpPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo);
        text = (TextView)findViewById(R.id.text);

        progressDialog =new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在加载数据");
        //初始化Presenter
        presenter = new MvpPresenter();
        // 绑定View引用
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    // button 点击事件调用方法
    public void getData(View view){
        presenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        presenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        presenter.getData("error");
    }


    @Override
    public void showLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (!progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
    @Override
    public void showData(String data) {
        text.setText(data);
    }
    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        text.setText(msg);
    }
    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "网络请求数据出现异常", Toast.LENGTH_SHORT).show();
        text.setText("网络请求数据出现异常");
    }
}
