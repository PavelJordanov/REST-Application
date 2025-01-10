package com.example.springboot.controller;
import com.example.springboot.model.User;
import com.example.springboot.model.UserBalance;
import com.example.springboot.service.UserBalanceService;
import com.example.springboot.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/userbalance")
public class UserBalanceController {
    @Autowired
	UserBalanceService userBalanceService;

	@GetMapping
    public ResponseEntity<List<UserBalance>> getUserBalances() {
		System.out.println("HERE!!!");
		return ResponseEntity.ok(userBalanceService.findAll());
	}

	@GetMapping("/{id}")
    public ResponseEntity<UserBalance> getUserBalanceById(@PathVariable String id) {
		UserBalance userBalance = userBalanceService.findById(id);
		if (userBalance == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(userBalance);
		}
	}

	@PostMapping
    public ResponseEntity<UserBalance> saveUserBalance(@RequestBody UserBalance userBalance) {
		userBalance.setId(UUID.randomUUID().toString());
		userBalanceService.insert(userBalance);
        return ResponseEntity.status(HttpStatus.CREATED).body(userBalance);
    }

	@PutMapping("/{id}")
	public ResponseEntity<UserBalance> updateUserBalanceById(@PathVariable String id, @RequestBody UserBalance userBalance) {
		userBalance.setId(id);
		userBalanceService.update(userBalance);
		return ResponseEntity.ok(userBalance);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserBalanceById(@PathVariable String id) {
		userBalanceService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
