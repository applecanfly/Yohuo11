package com.example.jinping.yohuo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jinping.yohuo.base.BaseFragment;

/**
 * Created by jinping on 2016/8/23.
 */
public class FragmentSee extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        TextView tv = new TextView(a);
        tv.setText(getClass().getSimpleName());
        return tv;
    }

    @Override
    public void initData() {

    }
}
