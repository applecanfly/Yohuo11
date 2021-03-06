package com.example.jinping.yohuo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.base.BaseExpandAdapter;
import com.example.jinping.yohuo.bean.LetterBean;

import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public class LetterExpandAdapter extends BaseExpandAdapter<LetterBean> {
    public LetterExpandAdapter(List<LetterBean> list, Context ctx) {
        super(list, ctx);

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).list.size();
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ParentViewHolder viewHolder;
        if(convertView==null){
            convertView=View.inflate(ctx, R.layout.item_pinpai_parent,null);
            viewHolder=new ParentViewHolder();
            viewHolder.tv= (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else
        viewHolder= (ParentViewHolder) convertView.getTag();
        viewHolder.tv.setText(list.get(groupPosition).title);
        return convertView;
    }
    class ParentViewHolder {
        TextView tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
      ChildViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(ctx,R.layout.item_pinpai_child,null);
            holder=new ChildViewHolder();
            holder.tv= (TextView) convertView.findViewById(R.id.tv);
            holder.iv= (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);
        }else
        holder= (ChildViewHolder) convertView.getTag();
        holder.tv.setText(list.get(groupPosition).list.get(childPosition).getName());
       holder.iv.setVisibility(View.GONE);
        if(list.get(groupPosition).list.get(childPosition).getHotflag().equals("1"))
            holder.iv.setVisibility(View.VISIBLE);
        return convertView;
    }
    class ChildViewHolder{
        TextView tv;
        ImageView iv;

    }
}
