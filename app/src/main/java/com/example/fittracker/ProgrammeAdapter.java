package com.example.fittracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProgrammeAdapter extends RecyclerView.Adapter<ProgrammeAdapter.ViewHolder> {

    public interface OnProgrammeClickListener {
        void onProgrammeClick(Programme programme);
    }

    private OnProgrammeClickListener onProgrammeClickListener;

    private List<Programme> programmeList;
    private Context context;

    public ProgrammeAdapter(List<Programme> programmeList, Context context, OnProgrammeClickListener onProgrammeClickListener) {
        this.programmeList = programmeList;
        this.context = context;
        this.onProgrammeClickListener = onProgrammeClickListener;
    }

    @Override
    @NonNull
    public ProgrammeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.programme_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammeAdapter.ViewHolder holder, int position) {
        Programme programme = programmeList.get(position);
        holder.tvProgrammeName.setText(programme.getName());
        holder.tvPrice.setText("Price: " + programme.getPrice());
        holder.tvDuration.setText("Duration: " + programme.getDuration());
        holder.tvTrainerName.setText("Trainer Name: " + programme.getTrainer().getName() + " " + programme.getTrainer().getSurname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProgrammeClickListener.onProgrammeClick(programme);
            }
        });
    }

    @Override
    public int getItemCount() {
        return programmeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProgrammeName;
        TextView tvPrice;
        TextView tvDuration;
        TextView tvTrainerName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProgrammeName = itemView.findViewById(R.id.tv_programme_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvDuration = itemView.findViewById(R.id.tv_duration);
            tvTrainerName = itemView.findViewById(R.id.tv_trainer_name);
        }
    }
}
