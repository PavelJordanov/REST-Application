package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Subscription;
import com.example.springboot.repository.SubscriptionRepository;
import com.example.springboot.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{
    @Autowired
    SubscriptionRepository repository;

    public List<Subscription> findAll() {
        System.out.println("HERE2!!!");
        return repository.findAll();
    }
    public Subscription findById(String id) {
        return repository.findById(id);
    }
    public void deleteById(String id) {
        repository.deleteById(id);
    }
    public int insert(Subscription subscription) {
        return repository.insert(subscription);
    }
}
