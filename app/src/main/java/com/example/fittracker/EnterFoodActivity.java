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

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EnterFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_food);

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
                EditText caloriesEditText = findViewById(R.id.caloriesEditText);
                EditText carbohydratesEditText = findViewById(R.id.carbohydratesEditText);
                EditText proteinsEditText = findViewById(R.id.proteinsEditText);
                EditText fatsEditText = findViewById(R.id.fatsEditText);

                String name = nameEditText.getText().toString();
                int calories = Integer.parseInt(caloriesEditText.getText().toString());
                int carbohydrates = Integer.parseInt(carbohydratesEditText.getText().toString());
                double proteins = Double.parseDouble(proteinsEditText.getText().toString());
                double fats = Double.parseDouble(fatsEditText.getText().toString());

                Food newFood = new Food(name, calories, carbohydrates, proteins, fats);
                saveFoodData(newFood);

                // Clear the input fields after saving the food data
                nameEditText.setText("");
                caloriesEditText.setText("");
                carbohydratesEditText.setText("");
                proteinsEditText.setText("");
                fatsEditText.setText("");
            }
        });
    }

    private void saveFoodData(Food newFood) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("food_list", null);
        Type type = new TypeToken<ArrayList<Food>>(){}.getType();
        ArrayList<Food> foodList = gson.fromJson(json, type);

        if (foodList == null) {
            foodList = new ArrayList<>();
        }

        foodList.add(newFood);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        json = gson.toJson(foodList);
        editor.putString("food_list", json);
        editor.apply();
    }
}