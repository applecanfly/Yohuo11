package com.example.jinping.yohuo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by jinping on 2016/8/22.
 */
public class MychoseLinearlyout extends LinearLayout {

    private ImageButton viewbutton;

    public MychoseLinearlyout(Context context) {
        this(context, null);
    }

    public MychoseLinearlyout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MychoseLinearlyout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //可以在此处设置是水平对齐还是垂直对齐

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int free = getMeasuredHeight() - getChildHeight();

        int count = getChildCount();
        int hei = 0;
        for (int i = 0; i < count; i++) {
            View view = getChildAt(i);
            view.layout(0, hei, view.getMeasuredWidth(), hei + view.getMeasuredHeight());
           /* hei=view.getMeasuredHeight();
            hei+=free/getChildCount()-1;*/
            hei = view.getBottom() + free / getChildCount() - 1;
        }
//        super.onLayout(changed, l, t, r, b);


    }

    public int getChildHeight() {
        int count = getChildCount();
        int height = 0;
        for (int i = 0; i < count; i++) {

            height += getChildAt(i).getMeasuredHeight();
        }
        return height;


    }
}
