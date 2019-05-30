package com.example.hellocompat;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView mHelloTV;
    private String[] mColorArr={"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTV = findViewById(R.id.hello_textView);
        if (savedInstanceState != null) {
            mHelloTV.setTextColor(savedInstanceState.getInt("color"));
        }
    }
        public void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            // save the current text color
            outState.putInt("color", mHelloTV.getCurrentTextColor());
        }

    public void changecolor(View view) {
        Random random=new Random();
        String colorName=mColorArr[random.nextInt(20)];

        int colorResourceName =getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());

        int colorRes= ContextCompat.getColor(this,colorResourceName);
        mHelloTV.setTextColor(colorRes);
    }
}
