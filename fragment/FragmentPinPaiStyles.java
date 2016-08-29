package com.example.jinping.yohuo.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.LetterExpandAdapter;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.bean.AllBanner;
import com.example.jinping.yohuo.bean.HttpModel;
import com.example.jinping.yohuo.bean.LetterBean;
import com.example.jinping.yohuo.event.PinPaiSwictEvent;
import com.example.jinping.yohuo.utils.DemileUtils;
import com.example.jinping.yohuo.utils.HttpUtils;
import com.example.jinping.yohuo.view.HorizitalListView;
import com.example.jinping.yohuo.view.MyBanner;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public class FragmentPinPaiStyles extends BaseFragment {

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        TextView tv=new TextView(a);
        tv.setText(getClass().getSimpleName());
        return tv;
    }

    @Override
    public void initData() {

    }
}

