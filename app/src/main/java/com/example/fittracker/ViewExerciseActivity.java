package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ViewExerciseActivity extends AppCompatActivity {

    private RecyclerView rvExerciseList;
    private ExerciseAdapter exerciseAdapter;
    private List<Exercise> exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        rvExerciseList = findViewById(R.id.rv_exercise_list);
        rvExerciseList.setLayoutManager(new LinearLayoutManager(this));

        loadExerciseData();

        exerciseAdapter = new ExerciseAdapter(exerciseList, this);
        rvExerciseList.setAdapter(exerciseAdapter);
    }

    private void loadExerciseData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("exercise_list", null);
        Type type = new TypeToken<ArrayList<Exercise>>(){}.getType();
        exerciseList = gson.fromJson(json, type);

        if (exerciseList == null) {
            exerciseList = new ArrayList<>();
        }
    }
}