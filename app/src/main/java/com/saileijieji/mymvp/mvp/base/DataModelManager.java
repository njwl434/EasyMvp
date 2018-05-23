package com.saileijieji.mymvp.mvp.base;

/**
 * @describe: mymvp
 * @author: 武梁
 * @date: 2018/5/23 15:44
 * @mailbox: 1034905058@qq.com
 */

/**
 * 用法:
 * DataModelManager.newInstance(UserModel.class.getName()).setParams(params).execute(callBack);  这样调用 反射出model 对象
 */
public class DataModelManager {
    public static BaseModel newInstance(String className)  {
        BaseModel model = null;
        //利用反射机制获得对应Model对象的引用
        try {
            model=(BaseModel)Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }
}
