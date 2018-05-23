package com.saileijieji.mymvp.mvp.base;

/**
 * @describe: mymvp
 * @author: 武梁
 * @date: 2018/5/23 13:48
 * @mailbox: 1034905058@qq.com
 */

public interface IBaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);
    /**
     * 当数据请求失败后，调用此接口提示
     * @param msg 失败原因
     */
    void showFailureMessage(String msg);
    /**
     * 当数据请求异常，调用此接口提示
     */
    void showErrorMessage();
}
