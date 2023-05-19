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

public class SearchTrainerActivity extends AppCompatActivity {

    private RecyclerView rvTrainerList;
    private TrainerAdapter trainerAdapter;
    private List<Trainer> trainerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trainer);

        rvTrainerList = findViewById(R.id.rv_trainer_list);
        rvTrainerList.setLayoutManager(new LinearLayoutManager(this));

        // Initialize SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        String email = preferences.getString("email", null);
        Gson gson = new Gson();

        // Initialize programmeList from SharedPreferences
        ArrayList<Trainer> trainerList;
        String json = preferences.getString(email + "_trainer_list", null);
        Type type = new TypeToken<ArrayList<Trainer>>() {}.getType();
        if (json == null) {
            // If there is no data in SharedPreferences, initialize foodList as an empty list
            trainerList = new ArrayList<>();
        } else {
            // Otherwise, load the data from SharedPreferences
            trainerList = gson.fromJson(json, type);
        }

        trainerList.add(new Trainer("Chris", "Hemsworth", "069 069 069", "Conditioning", "chris.hemsworth@example.com"));
        trainerList.add(new Trainer("Simone", "Biles", "051 987 654", "Athlete", "simone.biles@example.com"));
        trainerList.add(new Trainer("Hafthor", "Bjornsson", "068 111 222", "Strength Athlete", "hafthor.bjornsson@example.com"));
        trainerList.add(new Trainer("Eliud", "Kipchoge", "041 333 444", "Athlete", "eliud.kipchoge@example.com"));
        trainerList.add(new Trainer("Adriene", "Mishler", "061 555 666", "Yoga Instructor", "adriene.mishler@example.com"));
        trainerList.add(new Trainer("Buakaw", "Banchamek", "064 777 888", "Martial Arts Instructor", "buakaw.banchamek@example.com"));
        trainerList.add(new Trainer("Mat", "Fraser", "065 999 000", "CrossFit Athlete", "mat.fraser@example.com"));
        trainerList.add(new Trainer("Cassey", "Ho", "061 222 333", "Pilates Instructor", "cassey.ho@example.com"));
        trainerList.add(new Trainer("Eddy", "Merckx", "040 444 555", "Cycling Coach", "eddy.merckx@example.com"));
        trainerList.add(new Trainer("Cristiane", "Justino", "051 666 777", "Martial Arts Instructor", "cristiane.justino@example.com"));
        trainerList.add(new Trainer("Rich", "Froning", "068 888 999", "CrossFit Athlete", "rich.froning@example.com"));
        trainerList.add(new Trainer("John", "Doe", "041 111 222", "Personal Trainer", "john.doe@example.com"));
        trainerList.add(new Trainer("Jane", "Smith", "065 333 444", "Group Fitness Instructor", "jane.smith@example.com"));
        trainerList.add(new Trainer("Alex", "Johnson", "061 555 666", "Sports Coach", "alex.johnson@example.com"));

        trainerAdapter = new TrainerAdapter(trainerList, this);
        rvTrainerList.setAdapter(trainerAdapter);
    }
}