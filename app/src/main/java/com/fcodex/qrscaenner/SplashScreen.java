package com.fcodex.qrscaenner;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar splashProgress;
    private final int SPLASH_TIME = 5000; //This is 3 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        id();
        playProgress();
        progressMethod();

    }

    private void id() {
        splashProgress = findViewById(R.id.splashProgress);
    }

    private void progressMethod() {
        //Code to start timer and take action after the timer ends
        new Handler().postDelayed(() -> {
            //Do any action here. Now we are moving to next page
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            //This 'finish()' is for exiting the app when back button pressed from HomeFragment page which is ActivityHome
            finish();
        }, SPLASH_TIME);
    }

    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "Progress", 100)
                .setDuration(SPLASH_TIME)
                .start();
    }

}