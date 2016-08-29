package com.example.jinping.yohuo;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.jinping.yohuo.base.BaseAnimationListener;
import com.example.jinping.yohuo.base.BaseAnimatorListener;
import com.example.jinping.yohuo.base.BaseAnimatorListener;
import com.example.jinping.yohuo.bean.ConfigBean;
import com.example.jinping.yohuo.utils.SPUtils;


import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {


    @Bind(R.id.welcome_iv)
    ImageView welcomeIv;
    @Bind(R.id.welcome_mark_view)
    ImageView welcomeMarkView;
    private ValueAnimator animator;
    private AlphaAnimation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SPUtils.save(ConfigBean.isFirst, "true");
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        welcomeIv.setScaleY(1.5f);
        welcomeIv.setScaleX(1.5f);
        welcomeIv.post(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });
    }

    private void init() {
        animator = ValueAnimator.ofFloat(1.5f, 1);
        animator.setDuration(2000);
        alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new BaseAnimationListener() {
                                                @Override
                                                public void onAnimationEnd(Animation animation) {
                                                    super.onAnimationEnd(animation);
                                                    welcomeMarkView.clearAnimation();
                                                    welcomeMarkView.setVisibility(View.GONE);
                                                    animator.start();
                                                }
                                            }
        );
//        alphaAnimation.set 还可以在chazhiqi中添加动画 判断是否超过0.5f
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                welcomeIv.setScaleX(value);
                welcomeIv.setScaleY(value);
            }
        });
        animator.addListener(new BaseAnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // 过几秒自动跳转另一个activity
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        enter(null);
                    }
                }, 500);
            }
        });
//        ViewGroup
//        animator.addListener();

        welcomeMarkView.startAnimation(alphaAnimation);
    }

    public void start(View v) {
//        if(alphaAnimation.)
        alphaAnimation.cancel();

        welcomeMarkView.clearAnimation();
        animator.removeAllListeners();
        animator.cancel();
//        welcomeMarkView.clearAnimation();
        enter(null);
//        animator.removeAllListeners();

    }

    private void enter(Object o) {
        startActivity(new Intent(this, ChooseActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}
