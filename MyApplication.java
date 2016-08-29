package com.example.jinping.yohuo;

import android.app.Application;

/**
 * Created by jinping on 2016/8/22.
 */
public class MyApplication extends Application {
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

}
