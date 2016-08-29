package com.example.jinping.yohuo.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.GuanzhuAdapter;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.base.GuanzhuBean;
import com.example.jinping.yohuo.bean.HttpModel;
import com.example.jinping.yohuo.utils.HttpUtils;
import com.example.jinping.yohuo.view.MyGridView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinping on 2016/8/25.
 */
public class FragmentGuanzhu extends BaseFragment {


    private ListView lvguan;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.guanzhu_grid, container, false);
        lvguan = (ListView) view.findViewById(R.id.lv_guanzhu);

        return view;
    }

    @Override
    public void initData() {
        new HttpUtils().loadData(HttpModel.FLLOW, "").setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
                GuanzhuBean guan = new Gson().fromJson(content, GuanzhuBean.class);
                guan.getSucessfully();
                List<GuanzhuBean.FollowBean> list = guan.getFollow();
                GuanzhuAdapter adapter = new GuanzhuAdapter(list, a);

                lvguan.setAdapter(adapter);


            }

            @Override
            public void loadFailed(String msg) {
                Toast.makeText(a, msg + "", Toast.LENGTH_LONG).show();

            }
        });

       /* List<Integer>list=new ArrayList<>();
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        lvguan.setAdapter(new GuanzhuAdapter(list,a));*/


    }
}
