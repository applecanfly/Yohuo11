package com.example.jinping.yohuo.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.jinping.yohuo.R;
import com.example.jinping.yohuo.adapter.CateTileBaseAdapter;
import com.example.jinping.yohuo.base.BaseFragment;
import com.example.jinping.yohuo.bean.CateTileBean;
import com.example.jinping.yohuo.adapter.CateTileBaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/8/24.
 */
public class BaseFragmentCateTitle extends BaseFragment implements AdapterView.OnItemClickListener {

    protected List<CateTileBean> list;
    @Bind(R.id.lv)
    ListView categoryLv;
    @Bind(R.id.iv_arrow)
    ImageView ivArrow;
    @Bind(R.id.childLv)
    protected ListView childLv;
    @Bind(R.id.childCategory)
    LinearLayout childCategory;
    private int width;
    private ObjectAnimator animator;
    private int childPositin = -1;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.cateboys_frag, container, false);
        ButterKnife.bind(this, view);
        initAnimaion();
        return view;
    }

    private void initAnimaion() {
        animator = ObjectAnimator.ofFloat(childCategory, "translationX", 0, 0);
        animator.setDuration(300);

    }

    private void openChild() {
        animator.cancel();
        animator.setFloatValues(width, 0);
        animator.start();
    }

    private void closeChild() {
        animator.cancel();
        animator.setFloatValues(0, width);
        animator.start();
    }

    @Override
    public void initData() {
        list = new ArrayList<>();
    }

    @Override
    public void initAdapter() {
        super.initAdapter();
        categoryLv.setAdapter(new CateTileBaseAdapter(list, a));
        categoryLv.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 完成第二层目录数据的请求
        if (position != childPositin && childPositin >= 0) {
            // 切换数据
            childPositin = position;
        } else if (childPositin == -1) {
            openChild();
            childPositin = position;
        } else {

            closeChild();
            childPositin = -1;
        }

        loadChildData();
    }

    private void loadChildData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        width = a.getWindowManager().getDefaultDisplay().getWidth() / 2;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) childCategory.getLayoutParams();
        params.width = width;
        childCategory.setLayoutParams(params);
        childCategory.setTranslationX(width);

        return rootView;
    }
}
