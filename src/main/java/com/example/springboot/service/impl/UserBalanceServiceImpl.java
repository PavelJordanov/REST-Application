package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.UserBalance;
import com.example.springboot.model.Subscription;
import com.example.springboot.model.User;
import com.example.springboot.repository.PlanRepository;
import com.example.springboot.repository.SubscriptionRepository;
import com.example.springboot.repository.UserBalanceRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserBalanceService;

@Service
public class UserBalanceServiceImpl implements UserBalanceService {
    @Autowired
    UserRepository repository;
    @Autowired
    UserBalanceRepository userBalanceRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;

    public List<UserBalance> findAll() {
        System.out.println("HERE2!!!");
        return userBalanceRepository.findAll();
    }
    public UserBalance findById(String id) {
        return userBalanceRepository.findById(id);
    }
    public void deleteById(String id) {
        userBalanceRepository.deleteById(id);
    }
    public int insert(UserBalance userBalance) {
        return userBalanceRepository.insert(userBalance);
    }
    public int update(UserBalance userBalance) {
        return userBalanceRepository.update(userBalance);
    }
}
