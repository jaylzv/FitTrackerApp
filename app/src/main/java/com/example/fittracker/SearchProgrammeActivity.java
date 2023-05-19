package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SearchProgrammeActivity extends AppCompatActivity {

    private RecyclerView rvProgrammeList;
    private ProgrammeAdapter programmeAdapter;
    private List<Programme> programmeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_programme);

        rvProgrammeList = findViewById(R.id.rv_programme_list);
        rvProgrammeList.setLayoutManager(new LinearLayoutManager(this));

        // Initialize SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        String email = preferences.getString("email", null);
        Gson gson = new Gson();

        // Initialize programmeList from SharedPreferences
        ArrayList<Programme> programmeList;
        String json = preferences.getString(email + "programme_list", null);
        Type type = new TypeToken<ArrayList<Programme>>() {}.getType();
        if (json == null) {
            // If there is no data in SharedPreferences, initialize foodList as an empty list
            programmeList = new ArrayList<>();
        } else {
            // Otherwise, load the data from SharedPreferences
            programmeList = gson.fromJson(json, type);
        }

        // FOR NOW WE ARE GOING TO HAVE HARDCODED IN PROGRAMMES
        programmeList.add(new Programme("Hemsworth training", "7 weeks", "140EUR", new Trainer("Chris", "Hemsworth", "0123")));
        programmeList.add(new Programme("Tom Cruise academy", "12 weeks", "250EUR", new Trainer("Tom", "Cruise", "0001")));

        programmeAdapter = new ProgrammeAdapter(programmeList, this);
        rvProgrammeList.setAdapter(programmeAdapter);
    }
}