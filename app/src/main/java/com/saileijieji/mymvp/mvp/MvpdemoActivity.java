package com.saileijieji.mymvp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.saileijieji.mymvp.R;
import com.saileijieji.mymvp.bean.GetMessageCenterBean;
import com.saileijieji.mymvp.http.ApiManager;
import com.saileijieji.mymvp.http.HttpUtil;
import com.saileijieji.mymvp.mvp.base.BaseActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe: demo
 * @author: 武梁
 * @date: 2018/5/23 13:58
 * @mailbox: 1034905058@qq.com
 */

public class MvpdemoActivity extends BaseActivity {

    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    Button btn3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpdemo);
        ButterKnife.bind(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showData(int tag, Object data) {
        super.showData(tag, data);
        List<GetMessageCenterBean> da = (List<GetMessageCenterBean>) data;
        switch (tag) {
            case 0:
                text.setText("接口0" + da.get(0).getTitle());
                break;
            case 1:
                text.setText("接口1" + da.get(0).getTitle());
                break;
            case 2:
                text.setText("接口2" + da.get(0).getTitle());
                break;
            default:
        }
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                presenter.getData(0, MvpdemoActivity.this, false, apiManager.getMessageCenter());
                break;
            case R.id.btn2:
                presenter.getData(1, MvpdemoActivity.this, false, apiManager.getMessageCenter());
                break;
            case R.id.btn3:
                presenter.getData(2, MvpdemoActivity.this, false, apiManager.getMessageCenter());
                break;
                default:
        }
    }
}
