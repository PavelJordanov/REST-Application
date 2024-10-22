package com.example.springboot;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(String id);
    public void deleteById(String id);
    public int insert(User user);
    public int update(User user);

    
}