package com.diginfoexpert.MBAutodeals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mPager;
    private int[] layouts = {R.layout.activity_intro_slide1,R.layout.activity_intro_slide2,R.layout.activity_intro_slide3};
    private myPagerAdapter mPagerAdapter;

    private LinearLayout Dots_Layout;
    private ImageView[] dots;

    private Button bnSkip, bnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(new PreferenceManager(this).checkPreferences()){
            loadHome();
        }

        if(Build.VERSION.SDK_INT>=19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_intro);

        mPager = (ViewPager) findViewById(R.id.myPager);
        mPagerAdapter = new myPagerAdapter(layouts,this);
        mPager.setAdapter(mPagerAdapter);

        Dots_Layout = (LinearLayout)findViewById(R.id.dotsLayout);
        bnSkip = (Button)findViewById(R.id.skipButton);
        bnNext = (Button)findViewById(R.id.nextButton);
        bnSkip.setOnClickListener(this);
        bnNext.setOnClickListener(this);

        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                createDots(position);
                if(position == layouts.length-1){
                    bnNext.setText("Start");
                    bnSkip.setVisibility(View.INVISIBLE);
                }

                else{
                    bnNext.setText("Next");
                    bnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    private void createDots(int currentPosition){
        if(Dots_Layout != null){
            Dots_Layout.removeAllViews();
        }

        dots = new ImageView[layouts.length];

        for(int i=0;i<layouts.length;i++){
            dots[i] = new ImageView(this);
            if(i==currentPosition){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }

            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);

            Dots_Layout.addView(dots[i],params);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nextButton:
                nextSlide();
                break;

            case R.id.skipButton:
                loadHome();
                new PreferenceManager(this).writePreferences();
                break;
        }

    }

    private void loadHome(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    private void nextSlide(){
        int nextSlide = mPager.getCurrentItem()+1;

        if(nextSlide < layouts.length){
            mPager.setCurrentItem(nextSlide);
        }

        else{
            loadHome();
            new PreferenceManager(this).writePreferences();
        }
    }

}
