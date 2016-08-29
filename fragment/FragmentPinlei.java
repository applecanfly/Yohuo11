package com.example.jinping.yohuo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.CatetitleAdapter;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinping on 2016/8/24.
 */
public class FragmentPinlei extends BaseFragment {
    @Bind(R.id.boys_rabtn_cate)
    RadioButton boysRabtnCate;
    @Bind(R.id.girls_rabtn_cate)
    RadioButton girlsRabtnCate;
    @Bind(R.id.kids_rabtn_cate)
    RadioButton kidsRabtnCate;
    @Bind(R.id.left_rabtn_cate)
    RadioButton leftRabtnCate;
    @Bind(R.id.relate_catemain2)
    RelativeLayout relateCatemain2;
    @Bind(R.id.pager_pinlei)
    MyViewPager pagerPinlei;
    private List<Fragment> list;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.pinlei_frag, container, false);
//        this.pagerPinlei= (MyViewPager) view.findViewById(R.id.pager_pinlei);
        ButterKnife.bind(this, view);
        pagerPinlei.setOffscreenPageLimit(4);

        return view;
    }

    @Override
    public void initData() {
        list=new ArrayList<>();
        list.add(new FragmentCateBoys());
        list.add(new FragmentCateGirls());
        list.add(new FragmentCateKids());
        list.add(new FragmentCateStyles());
        CatetitleAdapter adapter=new CatetitleAdapter(getFragmentManager(),list);
//        pagerPinlei.setCurrentItem(4);
        pagerPinlei.setAdapter(adapter);
//        final List<TextView> list=new ArrayList<>();
//        for(int i=0;i<4;i++){
//            TextView tv=new TextView(a);
//            tv.setText("品类---"+i);
//            list.add(tv);
//        }
//
//        pagerPinlei.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view==object;
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
////                super.destroyItem(container, position, object);
//                container.removeView((View) object);
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                container.addView(list.get(position));
//                return list.get(position);
//            }
//        });

    }

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.boys_rabtn_cate, R.id.girls_rabtn_cate, R.id.kids_rabtn_cate, R.id.left_rabtn_cate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boys_rabtn_cate:
            pagerPinlei.setCurrentItem(0);

                break;
            case R.id.girls_rabtn_cate:
                pagerPinlei.setCurrentItem(1,true);
                break;
            case R.id.kids_rabtn_cate:
                pagerPinlei.setCurrentItem(2,false);
                break;
            case R.id.left_rabtn_cate:
                pagerPinlei.setCurrentItem(3,false);
                break;
        }
    }
}
