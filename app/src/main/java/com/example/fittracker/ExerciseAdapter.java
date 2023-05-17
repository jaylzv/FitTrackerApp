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

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    private List<Exercise> exerciseList;
    private Context context;

    public ExerciseAdapter(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exercise_item, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        holder.exerciseName.setText(exercise.getName());
        holder.exerciseSets.setText("Sets: " + exercise.getSets());
        holder.exerciseReps.setText("Reps: " + exercise.getReps());
        holder.exerciseWeight.setText("Weight: " + exercise.getWeight() + " kg");

        // For deleting items
        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(v.getContext())
                    .setTitle("Delete Exercise")
                    .setMessage("Are you sure you want to delete this Exercise?")
                    .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                        int currentPosition = holder.getAdapterPosition();
                        if (currentPosition == RecyclerView.NO_POSITION) return;

                        // Update SharedPreferences
                        SharedPreferences preferences = v.getContext().getSharedPreferences("MyApp", Context.MODE_PRIVATE);
                        String email = preferences.getString("email", null);
                        Gson gson = new Gson();

                        // Remove the item from the list
                        exerciseList.remove(currentPosition);

                        // Update "exerciseList"
                        String json = gson.toJson(exerciseList);
                        preferences.edit().putString(email + "_exercise_list", json).apply();

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
        return exerciseList.size();
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {

        TextView exerciseName, exerciseSets, exerciseReps, exerciseWeight;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            exerciseName = itemView.findViewById(R.id.exercise_name);
            exerciseSets = itemView.findViewById(R.id.exercise_sets);
            exerciseReps = itemView.findViewById(R.id.exercise_reps);
            exerciseWeight = itemView.findViewById(R.id.exercise_weight);
        }
    }
}