package com.example.springboot.model;

public class Product {

    String id;
    String name;
    String group;

    public Product() {
    }

    public Product(String id, String name, String group) {
        this.id = id;
        this.name = name;
        this.group = group;
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

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", group='" + getGroup() + "'" +
            "}";
    }
    
}
