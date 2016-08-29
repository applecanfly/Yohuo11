package com.example.jinping.yohuo.view;

import android.content.Context;
import android.renderscript.Int4;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by jinping on 2016/8/24.
 */
public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        this(context, null);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

 /*   @Override
    public int getChildCount() {
        return Integer.MAX_VALUE;
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
    /* @Override
    protected int getWindowAttachCount() {
        return 4;
*/
}