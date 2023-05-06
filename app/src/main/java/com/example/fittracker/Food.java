package com.example.fittracker;

public class Food {
    private String name;
    private int calories;
    private int carbohydrates;
    private double proteins;
    private double fats;

    public Food(String name, int calories, int carbohydrates, double proteins, double fats) {
        this.name = name;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
    }

    public String getName() { return name; }
    public int getCalories() { return calories; }
    public int getCarbohydrates() { return carbohydrates; }
    public double getProteins() { return proteins; }
    public double getFats() { return fats; }
}