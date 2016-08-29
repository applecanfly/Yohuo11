package com.example.jinping.yohuo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.base.GuanzhuBean;
import com.example.jinping.yohuo.bean.HttpModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jinping on 2016/8/27.
 */
public class GuanzhuAdapter extends BaseAdapter {
    private List<GuanzhuBean.FollowBean> list;
//    private List <Integer>list;


    private Context ctx;

    public GuanzhuAdapter(List<GuanzhuBean.FollowBean> list, Context ctx) {
        this.list = list;
        this.ctx = ctx;
    }

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

    /*  @Override
      public View getView(int i, View view, ViewGroup viewGroup) {
          view=View.inflate(ctx,R.layout.item_guanzhu,null);

          return view;
      }*/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(ctx, R.layout.item_guanzhu, null);
            holder = new ViewHolder(view);
            view.setTag(holder);


        } else {

     /*
        FllowItemBean.FollowBean followBean = list.get(position);

        Picasso.with(ctx).load(HttpModel.IMGHOST+followBean.getBrandimg()).into(holder.iv);
        List<FllowItemBean.FollowBean.GoodsBean> goods = followBean.getGoods();
        //商品（）
        String goodsimg1 = goods.get(0).getGoodsimg();
        Picasso.with(ctx).load(HttpModel.IMGHOST+goodsimg1).into(holder.iv1);

        FllowItemBean.FollowBean.GoodsBean goodsBean = goods.get(0);
        holder.tv1Normal.setText(goodsBean.getPrice());
        holder.tv1Distance.setText(goodsBean.getDistance());

        String goodsimg2 = goods.get(1).getGoodsimg();
        Picasso.with(ctx).load(HttpModel.IMGHOST+goodsimg2).into(holder.iv2);

        FllowItemBean.FollowBean.GoodsBean goodsBean2 = goods.get(0);
        holder.tv2Normal.setText(goodsBean2.getPrice());
        holder.tv2Discount.setText(goodsBean2.getDistance());


        String goodsimg3 = goods.get(2).getGoodsimg();
        Picasso.with(ctx).load(HttpModel.IMGHOST+goodsimg3).into(holder.iv3);
        FllowItemBean.FollowBean.GoodsBean goodsBean3 = goods.get(0);
        holder.tv3Normal.setText(goodsBean3.getPrice());
        holder.tv3Dicount.setText(goodsBean3.getDistance());*/


            holder = (ViewHolder) view.getTag();
        }
        GuanzhuBean.FollowBean guanzhu = list.get(i);
        Picasso.with(ctx).load(HttpModel.IMGHOST + guanzhu.getBrandimg()).into(holder.ivTitleGuan);
        List<GuanzhuBean.FollowBean.GoodsBean> list1 = guanzhu.getGoods();

        String goodsimg0 = list1.get(0).getGoodsimg();
        Picasso.with(ctx).load(HttpModel.IMGHOST + goodsimg0).into(holder.img1GuanzhuItem);
        GuanzhuBean.FollowBean.GoodsBean goodsBean1 = list1.get(0);
        holder.tvPrice1.setText(goodsBean1.getPrice());
        holder.tvGoneprice1.setText(goodsBean1.getDistance());

        String goodsimg1 = list1.get(1).getGoodsimg();
        Picasso.with(ctx).load(HttpModel.IMGHOST + goodsimg1).into(holder.img2GuanzhuItem);
        GuanzhuBean.FollowBean.GoodsBean goodsBean2 = list1.get(0);
        holder.tvPrice2.setText(goodsBean2.getPrice());
        holder.tvGoneprice2.setText(goodsBean2.getDistance());


        String goodsimg2 = list1.get(2).getGoodsimg();
        Picasso.with(ctx).load(HttpModel.IMGHOST + goodsimg2).into(holder.img3GuanzhuItem);
        GuanzhuBean.FollowBean.GoodsBean goodsBean3 = list1.get(0);
        holder.tvPrice3.setText(goodsBean3.getPrice());
        holder.tvGoneprice3.setText(goodsBean3.getDistance());


        return view;
    }


    static class ViewHolder {
        @Bind(R.id.iv_title_guan)
        ImageView ivTitleGuan;
        @Bind(R.id.tv_guan)
        TextView tvGuan;
        @Bind(R.id.like_item_guan)
        ImageView likeItemGuan;
        @Bind(R.id.title_guan)
        RelativeLayout titleGuan;
        @Bind(R.id.img1_guanzhu_item)
        ImageView img1GuanzhuItem;
        @Bind(R.id.img2_guanzhu_item)
        ImageView img2GuanzhuItem;
        @Bind(R.id.img3_guanzhu_item)
        ImageView img3GuanzhuItem;
        @Bind(R.id.liner_guanitem)
        LinearLayout linerGuanitem;
        @Bind(R.id.tv_price1)
        TextView tvPrice1;
        @Bind(R.id.tv_price2)
        TextView tvPrice2;
        @Bind(R.id.tv_price3)
        TextView tvPrice3;
        @Bind(R.id.liner_tv_guan)
        LinearLayout linerTvGuan;
        @Bind(R.id.tv_goneprice1)
        TextView tvGoneprice1;
        @Bind(R.id.tv_goneprice2)
        TextView tvGoneprice2;
        @Bind(R.id.tv_goneprice3)
        TextView tvGoneprice3;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
