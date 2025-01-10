package com.example.springboot.model;

public class Subscription {
    private String id;
    private String uid;
    private String pid;
    private String start;
    private String end;
    private int price;

    public Subscription() {
    }

    public Subscription(String id, String uid, String pid, String start, String end, int price) {
        this.id = id;
        this.uid = uid;
        this.pid = pid;
        this.start = start;
        this.end = end;
        this.price = price;
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

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", uid='" + getUid() + "'" +
            ", pid='" + getPid() + "'" +
            ", start='" + getStart() + "'" +
            ", end='" + getEnd() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}
