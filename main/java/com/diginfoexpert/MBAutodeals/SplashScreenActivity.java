package com.diginfoexpert.MBAutodeals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread myThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);

                    Globals g = new Globals();
                    boolean open = (g.getOpenCount() == 0)?true : false;
                    Intent intent;
                    intent = new Intent(getApplicationContext(),IntroActivity.class);


                    startActivity(intent);
                }

                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();



    }
}
