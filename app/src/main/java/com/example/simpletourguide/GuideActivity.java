package com.example.simpletourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript if needed
        webView.loadUrl("https://www.google.com/maps/@14.1375356,122.9794254,15.75z?entry=ttu");

        Button beachButton = findViewById(R.id.beach);
        Button airportButton = findViewById(R.id.airport);
        Button lighthouseButton = findViewById(R.id.lighthouse);
        Button boulevardButton = findViewById(R.id.boulevard);
        Button exitButton = findViewById(R.id.exit);
        beachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.google.com/maps/place/Bagasbas+Beach/@14.1355039,122.9791707,16z/data=!3m1!4b1!4m6!3m5!1s0x3398ae08a0de8c11:0x645b6d833e59210f!8m2!3d14.1351657!4d122.9842157!16s%2Fg%2F1tfljzcb?entry=ttu");
            }
        });

        airportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.google.com/maps/place/Daet+Airport/@14.1320161,122.9801399,17z/data=!3m1!4b1!4m6!3m5!1s0x3398ae0eb6381439:0x5a49bd5064fe6f17!8m2!3d14.1320161!4d122.9827202!16s%2Fm%2F047g96p?entry=ttu");
            }
        });

        lighthouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.google.com/maps/place/Bagasbas+Lighthouse+Hotel+Resort/@14.133288,122.9815257,17z/data=!3m1!4b1!4m9!3m8!1s0x3398ae08c6745969:0x43dd94047110daac!5m2!4m1!1i2!8m2!3d14.133288!4d122.984106!16s%2Fg%2F1trsvk04?entry=ttu");
            }
        });

        boulevardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://www.google.com/maps/place/4XJP%2BH34+Cory+Aquino+blvd,+cor+Castro+Dr,+Daet,+Camarines+Norte/@14.1309325,122.9814994,16z/data=!4m6!3m5!1s0x3398ae096e6262b3:0x1287d7dec4bcf962!8m2!3d14.1313799!4d122.9851579!16s%2Fg%2F11gjw99bxx?entry=ttu");
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();

            }
        });

    }


}