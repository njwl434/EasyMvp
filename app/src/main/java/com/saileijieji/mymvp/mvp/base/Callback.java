package com.saileijieji.mymvp.mvp.base;

/**
 * @describe: Callback 返回值基类
 * @author: 武梁
 * @date: 2018/5/23 13:35
 * @mailbox: 1034905058@qq.com
 */

public interface Callback<T> {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void onSuccess(T data);
}
