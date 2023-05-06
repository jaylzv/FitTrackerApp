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

public class ViewFoodActivity extends AppCompatActivity {

    private RecyclerView rvFoodList;
    private FoodAdapter foodAdapter;
    private List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);

        rvFoodList = findViewById(R.id.rv_food_list);
        rvFoodList.setLayoutManager(new LinearLayoutManager(this));

        loadFoodData();

        foodAdapter = new FoodAdapter(foodList, this);
        rvFoodList.setAdapter(foodAdapter);
    }

    private void loadFoodData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("food_list", null);
        Type type = new TypeToken<ArrayList<Food>>(){}.getType();
        foodList = gson.fromJson(json, type);

        if (foodList == null) {
            foodList = new ArrayList<>();
        }
    }
}