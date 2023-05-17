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

        // WHENEVER WE DELTE SOMETHING TO MAKE SURE IT STAYS DELETED AKA LOAD THE DELETED ITEMS
        // Initialize SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
        String email = preferences.getString("email", null);
        Gson gson = new Gson();

        // Initialize foodList from SharedPreferences
        ArrayList<Food> foodList;
        String json = preferences.getString(email + "_food_list", null);
        Type type = new TypeToken<ArrayList<Food>>() {}.getType();
        if (json == null) {
            // If there is no data in SharedPreferences, initialize foodList as an empty list
            foodList = new ArrayList<>();
        } else {
            // Otherwise, load the data from SharedPreferences
            foodList = gson.fromJson(json, type);
        }
        // END OF LINE OF CODE

        foodAdapter = new FoodAdapter(foodList, this);
        rvFoodList.setAdapter(foodAdapter);
    }

    //private void loadFoodData() {
    //    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    //    Gson gson = new Gson();
    //    String email = sharedPreferences.getString("email", null);
    //    String json = sharedPreferences.getString(email + "_food_list", null);
    //    Type type = new TypeToken<ArrayList<Food>>(){}.getType();
    //    foodList = gson.fromJson(json, type);
    //
    //    if (foodList == null) {
    //        foodList = new ArrayList<>();
    //    }
    //}
}