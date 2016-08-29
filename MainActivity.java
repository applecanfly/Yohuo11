package com.example.jinping.yohuo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.example.jinping.yohuo.fragment.FragmentCategory;
import com.example.jinping.yohuo.fragment.FragmentHome;
import com.example.jinping.yohuo.fragment.FragmentMine;
import com.example.jinping.yohuo.fragment.FragmentSee;
import com.example.jinping.yohuo.view.MySlidingPaneLayout;
import com.example.jinping.yohuo.view.RadioButtonMain;

import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rabtn_home_main)
    RadioButtonMain rabtnHomeMain;
    @Bind(R.id.rabtn_category_main)
    RadioButtonMain rabtnCategoryMain;
    @Bind(R.id.rabtn_see_main)
    RadioButtonMain rabtnSeeMain;
    @Bind(R.id.rabtn_buy_main)
    RadioButtonMain rabtnBuyMain;
    @Bind(R.id.rabtn_mine_main)
    RadioButtonMain rabtnMineMain;
    @Bind(R.id.radiogroup_main)
    RadioGroup radiogroupMain;
    @Bind(R.id.sliding)
    MySlidingPaneLayout sliding;
    private FragmentManager manager;
    private FragmentHome fragmenthome;
    private FragmentCategory fragmentCategory;
    private FragmentSee fragmentSee;
    private FragmentMine fragmentMine;
    private List<FragmentHome> list;
    private Map<String, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainn);
        ButterKnife.bind(this);
//        saveState(savedInstanceState);
//        initFragment();
        manager = getSupportFragmentManager();

        sliding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliding.closePane();
            }
        });
    }


    private void saveState(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            fragmenthome = new FragmentHome();
            fragmentCategory = new FragmentCategory();
            fragmentSee = new FragmentSee();
            fragmentMine = new FragmentMine();

        } else {
            manager.findFragmentByTag(FragmentHome.class.getSimpleName());
            manager.findFragmentByTag(FragmentCategory.class.getSimpleName());
            manager.findFragmentByTag(FragmentSee.class.getSimpleName());
            manager.findFragmentByTag(FragmentMine.class.getSimpleName());

        }
        rabtnHomeMain.performClick();


    }

  /*  private void initFragment() {
        manager=getSupportFragmentManager();
        fragmenthome = new FragmentHome();
        fragmentCategory=new FragmentCategory();
        fragmentSee=new FragmentSee();
        fragmentMine=new FragmentMine();
       *//* list = new ArrayList<>();
        map = new HashMap<>();
        map.put(fragmenthome.getClass().getSimpleName(), fragmenthome);
        map.put(fragmentCategory.getClass().getSimpleName(), fragmentCategory);
        map.put(fragmentSee.getClass().getSimpleName(), fragmentSee);
        map.put(fragmentMine.getClass().getSimpleName(), fragmentMine);
*//*


    }*/



  /*  private void replaceFragment(int id,String tag) {
        manager.beginTransaction().replace(R.id.fram_main,map.get(String tag),tag);

    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(R.anim.anim_choose_in, R.anim.anim_mian_out);

    }
//设置监听，跳转fragment,购物车跳一个Activity

    @OnClick({R.id.rabtn_home_main, R.id.rabtn_category_main, R.id.rabtn_see_main, R.id.rabtn_buy_main, R.id.rabtn_mine_main, R.id.radiogroup_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rabtn_home_main:

                fragmenthome = new FragmentHome();
                rabtnHomeMain.performClick();
                manager.beginTransaction().replace(R.id.fram_main, fragmenthome, FragmentHome.class.getSimpleName()).commit();


                break;
            case R.id.rabtn_category_main:

                fragmentCategory = new FragmentCategory();
                manager.beginTransaction().replace(R.id.fram_main, fragmentCategory, FragmentCategory.class.getSimpleName()).commit();

               /* fragmentCategory=new FragmentCategory();
                manager.beginTransaction().replace(R.id.fram_main,fragmentCategory,"asd").commit();*/

                break;
            case R.id.rabtn_see_main:

                fragmentSee = new FragmentSee();

                manager.beginTransaction().replace(R.id.fram_main, fragmentSee, FragmentSee.class.getSimpleName()).commit();

                break;
            case R.id.rabtn_buy_main:

                break;
            case R.id.rabtn_mine_main:

                fragmentMine = new FragmentMine();
                manager.beginTransaction().replace(R.id.fram_main, fragmentMine, FragmentMine.class.getSimpleName()).commit();

                break;

        }
    }

    public void open(View v) {
        sliding.openPane();

    }
}
