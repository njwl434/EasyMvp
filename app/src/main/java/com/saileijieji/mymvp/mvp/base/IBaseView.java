package com.saileijieji.mymvp.mvp.base;

/**
 * @describe: mymvp
 * @author: 武梁
 * @date: 2018/5/23 13:48
 * @mailbox: 1034905058@qq.com
 */

public interface IBaseView<T> {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(int tag,T data);
}
