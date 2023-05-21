package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ProgrammeDetailActivity2 extends AppCompatActivity {
    private static final Random RANDOM = new Random();

    private static final String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    private static final List<String> EXERCISES = Arrays.asList(
            "Bench press 4x10 20kg",
            "The fly 4x12 10kg",
            "Pushups 5x20",
            "Squats 4x10 50kg",
            "Leg press 4x12 80kg",
            "Deadlift 4x10 60kg",
            "Bicep curls 4x10 15kg",
            "Tricep dips 4x10",
            "Lunges 4x10 20kg",
            "Pullups 4x10",
            "Burpees 4x15",
            "Plank 3x60s",
            "Mountain Climbers 4x15",
            "Sit-ups 4x20",
            "Russian Twists 4x15",
            "Jumping Jacks 4x30",
            "Barbell Row 4x10 30kg",
            "Lat Pulldown 4x12 30kg",
            "Dumbbell Press 4x10 15kg",
            "Kettlebell Swing 4x15 20kg",
            "Lateral Raises 4x15 10kg",
            "Front Raises 4x15 10kg",
            "Overhead Press 4x10 20kg",
            "Treadmill Run 30min",
            "Stationary Bike 30min",
            "Step-ups 4x15",
            "Box Jumps 4x15",
            "Hip Thrusts 4x10 40kg",
            "Glute Bridge 4x15",
            "Hamstring Curl 4x12 30kg",
            "Calf Raises 4x20 20kg",
            "Ab Roller 4x15",
            "Hanging Leg Raises 4x15",
            "Dips 4x10",
            "Push Press 4x10 30kg",
            "Incline Dumbbell Press 4x10 20kg",
            "Decline Dumbbell Press 4x10 20kg",
            "Goblet Squat 4x10 20kg",
            "Walking Lunge 4x15",
            "Seated Leg Curl 4x12 30kg",
            "Leg Extensions 4x12 30kg",
            "Jump Rope 5min",
            "Farmer's Walk 3x30s 20kg",
            "Tire Flip 3x10",
            "Battle Ropes 3x30s"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programme_detail2);

        TextView tvProgrammeName = findViewById(R.id.tv_programme_name);
        TextView tvProgrammePrice = findViewById(R.id.tv_programme_price);
        TextView tvProgrammeDuration = findViewById(R.id.tv_programme_duration);
        TextView tvProgrammeTrainer = findViewById(R.id.tv_programme_trainer);
        TextView tvProgrammeDescription = findViewById(R.id.tv_programme_description);
        TextView tvProgrammeExercises = findViewById(R.id.tv_programme_exercises);

        Programme programme = (Programme) getIntent().getSerializableExtra("Programme");

        tvProgrammeName.setText("Name: " + programme.getName());
        tvProgrammePrice.setText("Price: " + programme.getPrice());
        tvProgrammeDuration.setText("Duration: " + programme.getDuration());
        tvProgrammeTrainer.setText("Trainer: " + programme.getTrainer().getName() + " " + programme.getTrainer().getSurname());

        // Setting the description
        String description = generateDescription();
        programme.setDescription(description);
        tvProgrammeDescription.setText("Description: " + programme.getDescription());

        // Generate and set the workout plan.
        String workoutPlan = generateWorkoutPlan();
        tvProgrammeExercises.setText(workoutPlan);
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
                "A postnatal fitness programme to help new moms regain strength and fitness."
        };
        int index = RANDOM.nextInt(descriptions.length);
        return descriptions[index];
    }

    private String generateWorkoutPlan() {
        StringBuilder workoutPlan = new StringBuilder();

        Collections.shuffle(EXERCISES);

        for (String day : DAYS) {
            workoutPlan.append(day).append(":\n");

            for (int i = 0; i < 3; i++) {
                String exercise = EXERCISES.get(i);
                workoutPlan.append(exercise).append("\n");
            }

            workoutPlan.append("\n");
        }

        return workoutPlan.toString();
    }
}