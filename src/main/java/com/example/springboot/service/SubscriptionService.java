package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Subscription;

public interface SubscriptionService {

    public List<Subscription> findAll();
    public Subscription findById(String id);
    public void deleteById(String id);
    public int insert(Subscription subscription);
    
}
