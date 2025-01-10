package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Plan;
import com.example.springboot.repository.PlanRepository;
import com.example.springboot.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    PlanRepository repository;

    public List<Plan> findAll() {
        System.out.println("HERE2!!!");
        return repository.findAll();
    }
    public Plan findById(String id) {
        return repository.findById(id);
    }
    public void deleteById(String id) {
        repository.deleteById(id);
    }
    public int insert(Plan plan) {
        return repository.insert(plan);
    }
    public int update(Plan plan) {
        return repository.update(plan);
    }
}
