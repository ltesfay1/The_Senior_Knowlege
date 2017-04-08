package com.example.lidya.the_senior_knowlege;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by YanruFish on 4/8/2017.
 */

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RelativeLayout advise = (RelativeLayout) findViewById(R.id.advise),
                upper = (RelativeLayout) findViewById(R.id.upper_level),
                rate = (RelativeLayout) findViewById(R.id.rate);

        advise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AdviseActivity.class);
                startActivity(intent);
            }
        });

        upper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, UpperLevelActivity.class);
                startActivity(intent);
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ClassRateActivity.class);
                startActivity(intent);
            }
        });
    }
}
