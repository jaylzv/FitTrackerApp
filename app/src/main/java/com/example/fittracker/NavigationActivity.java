package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        // Animations for breathing so it's not static and boring
        Button infoButton = findViewById(R.id.enterInfoButton);
        Animation breathingAnimation1 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        infoButton.startAnimation(breathingAnimation1);

        Button searchButton = findViewById(R.id.searchButton);
        Animation breathingAnimation2 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        searchButton.startAnimation(breathingAnimation2);

        Button FAQbutton = findViewById(R.id.FAQButton);
        Animation breathingAnimation3 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        FAQbutton.startAnimation(breathingAnimation3);

        Button viewButton = findViewById(R.id.viewButton);
        Animation breathingAnimation4 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        viewButton.startAnimation(breathingAnimation4);

        // Buttons for switching activites
        Button enterInfoButton = findViewById(R.id.enterInfoButton);

        enterInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavigationActivity.this, EnterInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}