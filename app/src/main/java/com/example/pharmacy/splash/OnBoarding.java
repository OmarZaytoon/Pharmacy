package com.example.pharmacy.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pharmacy.R;
import com.example.pharmacy.avtivities.CreateOrSignin;

public class OnBoarding extends AppCompatActivity {
    ViewPager viewPager2;
    LinearLayout dots_layout;

    TextView[] dots;

    SliderAdapter sliderAdapter;
    Button getStarted;
    Animation animation;
    int curPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);



        getStarted=findViewById(R.id.onBoarding_btn_get_started);
        viewPager2=findViewById(R.id.slider);
        dots_layout=findViewById(R.id.dots);

        sliderAdapter = new SliderAdapter(this);
        viewPager2.setAdapter(sliderAdapter);
        addDots(0);
        viewPager2.addOnPageChangeListener(changeListener);
    }
    private void addDots(int position){

        dots = new TextView[3];
        dots_layout.removeAllViews();
        for(int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dots_layout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.purple_500));
        }
    }
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            curPos = position;

            if(position==0){
                getStarted.setVisibility(View.INVISIBLE);

            }else if(position==1){
                getStarted.setVisibility(View.INVISIBLE);
            }else{
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                getStarted.setAnimation(animation);
                getStarted.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public void skipMethod(View view){
        startActivity(new Intent(getApplicationContext(), CreateOrSignin.class));
        finish();

    }
    public void nextMethod(View view){
        viewPager2.setCurrentItem(curPos+1);

    }

    public void getStartedMethod(View view) {
        startActivity(new Intent(getApplicationContext(),CreateOrSignin.class));
        finish();
    }
}