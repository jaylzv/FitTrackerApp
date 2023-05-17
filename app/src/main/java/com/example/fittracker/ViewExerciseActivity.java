package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
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

        // WHENEVER WE DELTE SOMETHING TO MAKE SURE IT STAYS DELETED AKA LOAD THE DELETED ITEMS
        // Initialize SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        String email = preferences.getString("email", null);
        Gson gson = new Gson();

        // Initialize exerciseList from SharedPreferences
        ArrayList<Exercise> exerciseList;
        String json = preferences.getString(email + "_exercise_list", null);
        Type type = new TypeToken<ArrayList<Exercise>>() {}.getType();
        if (json == null) {
            // If there is no data in SharedPreferences, initialize exerciseList as an empty list
            exerciseList = new ArrayList<>();
        } else {
            // Otherwise, load the data from SharedPreferences
            exerciseList = gson.fromJson(json, type);
        }
        // END OF LINE OF CODE

        exerciseAdapter = new ExerciseAdapter(exerciseList, this);
        rvExerciseList.setAdapter(exerciseAdapter);
    }

    // private void loadExerciseData() {
    //     SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    //     Gson gson = new Gson();
    //     String email = sharedPreferences.getString("email", null);
    //     String json = sharedPreferences.getString(email + "_exercise_list", null);
    //     Type type = new TypeToken<ArrayList<Exercise>>(){}.getType();
    //     exerciseList = gson.fromJson(json, type);
    // 
    //     if (exerciseList == null) {
    //         exerciseList = new ArrayList<>();
    //     }
    // }
}