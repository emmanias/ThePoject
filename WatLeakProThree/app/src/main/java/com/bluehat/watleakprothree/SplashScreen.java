package com.bluehat.watleakprothree;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences InSplash;
    String state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        InSplash = getSharedPreferences("distData",MODE_PRIVATE);
        state = InSplash.getString("state","");

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                   sleep(3000);

                    if(state.equals("one"))
                    {
                        Intent intent = new Intent(getApplicationContext(),Report.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                    }

                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };



        myThread.start();
    }
}
