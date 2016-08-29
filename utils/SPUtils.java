package com.example.jinping.yohuo.utils;

import com.example.jinping.yohuo.MyApplication;

/**
 * Created by jinping on 2016/8/22.
 */
public class SPUtils {
    public static void save(String key, String value) {
        MyApplication.app.getSharedPreferences("confige", 0).edit().putString(key, value).commit();

    }

    public static Object get(String key) {
        return MyApplication.app.getSharedPreferences("confige", 0).getString(key, "");

    }
}
