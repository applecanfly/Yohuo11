package com.example.jinping.yohuo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.jinping.yohuo.utils.DemileUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jinping on 2016/8/22.
 */
public class YindaoActivity extends AppCompatActivity {
    @Bind(R.id.pager_yindao)
    ViewPager pagerYindao;
    private List<ViewGroup> list;
    private RelativeLayout relativeLayout;
    private YindaoAdapter adapter;
    private ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yindao);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initData();
        initAdapter();
        inintListener();
    }

    private void inintListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YindaoActivity.this, WelcomeActivity.class));
            }
        });
    }

    private void initAdapter() {
        adapter = new YindaoAdapter();
        pagerYindao.setAdapter(adapter);


    }

    private void initData() {
        list = new ArrayList<>();
        list.add(getView(R.drawable.guide_1, false));
        list.add(getView(R.drawable.guide_2, false));
        list.add(getView(R.drawable.guide_3, false));
        list.add(getView(R.drawable.guide_4, false));
        list.add(getView(R.drawable.guide_5, true));

    }

    public ViewGroup getView(int id, boolean isLast) {//isLast判断是否是最后一张引导页，最后一张需要添加一个"立即体验"
        relativeLayout = new RelativeLayout(this);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(id);
        relativeLayout.addView(imageView);
        //给最后一个图片加一个ImagViewButton
        if (isLast) {
            button = new ImageButton(this);
            //注意，此处MyApplication没注册会出现空指针，从下一行代码往下都报错
            RelativeLayout.LayoutParams buttonParams1 = new RelativeLayout.LayoutParams(DemileUtils.dp2px(120), DemileUtils.dp2px(40));
            //尺寸的设定
            buttonParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);//置于底部
            buttonParams1.addRule(RelativeLayout.CENTER_HORIZONTAL);//水平居中
//            button.setPadding(0,0,0,DemileUtils.dp2px(40));
//            buttonParams1.setMarginEnd(DemileUtils.dp2px(40));//错误
            buttonParams1.bottomMargin = DemileUtils.dp2px(30);
            button.setBackgroundResource(R.drawable.select_yindaoye_button);//给BackgroundResource()添加背景选择器
            relativeLayout.addView(button, buttonParams1);
        }

        return relativeLayout;
       /* ImageView imageView=new ImageView(this);
        imageView.setImageResource(id);
        return imageView;*/

    }

    public class YindaoAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ViewGroup group = list.get(position);
            container.addView(group);
            return group;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
