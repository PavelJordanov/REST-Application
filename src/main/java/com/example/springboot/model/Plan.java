package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private String id;
    private String name;
    private String description;
    private String type; // training routine or nutrition plan or a combination of both
    private int durationInWeeks;
    private int price;
    private int numclients;

    private List<String> userIds = new ArrayList<>(); // Store linked users' IDs

    public Plan() {
    }
    
    public Plan(String id, String name, String description, String type, int durationInWeeks, int price, int numclients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.durationInWeeks = durationInWeeks;
        this.price = price;
        this.numclients = 0; // Start with 0 clients
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDurationInWeeks() {
        return this.durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumclients() {
        return this.numclients;
    }

    public void setNumclients(int numclients) {
        this.numclients = numclients;
    }

    public void addUser(String userId) {
        userIds.add(userId);
        numclients++;
    }

    public void removeUser(String userId) {
        userIds.remove(userId);
        if (numclients > 0) {
            numclients--;
        }
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            ", durationInWeeks='" + getDurationInWeeks() + "'" +
            ", price='" + getPrice() + "'" +
            ", numclients='" + getNumclients() + "'" +
            "}";
    }    
}


