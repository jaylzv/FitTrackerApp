package com.example.fittracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrainerAdapter extends RecyclerView.Adapter<TrainerAdapter.ViewHolder> {

    private List<Trainer> TrainerList;
    private Context context;

    public TrainerAdapter(List<Trainer> TrainerList, Context context) {
        this.TrainerList = TrainerList;
        this.context = context;
    }

    @Override
    @NonNull
    public TrainerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainerAdapter.ViewHolder holder, int position) {
        Trainer Trainer = TrainerList.get(position);
        holder.tvTrainerName.setText(Trainer.getName() + " " + Trainer.getSurname());
        holder.tvTelephone.setText("Telephone: " + Trainer.getTelephone());
        holder.tvType.setText("Type: " + Trainer.getType());
        holder.tvEmail.setText("Email: " + Trainer.getEmail());
    }

    @Override
    public int getItemCount() {
        return TrainerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTrainerName;
        TextView tvTelephone;
        TextView tvType;
        TextView tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTrainerName = itemView.findViewById(R.id.tv_trainer_name);
            tvTelephone = itemView.findViewById(R.id.tv_telephone_number);
            tvType = itemView.findViewById(R.id.tv_type);
            tvEmail = itemView.findViewById(R.id.tv_email);
        }
    }
}
