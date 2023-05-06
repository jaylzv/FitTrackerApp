package com.example.fittracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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