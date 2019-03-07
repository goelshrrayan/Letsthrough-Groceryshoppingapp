package com.example.android.letsthrough;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.letsthrough.AccountActivity.LoginActivity;

import static java.lang.Thread.sleep;


public class SplashActivity1 extends AppCompatActivity {
  static private int  SPLASH_SCREEN_TIMEOUT=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        SharedPreferences prefs=getSharedPreferences("prefs",MODE_PRIVATE);
        boolean first=prefs.getBoolean("first",true);
        if(first) {
            Thread myThread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        sleep(2000);
                        Intent intent = new Intent(getApplicationContext(), SplashActivity2.class);
                        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putBoolean("first", false);
                        editor.apply();
                        startActivity(intent);

                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };

            myThread.start();
        }
else {
            Intent intent = new Intent(SplashActivity1.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
