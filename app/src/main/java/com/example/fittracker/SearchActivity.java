package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button searchProgrammeButton = findViewById(R.id.searchProgrammeButton);
        Button searchTrainerButton = findViewById(R.id.searchTrainerButton);

        Animation breathingAnimation1 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        searchProgrammeButton.startAnimation(breathingAnimation1);

        Animation breathingAnimation2 = AnimationUtils.loadAnimation(this, R.anim.breathing_animation);
        searchTrainerButton.startAnimation(breathingAnimation2);

        searchProgrammeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, SearchProgrammeActivity.class);
                startActivity(intent);
            }
        });

        searchTrainerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, SearchTrainerActivity.class);
                startActivity(intent);
            }
        });
    }
}