package com.example.to_dolist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    private ImageView logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        logo = findViewById(R.id.logo);

        logo.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_in));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.startAnimation(AnimationUtils.loadAnimation(SplashScreen.this, R.anim.splash_out));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logo.setVisibility(View.GONE);
                        startActivity(new Intent(SplashScreen.this, ToDoListActivity.class));
                        finish();
                    }
                }, 500);
            }
        }, 2000);
    }
}