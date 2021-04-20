package com.fcodex.qrscaenner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScanResultActivity extends AppCompatActivity {

    private TextView scanText, data;
    private ImageView sharebtn;
    private TextView customActionBarTextView;
    private ImageView customActionBarBackImage;
    public String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        id();
        getData();
        setData();
        onClick();
        customActionBar();
    }

    private void onClick() {
        customActionBarBackImage.setOnClickListener(v -> {
            Intent intent = new Intent(ScanResultActivity.this, ScanActivity.class);
            startActivity(intent);
            finishAffinity();
            System.exit(0);
        });

        sharebtn.setOnClickListener(view -> {
            try {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
                result = "\n Your Scaned Data\n\n" + result +"\n\n";
                String shareMessage = result + "\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" +
                        getPackageName() + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    private void customActionBar() {
        customActionBarTextView.setText(R.string.app_name);
        customActionBarBackImage.setVisibility(View.VISIBLE);
    }

    private void setData() {
        scanText.setText(result);
    }

    private void getData() {
        try {
            result = getIntent().getExtras().getString("codeScanResult").trim();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void id() {
        customActionBarTextView = findViewById(R.id.customActionBarTextView);
        customActionBarBackImage = findViewById(R.id.customActionBarBackImage);
        //scanText = findViewById(R.id.scanedText);
        scanText = findViewById(R.id.data);
        sharebtn = findViewById(R.id.shareBtn);
    }
}