package com.example.android.letsthrough;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.letsthrough.AccountActivity.LoginActivity;


public class SplashActivity3 extends AppCompatActivity {
  static private int  SPLASH_SCREEN_TIMEOUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);
        Thread myThread=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                    finish();
                }catch (InterruptedException e)
                {e.printStackTrace();}

            }
        };
        myThread.start();


    }
}
