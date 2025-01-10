package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Payment;
import com.example.springboot.repository.PaymentRepository;
import com.example.springboot.service.PaymentService;

import com.example.springboot.model.UserBalance;
import com.example.springboot.model.Subscription;
import com.example.springboot.model.User;
import com.example.springboot.repository.PlanRepository;
import com.example.springboot.repository.SubscriptionRepository;
import com.example.springboot.repository.UserBalanceRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserBalanceService;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository repository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserBalanceRepository userBalanceRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;

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
        // Get UserId from payment object
        String userId = payment.getUid();

        // Use the uid to find the associated UserBalance Record
        UserBalance existingUserBalance = userBalanceRepository.findByUid(userId);
        if (existingUserBalance == null) {
            throw new IllegalArgumentException("User balance not found for user ID: " + userId);
        }
        
        int oldBalance = existingUserBalance.getBalance();
        int newBalance = oldBalance + payment.getAmount();
        existingUserBalance.setBalance(newBalance);
        
        return repository.insert(payment);
    }
}
