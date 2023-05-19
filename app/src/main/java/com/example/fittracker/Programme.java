package com.example.fittracker;

import java.util.List;
import java.util.UUID;

public class Programme {

    private String id;
    private String name;
    private String duration;
    private String price;
    private Trainer trainer;
    private List<Exercise> exercises;
    private String description;

    public Programme(String name, String duration, String price, Trainer trainer) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.trainer = trainer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
