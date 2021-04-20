package com.fcodex.qrscaenner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private MaterialButton scanButton;
    private TextView customActionBarTextView;
    private ImageView customActionBarBackImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id();
        onClick();
        customActionBar();
        ads();

    }


    private void ads() {
        MobileAds.initialize(this);

    }

    private void customActionBar() {
        customActionBarTextView.setText(R.string.app_name);
        customActionBarBackImage.setVisibility(View.INVISIBLE);
    }

    private void onClick() {
        scanButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ScanActivity.class);
            startActivity(intent);
        });
    }

    private void id() {
        scanButton = findViewById(R.id.scanButton);
        customActionBarTextView = findViewById(R.id.customActionBarTextView);
        customActionBarBackImage = findViewById(R.id.customActionBarBackImage);
    }

    @Override
    public void onBackPressed() {
        new MaterialAlertDialogBuilder(MainActivity.this).setIcon(R.drawable.fcodex)
                .setTitle("Exit")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    finishAffinity();
                    System.exit(0);
                })
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel()).show();
    }

}