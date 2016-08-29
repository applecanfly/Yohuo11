package com.example.jinping.yohuo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.GuanzhuAdapter;
import com.example.jinping.yohuo.utils.DemileUtils;

/**
 * Created by jinping on 2016/8/26.
 */
public class MyGridView extends LinearLayout {
    public MyGridView(Context context) {
        this(context, null);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        init();

    }

    private void init() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        ViewGroup.LayoutParams layoutParamsRel = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DemileUtils.dp2px(50));

        TextView tv = new TextView(getContext());
        tv.setText("我是头部");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DemileUtils.dp2px(50));
        tv.setLayoutParams(layoutParams);

        addView(tv);
        GridView grid = new GridView(getContext());
        ViewGroup.LayoutParams layoutParams1 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        grid.setLayoutParams(layoutParams);
        grid.setNumColumns(3);


        addView(grid);
    }
}
