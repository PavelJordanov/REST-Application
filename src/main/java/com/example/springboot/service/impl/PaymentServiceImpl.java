package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Payment;
import com.example.springboot.repository.PaymentRepository;
import com.example.springboot.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository repository;

    public List<Payment> findAll() {
        System.out.println("HERE2!!!");
        return repository.findAll();
    }
    public Payment findById(String id) {
        return repository.findById(id);
    }
    public void deleteById(String id) {
        repository.deleteById(id);
    }
    public int insert(Payment payment) {
        return repository.insert(payment);
    }
}
