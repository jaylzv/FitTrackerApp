package com.example.fittracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private List<Food> foodList;
    private Context context;

    public FoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.tvFoodName.setText(food.getName());
        holder.tvCalories.setText("Calories: " + food.getCalories());
        holder.tvCarbohydrates.setText("Carbs: " + food.getCarbohydrates() + "g");
        holder.tvProteins.setText("Proteins: " + food.getProteins() + "g");
        holder.tvFats.setText("Fats: " + food.getFats() + "g");

        // For deleting items
        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(v.getContext())
                    .setTitle("Delete Food")
                    .setMessage("Are you sure you want to delete this food?")
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                        int currentPosition = holder.getAdapterPosition();
                        if (currentPosition == RecyclerView.NO_POSITION) return;

                        // Update SharedPreferences
                        SharedPreferences preferences = v.getContext().getSharedPreferences("MyApp", Context.MODE_PRIVATE);
                        String email = preferences.getString("email", null);
                        Gson gson = new Gson();

                        // Remove the item from the list
                        foodList.remove(currentPosition);

                        // Update "foodList"
                        String json = gson.toJson(foodList);
                        preferences.edit().putString(email + "_food_list", json).apply();

                        // Notify the adapter
                        notifyDataSetChanged();

                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

            return true;
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFoodName;
        TextView tvCalories;
        TextView tvCarbohydrates;
        TextView tvProteins;
        TextView tvFats;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFoodName = itemView.findViewById(R.id.tv_food_name);
            tvCalories = itemView.findViewById(R.id.tv_calories);
            tvCarbohydrates = itemView.findViewById(R.id.tv_carbohydrates);
            tvProteins = itemView.findViewById(R.id.tv_proteins);
            tvFats = itemView.findViewById(R.id.tv_fats);
        }
    }
}