package com.example.jinping.yohuo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.widget.RelativeLayout;

import com.example.jinping.yohuo.base.BaseAnimatorListener;
import com.example.jinping.yohuo.bean.ConfigBean;
import com.example.jinping.yohuo.utils.SPUtils;

import butterknife.Bind;
import butterknife.ButterKnife;


/*
打开App的第一个动画
 */
public class Splash extends AppCompatActivity {

    @Bind(R.id.firstActivity)
    RelativeLayout firstActivity;
    private int height;
    private ObjectAnimator animator;
    private boolean isFirst=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = getWindowManager().getDefaultDisplay().getHeight();
        ButterKnife.bind(this);
        initAnimator();


    }

    private void initAnimator() {
        firstActivity.setTranslationY(-height);
        animator = ObjectAnimator.ofFloat(firstActivity,"translationY",-height,0);
        animator.setDuration(1500);
        animator.setInterpolator(new BounceInterpolator());//添加这句话。直接就能实现动画弹,
        //实现一段时间时候自动跳转下一个页面
        animator.addListener(new BaseAnimatorListener(){
            @Override
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                //在动画结束之后，500秒后就直接跳转
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //判断是否是第一次，进入，第一次进入有引导页，否则没有
                        String s= (String) SPUtils.get(ConfigBean.isFirst);
                        if(s.equals("true")){
                            startActivity(new Intent(Splash.this,YindaoActivity.class));

                        }else{
                            startActivity(new Intent(Splash.this,WelcomeActivity.class));
                        }
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                        finish();
                    }

                },500);
            }
        });//正常设置监听，会实现四个方法，太冗余了，写一个类




    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus&&isFirst){
            isFirst=false;
            animator.start();

        }
    }
}
