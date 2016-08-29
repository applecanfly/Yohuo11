package com.example.jinping.yohuo.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jinping.yohuo.R;

/**
 * Created by jinping on 2016/8/25.
 */
public class BaseFragmentPinpai extends BaseFragment {

    private ExpandableListView exlv;
    private ListView lvpinpai;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.pinpai_title_boys, container, false);
        exlv = (ExpandableListView) view.findViewById(R.id.lv);
        lvpinpai = (ListView) view.findViewById(R.id.letterLv);

        exlv.addHeaderView(View.inflate(a, R.layout.item_pinpai_edit, null));

        return view;// view;
    }

    @Override
    public void initData() {


    }
}
