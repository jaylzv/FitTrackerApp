package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class EnterInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        // Animations for breathing so it's not static and boring
        Button enterExerciseButton = findViewById(R.id.enterExerciseButton);
        Animation breathingAnimation1 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        enterExerciseButton.startAnimation(breathingAnimation1);

        Button enterFoodButton = findViewById(R.id.enterFoodButton);
        Animation breathingAnimation2 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        enterFoodButton.startAnimation(breathingAnimation2);

        // Switching activites
        enterExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterInfoActivity.this, EnterExerciseActivity.class);
                startActivity(intent);
            }
        });

        // Switching activites
        enterFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnterInfoActivity.this, EnterFoodActivity.class);
                startActivity(intent);
            }
        });
    }
}