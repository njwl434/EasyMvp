package com.saileijieji.mylibrary;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by lqy on 16/9/19.
 */
public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context,R.style.MyDialogLoading);
        init();
    }


    public void init() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.layout_loading);
        ImageView animationIV= (ImageView) findViewById(R.id.progressBar);
        Window mWindow = getWindow();
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.dimAmount =0f;
        animationIV.setImageResource(R.anim.dialog_loading);
        AnimationDrawable  animationDrawable=(AnimationDrawable)animationIV.getDrawable();
        animationDrawable.start();
//        loadingIndicatorView = (AVLoadingIndicatorView) findViewById(R.id.indicator);
//        loadingIndicatorView.setIndicator("BallSpinFadeLoaderIndicator");
    }

}
