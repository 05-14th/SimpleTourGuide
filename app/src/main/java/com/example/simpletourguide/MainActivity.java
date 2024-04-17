package com.example.simpletourguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ScrollView scrollView;
    private LinearLayout scrollLayout;

    private Timer timer;
    private Handler handler;

    private int scrollSpeed = 50; // Adjust scroll speed (milliseconds)
    private int scrollAmount = 1; // Adjust scroll amount (pixels)
    private int delayBeforeStart = 5000;

    // Urls of our images.
    String url1 = "https://i.ibb.co/mX2tCp6/photo1.jpg";
    String url2 = "https://i.ibb.co/nz8NJyM/photo2.jpg";
    String url3 = "https://i.ibb.co/94VXFLj/photo3.jpg";
    String url4 = "https://i.ibb.co/Z2kD7kG/photo4.jpg";
    String url5 = "https://i.ibb.co/5k7Z8c2/photo5.jpg";
    String url6 = "https://i.ibb.co/GVm5tzc/photo6.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.imageSlider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
        sliderDataArrayList.add(new SliderData(url4));
        sliderDataArrayList.add(new SliderData(url5));
        sliderDataArrayList.add(new SliderData(url6));


        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
        scrollView = findViewById(R.id.scrollView);
        scrollLayout = findViewById(R.id.scrollLayout);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startAutoScroll();
            }
        }, delayBeforeStart);

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                    // ScrollView reached bottom, reset auto-scrolling
                    resetAutoScroll();
                }
            }
        });

        FloatingActionButton myFab = findViewById(R.id.floatingActionButton);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent);
            }
        });


    }
    private void startAutoScroll() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // Smoothly scroll to the bottom
                        scrollView.smoothScrollBy(0, scrollAmount);
                    }
                });
            }
        }, 0, scrollSpeed); // Start scrolling immediately and repeat at the specified interval
    }

    private void resetAutoScroll() {
        // Cancel the current auto-scrolling timer
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        scrollView.smoothScrollTo(0, 0);

        // Start auto-scrolling again
        startAutoScroll();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

}
