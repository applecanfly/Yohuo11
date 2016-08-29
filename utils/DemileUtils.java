package com.example.jinping.yohuo.utils;

import com.example.jinping.yohuo.MyApplication;

/**
 * Created by jinping on 2016/8/22.
 */
public class DemileUtils {
    public static int dp2px(int value){

        return (int) (MyApplication.app.getResources().getDisplayMetrics().density*value+0.5f);

    }
}
