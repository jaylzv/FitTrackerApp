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

                Intent intent = new Intent(EnterFoodActivity.this, ViewFoodActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("calories", calories);
                intent.putExtra("carbohydrates", carbohydrates);
                intent.putExtra("proteins", proteins);
                intent.putExtra("fats", fats);
                startActivity(intent);
            }
        });
    }
}