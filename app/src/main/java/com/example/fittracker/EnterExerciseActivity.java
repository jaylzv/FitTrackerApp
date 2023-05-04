package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EnterExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_exercise);

        // To make the logo look like it's breathing
        ImageView rectangleBackground = findViewById(R.id.rectangleBackground);
        Animation breathingAnimation = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        rectangleBackground.startAnimation(breathingAnimation);

        // Set up the onClickListener for the enterButton
        Button enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEditText = findViewById(R.id.nameEditText);
                EditText setsEditText = findViewById(R.id.setsEditText);
                EditText repsEditText = findViewById(R.id.repsEditText);
                EditText weightEditText = findViewById(R.id.weightEditText);

                String name = nameEditText.getText().toString();
                int sets = Integer.parseInt(setsEditText.getText().toString());
                int reps = Integer.parseInt(repsEditText.getText().toString());
                double weight = Double.parseDouble(weightEditText.getText().toString());

                Intent intent = new Intent(EnterExerciseActivity.this, ViewExerciseActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("sets", sets);
                intent.putExtra("reps", reps);
                intent.putExtra("weight", weight);
                startActivity(intent);
            }
        });
    }
}