package com.example.fittracker;

import java.util.UUID;

public class Trainer {

    private String id;
    private String name;
    private String surname;
    private String telephone;
    private String type;
    private String email;

    public Trainer(String name, String surname, String telephone, String type, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.type = type;
        this.email = email;
    }

    public void giveFeedback() {

    }

    public void publishWorkout() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
