package com.example.jinping.yohuo.view;

import android.content.Context;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by jinping on 2016/8/24.
 */
public class MySlidingPaneLayout extends SlidingPaneLayout {
    private int x;
    private boolean isInter;

    public MySlidingPaneLayout(Context context) {
        super(context);
    }

    public MySlidingPaneLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySlidingPaneLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = (int) ev.getRawX();
                isInter = false;
                break;
            case MotionEvent.ACTION_MOVE:
                int min = (int) (ev.getRawX() - x);
                if (min > 0) {
                    isInter = true;
                    // 关闭的时候向右滑动不拦截
//                    Log.e("tag","不拦截");
//                    Toast.makeText(getContext(),"拦截",Toast.LENGTH_SHORT).show();
                    return false;// 不拦截
                }
//                Toast.makeText(getContext(),"bu拦截",Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isInter) return false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = (int) ev.getRawX();
                isInter = false;
                break;
            case MotionEvent.ACTION_MOVE:
                int min = (int) (ev.getRawX() - x);
                if (min > 0 && !isOpen()) {
                    isInter = true;
                    // 关闭的时候向右滑动不拦截
//                    Log.e("tag","不拦截");
//                    Toast.makeText(getContext(),"拦截",Toast.LENGTH_SHORT).show();
                    return false;// 不拦截
                }
//                Toast.makeText(getContext(),"bu拦截",Toast.LENGTH_SHORT).show();

                break;
        }
        return super.onTouchEvent(ev);
    }


}


