package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

                // Create an Exercise object
                Exercise exercise = new Exercise(name, sets, reps, weight);

                // Save the exercise data
                saveExerciseData(exercise);
                nameEditText.setText("");
                setsEditText.setText("");
                repsEditText.setText("");
                weightEditText.setText("");
            }
        });
    }

    private void saveExerciseData(Exercise exercise) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("exercise_list", null);
        Type type = new TypeToken<ArrayList<Exercise>>(){}.getType();
        List<Exercise> exerciseList = gson.fromJson(json, type);

        if (exerciseList == null) {
            exerciseList = new ArrayList<>();
        }

        exerciseList.add(exercise);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        json = gson.toJson(exerciseList);
        editor.putString("exercise_list", json);
        editor.apply();
    }
}