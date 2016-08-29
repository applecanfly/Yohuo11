package com.example.jinping.yohuo.base;

import android.content.Context;
import android.widget.BaseExpandableListAdapter;

import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public abstract class BaseExpandAdapter<T> extends BaseExpandableListAdapter {
   public  List<T> list;
   public  Context ctx;

    public BaseExpandAdapter(List<T> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }



    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
