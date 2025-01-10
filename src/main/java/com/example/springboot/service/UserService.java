package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.User;

public interface UserService {

    public List<User> findAll();
    public User findById(String id);
    public void deleteById(String id);
    public int insert(User user);
    public int update(User user);

    
}