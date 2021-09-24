package com.example.sidemenusakura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sidemenusakura.UserManagement.LoginActivity;

public class StartedImage extends AppCompatActivity {

    private final int SPLASH_SCREEN_TIMER = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_image);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(StartedImage.this, LoginActivity.class);
                startActivity(i);

            }



    }, SPLASH_SCREEN_TIMER);


    }
}