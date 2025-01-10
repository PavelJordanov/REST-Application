package com.example.springboot.model;

public class Payment {
    private String id;
    private String uid;
    private String type;
    private int amount;
    private String date;

    public Payment() {}

    public Payment(String id, String uid, String type, int amount, String date) {
        this.id = id;
        this.uid = uid;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", uid='" + getUid() + "'" +
            ", type='" + getType() + "'" +
            ", amount='" + getAmount() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}
