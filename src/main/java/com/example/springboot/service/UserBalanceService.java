package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.UserBalance;

public interface UserBalanceService {

    public List<UserBalance> findAll();
    public UserBalance findById(String id);
    public void deleteById(String id);
    public int insert(UserBalance userBalance);
    public int update(UserBalance userBalance);
    
}