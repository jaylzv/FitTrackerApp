package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ViewFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);

        // Retrieve the passed data
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int calories = intent.getIntExtra("calories", 0);
        int carbohydrates = intent.getIntExtra("carbohydrates", 0);
        double proteins = intent.getDoubleExtra("proteins", 0);
        double fats = intent.getDoubleExtra("fats", 0);
    }
}