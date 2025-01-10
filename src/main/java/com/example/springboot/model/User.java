package com.example.springboot.model;

public class User {
    
    String firstname;
    String lastname;
    String dob;
    String username;
    String password;
    String id;
    Double weight;
    Double height;
    String fitnessGoal;
    String planID;
    String start;
    String end;

    public User() {
    }

    public User(String firstname, String lastname, String dob, String username, String password, String id, Double weight,
    Double height, String fitnessGoal, String planID, String start, String end) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.fitnessGoal = fitnessGoal;
        this.planID = planID;
        this.start = start;
        this.end = end;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getFitnessGoal() {
        return this.fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public String getPlanID() {
        return this.planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" +
            " firstname='" + getFirstname() + "'" +
            ", lastname='" + getLastname() + "'" +
            ", dob='" + getDob() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", id='" + getId() + "'" +
            ", weight='" + getWeight() + "'" +
            ", height='" + getHeight() + "'" +
            ", fitnessGoal='" + getFitnessGoal() + "'" +
            ", planID='" + getPlanID() + "'" +
            ", start='" + getStart() + "'" +
            ", end='" + getEnd() + "'" +
            "}";
    }    
}
