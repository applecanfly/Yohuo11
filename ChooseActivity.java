package com.example.jinping.yohuo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jinping on 2016/8/22.
 */
public class ChooseActivity extends AppCompatActivity {
    @Bind(R.id.button_boy_choose)
    ImageButton buttonBoyChoose;
    @Bind(R.id.button_girl_choose)
    ImageButton buttonGirlChoose;
    @Bind(R.id.button_child_choose)
    ImageButton buttonChildChoose;
    @Bind(R.id.button_style_choose)
    ImageButton buttonStyleChoose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        ButterKnife.bind(this);

    }

    public void start(View view) {
        startActivity(new Intent(ChooseActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.anim_main_in, R.anim.anim_choose_out);


    }


}
