package com.example.springboot.controller;

import com.example.springboot.model.Subscription;
import com.example.springboot.service.SubscriptionService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
	SubscriptionService subscriptionService;

	@GetMapping
    public ResponseEntity<List<Subscription>> getSubscriptions() {
		System.out.println("HERE!!!");
		return ResponseEntity.ok(subscriptionService.findAll());
	}

	@GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable String id) {
		Subscription subscription = subscriptionService.findById(id);
		if (subscription == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(subscription);
		}
	}

	@PostMapping
    public ResponseEntity<Subscription> saveSubscription(@RequestBody Subscription subscription) {
		subscription.setId(UUID.randomUUID().toString());
		subscriptionService.insert(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscription);
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSubscriptionById(@PathVariable String id) {
		subscriptionService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
