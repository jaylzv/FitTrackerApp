package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ViewExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        // Retrieve the passed data
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int sets = intent.getIntExtra("sets", 0);
        int reps = intent.getIntExtra("reps", 0);
        double weight = intent.getDoubleExtra("weight", 0);
    }
}