package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class ViewInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info);

        // Animations for breathing so it's not static and boring
        Button viewExerciseButton = findViewById(R.id.viewExerciseButton);
        Animation breathingAnimation1 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        viewExerciseButton.startAnimation(breathingAnimation1);

        Button viewFoodButton = findViewById(R.id.viewFoodButton);
        Animation breathingAnimation2 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        viewFoodButton.startAnimation(breathingAnimation2);

        Button viewProgrammesButton = findViewById(R.id.viewProgrammesButton);
        Animation breathingAnimation3 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        viewProgrammesButton.startAnimation(breathingAnimation3);

        // Switching activites
        viewExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewInfoActivity.this, ViewExerciseActivity.class);
                startActivity(intent);
            }
        });

        // Switching activites
        viewFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewInfoActivity.this, ViewFoodActivity.class);
                startActivity(intent);
            }
        });

        // Switching activites
        viewProgrammesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewInfoActivity.this, ViewProgrammesActivity.class);
                startActivity(intent);
            }
        });
    }
}