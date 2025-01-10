package com.example.springboot.service;

import java.util.List;

import com.example.springboot.model.Plan;

public interface PlanService {

    public List<Plan> findAll();
    public Plan findById(String id);
    public void deleteById(String id);
    public int insert(Plan plan);
    public int update(Plan plan);
    
}