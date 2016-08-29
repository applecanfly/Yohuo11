package com.example.jinping.yohuo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.bean.CateTileBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jinping on 2016/8/24.
 */
public class CateTileBaseAdapter extends BaseAbcAdapter<CateTileBean> {

    public CateTileBaseAdapter(List<CateTileBean> list, Context ctx) {
        super(list, ctx);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(ctx, R.layout.item_catebase, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        CateTileBean bean = list.get(i);
        holder.imgItemCate.setImageResource(bean.imgid);
        holder.tvItemCate.setText(bean.tv);

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.img_item_cate)
        ImageView imgItemCate;
        @Bind(R.id.tv_item_cate)
        TextView tvItemCate;
        @Bind(R.id.arrow_item_cate)
        ImageView arrowItemCate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
