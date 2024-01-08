package com.sunbeam.CarApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sunbeam.R;

public class SplashActivity extends AppCompatActivity {
    ImageView as_splashactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        as_splashactivity = findViewById(R.id.as_splashactivity);
        as_splashactivity.startAnimation(AnimationUtils.loadAnimation(this,R.anim.move));
//        Glide.with(this)
//                .load(R.drawable.beancar)
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
//                .into(as_splashactivity);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));

            finish();
        }, 1000);
    }
}