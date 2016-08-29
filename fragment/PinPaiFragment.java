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

import com.example.jinping.yohuo.utils.DemileUtils;
import com.example.jinping.yohuo.utils.HttpUtils;
import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.LetterExpandAdapter;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.bean.AllBanner;
import com.example.jinping.yohuo.bean.HttpModel;
import com.example.jinping.yohuo.bean.LetterBean;
import com.example.jinping.yohuo.event.PinPaiSwictEvent;

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
public class PinPaiFragment extends BaseFragment {
    private com.example.jinping.yohuo.view.MyBanner banner;
    private android.widget.ExpandableListView lv;
    private View emptyView;
    private View pb;
    private TextView errorTv;
    private List<LetterBean> letterBeanList;
    private android.widget.ListView letterLv;
    private TextView tv;
    private float y;
    private android.widget.RelativeLayout group;
    private RelativeLayout parentGroup;
    private AllBanner allBanner;

    @Override
    public void onAttach(Activity activity) {
        EventBus.getDefault().register(this);
        super.onAttach(activity);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.pinpai_title_boys, container, false);
        this.parentGroup = (RelativeLayout) view.findViewById(R.id.parentGroup);
        this.group = (RelativeLayout) view.findViewById(R.id.group);
        this.tv = (TextView) view.findViewById(R.id.tv);
        this.letterLv = (ListView) view.findViewById(R.id.letterLv);
        this.lv = (ExpandableListView) view.findViewById(R.id.lv);
        emptyView = view.findViewById(R.id.emptyView);
        pb = emptyView.findViewById(R.id.pb);
        errorTv = (TextView) emptyView.findViewById(R.id.tv);
        errorTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorTv.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);
                initContent();
            }
        });

        lv.setHeaderDividersEnabled(false);// 设置头部的divider为false
        lv.setGroupIndicator(null);
        lv.setEmptyView(emptyView);
        lv.setVerticalScrollBarEnabled(false);
        lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        initContacts();
        return view;
    }

    private void initContacts() {
        initHead();
        initContent();
    }
   private LetterBean getBranBean(String content, List<AllBanner.BrandBean> list){
        String title=content;
        List<AllBanner.BrandBean> temp=new ArrayList<>();
        for(AllBanner.BrandBean bean:list){
            boolean equals = bean.getLetter().equals(content);
            if(equals){
                temp.add(bean);
            }
        }
        boolean b = temp.size() > 0;
        if(b){
            return new LetterBean(content,temp);
        }
        return  null;
    }
    private void initContent() {
        new HttpUtils().loadData(HttpModel.ALLBANNER, "parames={\\\"page\\\":\\\"10\\\"}").setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
//                Log.e("asd", content);
                // 判断是否是json
                allBanner = new Gson().fromJson(content, AllBanner.class);
                final List<AllBanner.BrandBean> brand = allBanner.getBrand();
                final List<String> letter = getLetter(brand);
                Collections.sort(letter);
                letterBeanList = new ArrayList<LetterBean>();
                for(String con:letter){
                    LetterBean branBean = getBranBean(con, brand);
                    if(branBean!=null)
                        letterBeanList.add(branBean);
                }
                Log.e("abcd", letterBeanList.toString());
                lv.setAdapter(new LetterExpandAdapter(letterBeanList,a));
//                Log.e("le",letter.    toString());
                lv.post(new Runnable() {
                    @Override
                    public void run() {
                        lv.getChildAt(0).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(a,"dasdas",Toast.LENGTH_LONG).show();
                                EventBus.getDefault().post(new PinPaiSwictEvent(1));

                            }
                        });
                    }
                });
                letterLv.setVerticalScrollBarEnabled(false);
                letterLv.setDividerHeight(0);
                letterLv.setAdapter(new ArrayAdapter<String>(a,R.layout.item_pinpai_letter,R.id.tv,letter));
                openAll();
                letterLv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()){
                            case MotionEvent.ACTION_DOWN:
                            case MotionEvent.ACTION_MOVE:
                                y = event.getY();
                                int position = letterLv.pointToPosition(0, (int) y);
                                if(position>=0){
                                    // 无效的按下是-1
                                    lv.setSelectedGroup(position);
                                    int currentChild=position-letterLv.getFirstVisiblePosition();
                                    for(int i=0;i<letterLv.getChildCount();i++){
                                        // 设置阴影
                                        letterLv.getChildAt(i).setBackgroundColor(Color.WHITE);
                                        if(currentChild==i)
                                            letterLv.getChildAt(i).setBackgroundColor(Color.parseColor("#cccccc"));

                                    }
                                }
                                break;
                            case MotionEvent.ACTION_UP:
                                int currentChild=-1;
                                for(int i=0;i<letterLv.getChildCount();i++){
                                    // 设置阴影
                                    letterLv.getChildAt(i).setBackgroundColor(Color.WHITE);

                                }
                                break;


                        }
                        return true;
                    }
                });
            }

            @Override
            public void loadFailed(String msg) {

                Toast.makeText(a,msg+"",Toast.LENGTH_LONG).show();
                errorTv.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void switchPinPai(PinPaiSwictEvent event){
        int i = event.i;
        parentGroup.removeAllViews();
        if(i==0){
            parentGroup.addView(group);
        }else if(i==1){
       /*  pinPaiChildView.setAllBrann(allBanner);
            pinPaiChildView.init(a);
            parentGroup.addView(pinPaiChildView.rootView);*/
            Toast.makeText(a,"huaile",Toast.LENGTH_LONG).show();
        }
    }
//    PinPaiChildView pinPaiChildView=new PinPaiChildView();
    private void openAll() {
        for(int i=0;i<letterBeanList.size();i++)
            lv.expandGroup(i,false);
    }

    private void initHead() {
        this.banner = new MyBanner(a);
        banner.loadData(HttpModel.BANNER, "");
        ExpandableListView.LayoutParams bannerparams = new ExpandableListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemileUtils.dp2px(160));
        banner.setLayoutParams(bannerparams);

        View searchView = View.inflate(a, R.layout.search, null);
        searchView.findViewById(R.id.edt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new PinPaiSwictEvent(1));
            }
        });
        AbsListView.LayoutParams searchparams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemileUtils.dp2px(60));
//        searchView.setPadding(DimenUtils.dp2px(5),DimenUtils.dp2px(5),DimenUtils.dp2px(5),DimenUtils.dp2px(5));
        searchView.setLayoutParams(searchparams);
        HorizitalListView horizitalListView = new HorizitalListView(a);
        horizitalListView.loadData(HttpModel.HOTBANNER, "");
        AbsListView.LayoutParams horizitalparams = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemileUtils.dp2px(170));
        horizitalListView.setLayoutParams(horizitalparams);
        lv.addHeaderView(searchView);
        lv.addHeaderView(banner);
        lv.addHeaderView(horizitalListView);
        lv.addHeaderView(View.inflate(a,R.layout.layout_banner,null));

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void initData() {

    }

    public List<String> getLetter(List<AllBanner.BrandBean> brand) {
        List<String> letterlist=new ArrayList<String>();
        for(AllBanner.BrandBean bean:brand){
            String letter = bean.getLetter();
            boolean contains = letterlist.contains(letter);
            if(!contains){
                letterlist.add(letter);
            }
        }
        return letterlist;

    }
}



/*
package com.example.jinping.yohuo.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.base.BaseFragmentPinpai;
import com.example.jinping.yohuo.bean.HttpModel;
import com.example.jinping.yohuo.utils.DemileUtils;
import com.example.jinping.yohuo.view.MyBanner;

*/
/**
 * Created by jinping on 2016/8/25.
 *//*

public class FragmentPinpaiBoys extends BaseFragment {

    private com.example.jinping.yohuo.view.MyBanner banner;
    private ListView lv;
    private ExpandableListView exlv;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.pinpai_title_boys,container,false);
        Log.e("TAG","进boys了");
        this.lv = (ListView) view.findViewById(R.id.lv_pinpai);
        this.exlv = (ExpandableListView) view.findViewById(R.id.exlv_pinpai);


        exlv.setHeaderDividersEnabled(false);// 设置头部的divider为false
        exlv.setGroupIndicator(null);
//        exlv.setEmptyView(emptyView);
        exlv.setVerticalScrollBarEnabled(false);
        exlv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
//        initHeadView();
        this.banner = new MyBanner(a);
        banner.loadData(HttpModel.BANNER, "");
        ExpandableListView.LayoutParams bannerparams = new ExpandableListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemileUtils.dp2px(160));
        banner.setLayoutParams(bannerparams);
        exlv.addHeaderView(banner);
        return view;
    }

    @Override
    public void initData() {



    }

   */
/* private void initHeadView() {
        this.banner = new MyBanner(a);
        banner.loadData(HttpModel.BANNER, "");
        ExpandableListView.LayoutParams bannerparams = new ExpandableListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, DemileUtils.dp2px(160));
        banner.setLayoutParams(bannerparams);


        exlv.addHeaderView(banner);
        exlv.addHeaderView(View.inflate(a,R.layout.item_pinpai_edit,null));

    }*//*

}
*/
