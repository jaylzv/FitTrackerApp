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
        String json = preferences.getString(email + "_programme_list", null);
        Type type = new TypeToken<ArrayList<Programme>>() {}.getType();
        if (json == null) {
            // If there is no data in SharedPreferences, initialize foodList as an empty list
            programmeList = new ArrayList<>();
        } else {
            // Otherwise, load the data from SharedPreferences
            programmeList = gson.fromJson(json, type);
        }

        // FOR NOW WE ARE GOING TO HAVE HARDCODED IN PROGRAMMES
        programmeList.add(new Programme("Hemsworth training", "7 weeks", "140EUR", new Trainer("Chris", "Hemsworth", "0123", "Movie Star", "chris.hemsworth@example.com")));
        programmeList.add(new Programme("Gymnastics Mastery", "10 weeks", "200EUR", new Trainer("Simone", "Biles", "1234", "Athlete", "simone.biles@example.com")));
        programmeList.add(new Programme("Powerlifting Pro", "12 weeks", "180EUR", new Trainer("Hafthor", "Bjornsson", "5678", "Strength Athlete", "hafthor.bjornsson@example.com")));
        programmeList.add(new Programme("Marathon Training", "16 weeks", "150EUR", new Trainer("Eliud", "Kipchoge", "9012", "Athlete", "eliud.kipchoge@example.com")));
        programmeList.add(new Programme("Yoga Flow", "8 weeks", "120EUR", new Trainer("Adriene", "Mishler", "3456", "Yoga Instructor", "adriene.mishler@example.com")));
        programmeList.add(new Programme("Muay Thai Warrior", "10 weeks", "220EUR", new Trainer("Buakaw", "Banchamek", "7890", "Martial Arts Instructor", "buakaw.banchamek@example.com")));
        programmeList.add(new Programme("CrossFit Challenge", "6 weeks", "180EUR", new Trainer("Mat", "Fraser", "2468", "CrossFit Athlete", "mat.fraser@example.com")));
        programmeList.add(new Programme("Pilates Sculpt", "8 weeks", "160EUR", new Trainer("Cassey", "Ho", "1357", "Pilates Instructor", "cassey.ho@example.com")));
        programmeList.add(new Programme("Cycling Endurance", "12 weeks", "200EUR", new Trainer("Eddy", "Merckx", "8642", "Cycling Coach", "eddy.merckx@example.com")));
        programmeList.add(new Programme("Kickboxing Fusion", "10 weeks", "190EUR", new Trainer("Cristiane", "Justino", "9753", "Martial Arts Instructor", "cristiane.justino@example.com")));
        programmeList.add(new Programme("Functional Fitness", "10 weeks", "170EUR", new Trainer("Rich", "Froning", "6249", "CrossFit Athlete", "rich.froning@example.com")));

        programmeAdapter = new ProgrammeAdapter(programmeList, this, new ProgrammeAdapter.OnProgrammeClickListener() {
            @Override
            public void onProgrammeClick(Programme programme) {
                Intent intent = new Intent(SearchProgrammeActivity.this, ProgrammeDetailActivity.class);
                intent.putExtra("Programme", programme);
                startActivity(intent);
            }
        });
        rvProgrammeList.setAdapter(programmeAdapter);
    }
}