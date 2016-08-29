package com.example.jinping.yohuo.bean;

import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public class LetterBean {
  public   String title;
  public   List<AllBanner.BrandBean> list;

    public LetterBean(String title, List<AllBanner.BrandBean> list) {
        this.title = title;
        this.list = list;
    }

    @Override
    public String toString() {
        return "LetterBean{" +
                "title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
