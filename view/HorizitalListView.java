package com.example.jinping.yohuo.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinping.yohuo.utils.HttpUtils;
import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.bean.HotBean;
import com.example.jinping.yohuo.bean.HttpModel;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public class HorizitalListView extends LinearLayout{

    private TextView tv;
    private RecyclerView recyclerView;
    private List<HotBean.BrandBean> brand;

    public HorizitalListView(Context context) {
        this(context,null);
    }

    public HorizitalListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HorizitalListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), R.layout.layout_horizital, null);
        addView(inflate);
        tv = (TextView) inflate.findViewById(R.id.tv);
        recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        // 如何加载数据

    }
    public void setAdapter(RecyclerView.Adapter adapter){
        // 用户可以修改样式
        recyclerView.setAdapter(adapter);
    }
    public void loadData(String url,String body){
        new HttpUtils().loadData(url,body).setOnLoadDataListener(new HttpUtils.OnLoadDataListener() {
            @Override
            public void loadSuccess(String content) {
            // Content一定要判断是否是json
                boolean b = content.startsWith("{") || content.startsWith("[");
                if(b){
                    HotBean hotBean = new Gson().fromJson(content, HotBean.class);
                    brand = hotBean.getBrand();
                    recyclerView.setAdapter(new MyAdapter());
                }else{
                    Toast.makeText(getContext(),content,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void loadFailed(String msg) {
                Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setText(String text){
        tv.setText(text);
    }
    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 获得view控件
            return new MyViewHolder(View.inflate(getContext(),R.layout.horizitionlv_default,null));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
// 绑定数据
            HotBean.BrandBean brandBean = brand.get(position);
            holder.tv.setText(brandBean.getName());
            Picasso.with(getContext()).load(HttpModel.IMGHOST+brandBean.getImgpath()).error(R.drawable.goods_vip2_icon).fit().into(holder.iv);
        }

        @Override
        public int getItemCount() {
            return brand.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

         TextView tv;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
