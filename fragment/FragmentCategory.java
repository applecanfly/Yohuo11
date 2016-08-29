package com.example.jinping.yohuo.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.CateAdapter;
import com.example.jinping.yohuo.adapter.CatetitleAdapter;
import com.example.jinping.yohuo.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinping on 2016/8/23.
 */
public class FragmentCategory extends BaseFragment {


    private View rootview;
    private ImageButton imgbtn;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private ViewPager pager;
    private CateAdapter adapter;
    private TabLayout tab;
    private RelativeLayout relate;
    private ImageButton imgbtn1;
    private List<Fragment> listTitles;
//    private ListView lv;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        rootview = inflater.inflate(R.layout.fragment_category_main, container, false);
//        this.imgbtn = (ImageButton) rootview.findViewById(R.id.imgbtn_catefrag);
        this.tab = (TabLayout) rootview.findViewById(R.id.tool_catefrag);
        this.pager = (ViewPager) rootview.findViewById(R.id.pager_main);
//        pager.setCurrentItem(4);
        return rootview;
    }

    @Override
    public void initData() {
        titleList = new ArrayList<>();
        titleList.add("品类");
        titleList.add("品牌");
        titleList.add("关注");
        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentPinlei());//此处的代码就是给tablayout的每一个按钮添加布局
        fragmentList.add(new FragmentPinpai());
        fragmentList.add(new FragmentGuanzhu());

//        Log.e(" TAG", titleList.get(0) + "");
        adapter = new CateAdapter(getFragmentManager(), titleList, fragmentList);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(fragmentList.size());
        tab.setupWithViewPager(pager);

    }


}
