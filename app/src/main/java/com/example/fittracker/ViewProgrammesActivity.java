package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ViewProgrammesActivity extends AppCompatActivity {

    private RecyclerView rvProgrammeList;
    private ProgrammeAdapter programmeAdapter;
    private List<Programme> programmeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_programmes);

        rvProgrammeList = findViewById(R.id.rv_programme_list);
        rvProgrammeList.setLayoutManager(new LinearLayoutManager(this));

        // Initialize SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        String email = preferences.getString("email", null);
        Gson gson = new Gson();

        // Initialize programmeList from SharedPreferences
        ArrayList<Programme> programmeList;
        String json = preferences.getString(email + "_programme_list", null);
        Type type = new TypeToken<ArrayList<Programme>>() {}.getType();
        if (json == null) {
            // If there is no data in SharedPreferences, initialize foodList as an empty list
            programmeList = new ArrayList<>();
        } else {
            // Otherwise, load the data from SharedPreferences
            programmeList = gson.fromJson(json, type);
        }

        programmeAdapter = new ProgrammeAdapter(programmeList, this, new ProgrammeAdapter.OnProgrammeClickListener() {
            @Override
            public void onProgrammeClick(Programme programme) {
                Intent intent = new Intent(ViewProgrammesActivity.this, ProgrammeDetailActivity2.class);
                intent.putExtra("Programme", programme);
                startActivity(intent);
            }
        });
        rvProgrammeList.setAdapter(programmeAdapter);
    }
}