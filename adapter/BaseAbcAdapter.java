package com.example.jinping.yohuo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by jinping on 2016/8/25.
 */
public abstract class BaseAbcAdapter<T> extends BaseAdapter {
    protected List<T> list;

    public BaseAbcAdapter(List<T> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

    protected Context ctx;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
