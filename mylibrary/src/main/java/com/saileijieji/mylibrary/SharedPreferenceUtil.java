package com.saileijieji.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by lqy on 2015/8/29.
 */
public class SharedPreferenceUtil {
    private static SharedPreferences mSharedPreferences;

    public static void init(Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager
                    .getDefaultSharedPreferences(context);
        }
    }

    /**
     * 添加Int类型
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setSharedIntData(Context context, String key, int value) {
        if (mSharedPreferences == null) {
            init(context);
        }
        mSharedPreferences.edit().putInt(key, value).commit();
    }

    /**
     * 获取Int类型
     *
     * @param context
     * @param key
     * @return
     */
    public static int getSharedIntData(Context context, String key) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return getSharedIntData(context, key, -1);
    }

    /**
     * 获取Int类型
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getSharedIntData(Context context, String key,
                                       int defaultValue) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return mSharedPreferences.getInt(key, defaultValue);
    }

    /**
     * 添加Long类型
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setSharedlongData(Context context, String key, long value) {
        if (mSharedPreferences == null) {
            init(context);
        }
        mSharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * 获取Long类型
     *
     * @param context
     * @param key
     * @return
     */
    public static long getSharedlongData(Context context, String key) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return getSharedlongData(context, key, -1L);
    }

    /**
     * 获取Long类型
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static long getSharedlongData(Context context, String key,
                                         long defaultValue) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return mSharedPreferences.getLong(key, defaultValue);
    }

    /**
     * 添加Float类型
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setSharedFloatData(Context context, String key,
                                          float value) {
        if (mSharedPreferences == null) {
            init(context);
        }
        mSharedPreferences.edit().putFloat(key, value).commit();
    }

    /**
     * 获取Float类型
     *
     * @param context
     * @param key
     * @return
     */
    public static Float getSharedFloatData(Context context, String key) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return getSharedFloatData(context, key, -1f);
    }

    /**
     * 获取Float类型
     *
     * @param context
     * @param key
     * @return
     */
    public static Float getSharedFloatData(Context context, String key,
                                           float defaultValue) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    /**
     * 添加Boolean类型
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setSharedBooleanData(Context context, String key,
                                            boolean value) {
        if (mSharedPreferences == null) {
            init(context);
        }
        mSharedPreferences.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取Boolean类型
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getSharedBooleanData(Context context, String key) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return getSharedBooleanData(context, key, false);
    }

    /**
     * 获取Boolean类型
     *
     * @param context
     * @param key
     * @return
     */
    public static boolean getSharedBooleanData(Context context, String key,
                                               boolean defaultValue) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * 添加String类型
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setSharedStringData(Context context, String key,
                                           String value) {
        if (mSharedPreferences == null) {
            init(context);
        }
        mSharedPreferences.edit().putString(key, value).commit();
    }

    /**
     * 获取String类型
     *
     * @param context
     * @param key
     * @return
     */
    public static String getSharedStringData(Context context, String key) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return getSharedStringData(context, key, "");
    }

    /**
     * 获取String类型
     *
     * @param context
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getSharedStringData(Context context, String key,
                                             String defaultValue) {
        if (mSharedPreferences == null) {
            init(context);
        }
        return mSharedPreferences.getString(key, defaultValue);
    }

    /**
     * 添加Object类型
     *
     * @param context
     * @param key
     * @param object
     */

    public static void setSharedObjectData(Context context,String key,Object object){
        if (mSharedPreferences == null) {
            init(context);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            String object_Base64 = new String(Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT));
            mSharedPreferences.edit().putString(key,object_Base64).commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取object类型
     *
     * @param context
     * @param key
     * @return
     */
    public static Object getSharedObjectData(Context context,String key){
        if (mSharedPreferences == null) {
            init(context);
        }

        Object objectValue = null;
        String object_Base64 = mSharedPreferences.getString(key,"");
        byte[] Base64Byte = Base64.decode(object_Base64.getBytes(),Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(Base64Byte);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            Object result = ois.readObject();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



    /**
     * 删除某个键的内容
     *
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        if (mSharedPreferences == null) {
            init(context);
        }
        mSharedPreferences.edit().remove(key).commit();
    }

    /**
     * 清空sharedpreference
     *
     * @param context
     */
    public static void clearAll(Context context) {
        if (mSharedPreferences == null) {
            init(context);
        }
        mSharedPreferences.edit().clear().commit();
    }

}
