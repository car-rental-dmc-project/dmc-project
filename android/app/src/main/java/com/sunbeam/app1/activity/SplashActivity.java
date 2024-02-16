package com.sunbeam.app1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunbeam.app1.R;
import com.sunbeam.app1.utility.CarRentalConstants;

public class SplashActivity extends AppCompatActivity {

    ImageView car;
    TextView name;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        car = findViewById(R.id.car);
        name = findViewById(R.id.logoName);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_move);
        car.startAnimation(animation);
        name.startAnimation(animation);

        if (getSharedPreferences(CarRentalConstants.SHARED_PREFERENCE_FILE_NAME, MODE_PRIVATE).getBoolean(CarRentalConstants.LOGIN_STATUS, false)) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(car, "logo_car");
                pairs[1] = new Pair<View, String>(name, "logo_name");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }, 1000);
        }
    }
}