package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ProgrammeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme_detail);

        TextView tvProgrammeName = findViewById(R.id.tv_programme_name);
        TextView tvProgrammePrice = findViewById(R.id.tv_programme_price);
        TextView tvProgrammeDuration = findViewById(R.id.tv_programme_duration);
        TextView tvProgrammeTrainer = findViewById(R.id.tv_programme_trainer);
        TextView tvProgrammeDescription = findViewById(R.id.tv_programme_description);
        Button btnPurchase = findViewById(R.id.btn_purchase);

        Programme programme = (Programme) getIntent().getSerializableExtra("Programme");

        tvProgrammeName.setText("Name: " + programme.getName());
        tvProgrammePrice.setText("Price: " + programme.getPrice());
        tvProgrammeDuration.setText("Duration: " + programme.getDuration());
        tvProgrammeTrainer.setText("Trainer: " + programme.getTrainer().getName() + " " + programme.getTrainer().getSurname());

        // Setting the description
        String description = generateDescription();
        programme.setDescription(description);

        tvProgrammeDescription.setText("Description: " + programme.getDescription());

        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgrammeDetailActivity.this, PaymentActivity.class);
                intent.putExtra("Programme", programme);
                startActivity(intent);
            }
        });
    }

    private String generateDescription() {
        String[] descriptions = {
                "This is a high-intensity programme designed to help you lose weight and build muscle.",
                "A comprehensive programme for improving flexibility and strength.",
                "A specially designed programme for beginners to get started with fitness training.",
                "An intense cardio-focused programme to boost your cardiovascular endurance.",
                "A full-body workout programme that targets all major muscle groups.",
                "A specialized programme for athletes looking to enhance their performance.",
                "A challenging programme that combines weightlifting and bodyweight exercises.",
                "A fun and energetic programme inspired by dance and rhythm.",
                "An outdoor fitness programme that takes advantage of natural surroundings.",
                "A core-focused programme to strengthen your abdominal and back muscles.",
                "A holistic programme that combines yoga, meditation, and mindfulness practices.",
                "A bodyweight-only programme that can be done anytime, anywhere.",
                "A functional fitness programme that improves your ability to perform daily activities.",
                "A circuit training programme that keeps your heart rate up for maximum calorie burn.",
                "A strength and conditioning programme for building muscle and improving endurance.",
                "A high-intensity interval training (HIIT) programme for maximum fat burning.",
                "A program designed specifically for seniors to improve mobility and overall fitness.",
                "A sports-specific training programme tailored to your chosen sport.",
                "A program focused on improving balance, coordination, and stability.",
                "A postnatal fitness programme to help new moms regain strength and fitness.",
        };
        int index = new Random().nextInt(descriptions.length);
        return descriptions[index];
    }
}