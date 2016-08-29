package com.example.jinping.yohuo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.CatetitleAdapter;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.view.MyViewPager;

import java.nio.InvalidMarkException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jinping on 2016/8/25.
 */
public class FragmentPinpai extends BaseFragment implements View.OnClickListener {


    private MyViewPager pager;
    private RadioButton rabtnboy;
    private RadioButton rabtngirl;
    private RadioButton rabtnkid;
    private RadioButton rabtnstyle;
    private List<Fragment> fragmentList;
    private CatetitleAdapter adapter;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.pinpai_frag, container, false);
        pager = (MyViewPager) view.findViewById(R.id.pager_pinlei);
        rabtnboy = (RadioButton) view.findViewById(R.id.boys_rabtn_cate);
        rabtngirl = (RadioButton) view.findViewById(R.id.girls_rabtn_cate);

        rabtnkid = (RadioButton) view.findViewById(R.id.kids_rabtn_cate);
        rabtnstyle = (RadioButton) view.findViewById(R.id.left_rabtn_cate);
        pager.setOffscreenPageLimit(4);
        initListener();


//        pager.setAdapter(new CatetitleAdapter(getFragmentManager(),list));

//        List<ImageView> list=new ArrayList<>();
//        for (int i=0;i<10;i++){
//
//            ImageView iv=new ImageView(a);
//            iv.setImageResource(R.mipmap.ic_launcher);
//            list.add(iv);
//        }
//        pager.setAdapter(new MyAdapter(list));
        return view;
//        TextView tv=new TextView(a);
//        tv.setText(getClass().getSimpleName());
//        return tv;
//
    }

//    class MyAdapter extends PagerAdapter{
//
//        private List<ImageView> list;
//        public MyAdapter(List<ImageView> list){
//            this.list=list;
//        }
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view==object;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
////            super.destroyItem(container, position, object);
//            container.removeView(list.get(position));
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//
//            container.addView(list.get(position));
//            return list.get(position);
//        }
//    }

    private void initListener() {
        rabtnboy.setOnClickListener(this);
        rabtngirl.setOnClickListener(this);
        rabtnkid.setOnClickListener(this);
        rabtnstyle.setOnClickListener(this);
    }

    @Override
    public void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new PinPaiFragment());
        fragmentList.add(new FragmentGuanzhu());
        fragmentList.add(new FragmentGuanzhu());
        fragmentList.add(new FragmentGuanzhu());
//        fragmentList.add(new PinPaiFragment());
//        fragmentList.add(new PinPaiFragment());
       /* fragmentList.add(new FragmentPinpaiBoys());
        fragmentList.add(new FragmentPinPaiGirls());
        fragmentList.add(new FragmentPinPaiStyles());*/

        adapter = new CatetitleAdapter(getFragmentManager(), fragmentList);
        pager.setAdapter(adapter);
     /*   final List<TextView> list=new ArrayList<>();
        for(int i=0;i<4;i++){
            TextView tv=new TextView(a);
            tv.setText("item---"+i);
            list.add(tv);*/
    }

    /*    pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
//                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position));
                return list.get(position);
            }
        });*/


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boys_rabtn_cate:
                pager.setCurrentItem(0, false);

                break;
            case R.id.girls_rabtn_cate:
                pager.setCurrentItem(1, false);
                break;
            case R.id.kids_rabtn_cate:
                pager.setCurrentItem(2, false);
                break;
            case R.id.left_rabtn_cate:
                pager.setCurrentItem(3, false);
                break;
        }
    }
}
