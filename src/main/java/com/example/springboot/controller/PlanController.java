package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Plan;
import com.example.springboot.service.PlanService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/plan")
public class PlanController {
	@Autowired
	PlanService planService;

	@GetMapping
    public ResponseEntity<List<Plan>> getPlans() {
		System.out.println("HERE!!!");
		return ResponseEntity.ok(planService.findAll());
	}

	@GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable String id) {
		Plan plan = planService.findById(id);
		if (plan == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(plan);
		}
	}

	@PostMapping
    public ResponseEntity<Plan> savePlan(@RequestBody Plan plan) {
		plan.setId(UUID.randomUUID().toString());
		planService.insert(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(plan);
    }

	@PutMapping("/{id}")
	public ResponseEntity<Plan> updatePlanById(@PathVariable String id, @RequestBody Plan plan) {
		plan.setId(id);
		planService.update(plan);
		return ResponseEntity.ok(plan);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlanById(@PathVariable String id) {
		planService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}