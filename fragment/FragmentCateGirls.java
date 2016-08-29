package com.example.jinping.yohuo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.CateTileBaseAdapter;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.bean.CateTileBean;

import java.util.List;

/**
 * Created by jinping on 2016/8/24.
 */
public class FragmentCateGirls extends BaseFragment {

    private ListView lv;
    private List<CateTileBean> list;


    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
       /*View view=inflater.inflate(R.layout.cateboys_frag,container,false);
        lv = (ListView) view.findViewById(R.id.lv);*/

     /*   View view=inflater.inflate(R.layout.ceshi,container,false);
        return view;*/
        TextView tv=new TextView(a);
        tv.setText(getClass().getSimpleName());
        return tv;
    }

    @Override
    public void initData() {

    }


    /*  @Override
    public void initData() {
        list = new ArrayList<>();
        list.add(new CateTileBean(R.mipmap.ic_launcher,"上衣"));
        list.add(new CateTileBean(R.mipmap.ic_launcher,"上衣"));
        list.add(new CateTileBean(R.mipmap.ic_launcher,"上衣"));
        list.add(new CateTileBean(R.mipmap.ic_launcher,"上衣"));
        list.add(new CateTileBean(R.mipmap.ic_launcher,"上衣"));
        list.add(new CateTileBean(R.mipmap.ic_launcher,"上衣"));
        list.add(new CateTileBean(R.mipmap.ic_launcher,"上衣"));



    }
*/

}