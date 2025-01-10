package com.example.springboot.model;

public class UserBalance {
    private String id;
    private String uid;
    private int balance;

    public UserBalance() {}

    public UserBalance(String id, String uid, int balance) {
        this.id = id;
        this.uid = uid;
        this.balance = balance;
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

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", uid='" + getUid() + "'" +
            ", balance='" + getBalance() + "'" +
            "}";
    }
}
