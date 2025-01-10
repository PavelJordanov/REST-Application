package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Payment;

public interface PaymentService {

    public List<Payment> findAll();
    public Payment findById(String id);
    public void deleteById(String id);
    public int insert(Payment payment);
    
}